package Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket serverSocket;
    Socket socket;

    BufferedReader br;      // read
    PrintWriter out;        // write

    public Server() {
        try {
            serverSocket = new ServerSocket(4040);
            System.out.println("waiting...");
            socket = serverSocket.accept();

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            starReading();
            startWriting();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println("server start...");
        new Server();


    }

    public void starReading() {
        // thread -read
        Runnable r1 = ()-> {
            try {
            while (true) {

                    String msg = br.readLine();
                    System.out.println("server: "+msg);
                    if(msg.equalsIgnoreCase("exit")) {
                        socket.close();
                        break;
                    }

            }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        new Thread(r1).start();
    }

    public void startWriting() {
        // thread - send client
        Runnable r2 = ()-> {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String content = bufferedReader.readLine();
                out.println(content);
                out.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
        new Thread(r2).start();
    }


}
