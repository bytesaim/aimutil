package com.bytesaim.util;

import java.io.*;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * @author Adewale Azeez <azeezadewale98@gmail.com>
 */
public class AimHTTP {

    private static boolean useProxyStatic = false;

    private static String proxyHostStatic = "";

    private static int proxyPortStatic = 8080;

    private static String proxyUserNameStatic = "";

    private static String proxyPasswordStatic = "";

    /**
     * https://stackoverflow.com/a/921400/6626422
     *
     * @param url
     * @param savePath
     * @throws IOException
     */
    public static boolean DownloadFile(String url, String savePath) throws IOException {
        FileOutputStream fos = null ;
        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        fos = new FileOutputStream(savePath);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        return true;
    }

    public static String GetRawBody(String urlToRead) throws Exception {
        HttpURLConnection conn = GetConnection(urlToRead);
        StringBuilder result = new StringBuilder();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
            result.append("\n");
        }
        rd.close();
        return result.toString();
    }

    public static String GetRawBody(String urlToRead, String method, String body) throws Exception {
        HttpURLConnection conn = GetConnection(urlToRead);
        StringBuilder result = new StringBuilder();
        conn.setRequestMethod(method);
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        os.write(body.getBytes());
        os.flush();
        os.close();

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
            result.append("\n");
        }
        rd.close();
        return result.toString();
    }

    public static String SendHTTPReques(String urlToRead, String method, String params) throws Exception {
        HttpURLConnection conn = GetConnection(urlToRead);
        StringBuilder result = new StringBuilder();
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
        writer.write(params);
        writer.flush();
        writer.close();
        os.close();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
            result.append("\n");
        }
        rd.close();
        return result.toString();
    }

    public static void EnableProxy(boolean useProxyP) {
        useProxyStatic = useProxyP;
    }

    public static void ChangeProxySettings(String host, int port, String userName, String password) {
        proxyHostStatic = host;
        proxyPortStatic = port;
        proxyUserNameStatic = userName;
        proxyPasswordStatic = password;
    }

    public static HttpURLConnection GetConnection(String urlToRead) throws IOException {
        HttpURLConnection conn;
        URL url = new URL(urlToRead);
        if (useProxyStatic) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHostStatic, proxyPortStatic));
            if (!proxyUserNameStatic.isEmpty()) {
                Authenticator authenticator = new Authenticator() {
                    public PasswordAuthentication getPasswordAuthentication() {
                        return (new PasswordAuthentication(
                                proxyUserNameStatic,
                                proxyPasswordStatic.toCharArray()));
                    }
                };
                Authenticator.setDefault(authenticator);
            }
            conn = (HttpURLConnection) url.openConnection(proxy);
        } else {
            conn = (HttpURLConnection) url.openConnection();
        }
        return conn;
    }

}
