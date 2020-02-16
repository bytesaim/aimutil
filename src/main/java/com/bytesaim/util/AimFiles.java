package com.bytesaim.util;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @author Adewale Azeez <azeezadewale98@gmail.com>
 */
public class AimFiles {

    /**
     * https://stackoverflow.com/a/326440/6626422
     *
     * @param path
     * @param encoding
     * @return
     * @throws IOException
     */
    public static String ReadFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path.trim()));
        return new String(encoded, encoding);
    }

    public static String ReadResourceFileAsString(InputStream is, Charset encoding) {
        return new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
    }

    public static String ReadResourceFileAsString(String path, Charset encoding) {
        InputStream is = AimFiles.class.getResourceAsStream(path);
        return new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
    }

    public static void DeleteFolder(String folderPath) throws IOException {
        Files.walk(Paths.get(folderPath))
                .map(Path::toFile)
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .forEach(File::delete);
    }

    public static byte[] InputStreamAsBytes(InputStream is) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384];
        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        return buffer.toByteArray();
    }

    public static String InputStreamAsString(InputStream is) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    }

}
