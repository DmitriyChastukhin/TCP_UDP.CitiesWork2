package org.example.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final int PORT = 8989;
    private static final String LOCALHOST = "127.0.0.1";

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(LOCALHOST, PORT);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            // Считывание название города
            System.out.println(reader.readLine());
            String response;

            // Ввод и запись названия города
            BufferedReader responseRead = new BufferedReader(new InputStreamReader(System.in));
            response = responseRead.readLine();
            writer.println(response);

            // Считывание названия города от сервера
            System.out.println(reader.readLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}