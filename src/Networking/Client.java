package Networking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    Socket socket;
    BufferedReader br;
    PrintWriter out;
    public Client() {
        try {
            socket = new Socket("192.168.249.119", 4040);
            System.out.println("connection done.");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            starReading();
            startWriting();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        System.out.println("client start...");
        new Client();
    }

    public void starReading() {
        // thread -read
        Runnable r1 = ()-> {
            try {
            while (true) {

                    String msg = br.readLine();
                    System.out.println("client: "+msg);
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
