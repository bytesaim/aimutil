package com.bytesaim.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author Adewale Azeez <azeezadewale98@gmail.com>
 */
public class AimLogger {

    private static String LogFilePath = "aimlogger.log" ;

    public static void ChangeLogFilePath(String logFilePath) {
        LogFilePath = (logFilePath != null && !logFilePath.isEmpty() ? logFilePath : LogFilePath);
    }

    /**
     *
     * @param ex
     * @param logFilePath
     */
    public static void WriteLog(Exception ex, String logFilePath) {
        ex.printStackTrace();
        try(FileWriter w = new FileWriter(logFilePath, true)) {
            w.write(new Date().toString() + ": ");
            ex.printStackTrace(new PrintWriter(w));
            w.write("\n");
            w.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param message
     * @param logFilePath
     */
    public static void WriteLog(String message, String logFilePath) {
        message = new Date().toString() + ": " + message;
        System.out.println(message);
        try(FileWriter w = new FileWriter(logFilePath, true)) {
            w.write(message+"\n");
            w.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Log(Exception ex) {
        WriteLog(ex, LogFilePath);
    }

    public static void Log(String message) {
        WriteLog(AimLogger.class.getCanonicalName() + ": " + message, LogFilePath);
    }

}
