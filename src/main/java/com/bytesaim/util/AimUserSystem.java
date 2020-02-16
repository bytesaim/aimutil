package com.bytesaim.util;

import java.util.Properties;

/**
 * @author Adewale Azeez <azeezadewale98@gmail.com>
 */
public class AimUserSystem {

    public static Properties properties = System.getProperties();
    public static String USER_NAME = properties.getProperty("user.name");
    public static String USER_HOME = properties.getProperty("user.home");
    public static String OS = properties.getProperty("os.name");
    public static String CPU_ARCH = properties.getProperty("sun.arch.data.model");

    public static boolean IsWindows() {
        return OS.startsWith("Windows");
    }

    public static boolean IsMac() {
        return OS.startsWith("Mac");
    }

    public static boolean IsLinux() {
        return OS.startsWith("Linux");
    }

    public static String GetWindowsAutoStartFolder() {
        return System.getProperty("java.io.tmpdir").replace("Local\\Temp\\", "Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup");
    }
}
