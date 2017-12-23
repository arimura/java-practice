package com.hormiga6.javapractice.concurrent;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkService implements Runnable {
    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    public NetworkService(int port, int poolSize) throws IOException {
        serverSocket = new ServerSocket(port);
        pool = Executors.newFixedThreadPool(poolSize);
    }

    @Override
    public void run() {
        try {
            for(;;) {
                pool.execute(new Handler(serverSocket.accept()));
            }
        }catch (IOException ex) {
            pool.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            NetworkService networkService = new NetworkService(8082, 2);
            new Thread(networkService).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler implements Runnable {
    private final Socket socket;
    Handler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try(OutputStream outputStream = socket.getOutputStream()) {
            Date today = new Date();
            String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
            outputStream.write(httpResponse.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
