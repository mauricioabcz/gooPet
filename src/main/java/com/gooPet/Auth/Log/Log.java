package com.gooPet.Auth.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author mauricio.rodrigues
 */
public class Log {
    public static void LogAuthenticationComponent(String entityName, String logLevel, String logMessage) {
        // Verifica se a pasta "logs" existe e cria se necessário
        File logsFolder = new File("logs");
        if (!logsFolder.exists()) {
            logsFolder.mkdir();
        }

        // Verifica se o arquivo "log.txt" existe e cria se necessário
        File logFile = new File("logs/autheticationComponentlog.txt");
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred while creating the log file.");
                e.printStackTrace();
                return;
            }
        }

        // Imprime mensagem no console
        System.out.println(logMessage);

        // Grava mensagem no arquivo
        try (FileWriter fileWriter = new FileWriter(logFile, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            String formattedDateTime = now.format(formatter);

            String logEntry = formattedDateTime + " | " + entityName + " | " + logLevel + " | " + logMessage;
            bufferedWriter.write(logEntry);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the log file.");
            e.printStackTrace();
        }
    }
}
