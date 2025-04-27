package com.server.network;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ResourceBundle;

public class Server {
    private static int clientCount = 0;
    private static long lastClientConnectedTime = System.currentTimeMillis();

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        ResourceBundle bundle = ResourceBundle.getBundle("server");
        int serverPort = Integer.parseInt(bundle.getString("SERVER_PORT"));
        System.out.println("Сервер запускается...");
        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {
            System.out.println("Сервер запущен на порте " + serverPort + "!");
            startMonitoring();
            while (true) {
                Socket clientAccepted = serverSocket.accept();
                clientCount++;
                lastClientConnectedTime = System.currentTimeMillis();
                System.out.println("Соединение установлено... Текущее количество клиентов: " + clientCount);
                new Thread(new ClientThread(clientAccepted)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startMonitoring() {
        ResourceBundle bundle = ResourceBundle.getBundle("server");
        long monitoringInterval = Long.parseLong(bundle.getString("MONITORING_INTERVAL"));
        long shutdownTime = Long.parseLong(bundle.getString("SHUTDOWN_TIME"));
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(monitoringInterval);
                    long currentTime = System.currentTimeMillis();
                    if (clientCount == 0 && (currentTime - lastClientConnectedTime) >= shutdownTime) {
                        System.out.println("Нет подключенных клиентов. Сервер завершает работу.");
                        System.exit(0);
                    }
                    System.out.println("Текущее количество клиентов: " + clientCount);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

    public static synchronized void decrementClientCount() {
        clientCount--;
    }
}