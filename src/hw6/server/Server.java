package hw6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static boolean serverWorks;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        serverWorks = true;
        Socket connected = serverSocket.accept();
        System.out.printf("User %s connected%n", connected.getInetAddress());
        DataInputStream in = new DataInputStream(connected.getInputStream());
        DataOutputStream out = new DataOutputStream(connected.getOutputStream());
        Scanner input = new Scanner(System.in);
        Thread outputThread = new Thread(() -> {
            while (serverWorks) {
                String message = input.nextLine();
                if (serverWorks) {
                    try {
                        out.writeUTF(message);
                        out.flush();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        outputThread.start();
        Thread inputThread = new Thread(() -> {
            while (serverWorks) {
                try {
                    String messageFromUser = in.readUTF();
                    if (messageFromUser.equals("exit")) {
                        serverWorks = false;
                        out.writeUTF("See you!");
                        out.flush();
                        System.out.println("Type sth to exit");
                    } else {
                        System.out.printf("%s: %s%n", connected.getInetAddress(), messageFromUser);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        inputThread.start();
    }
}
