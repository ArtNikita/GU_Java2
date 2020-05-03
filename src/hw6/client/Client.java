package hw6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static boolean connected;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        System.out.println("Connected to server");
        connected = true;
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        Scanner input = new Scanner(System.in);
        Thread outputThread = new Thread(()->{
            while (connected){
                String message = input.nextLine();
                try {
                    out.writeUTF(message);
                    out.flush();
                    if (message.equals("exit")){
                        connected = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        outputThread.start();

        Thread inputThread = new Thread(()->{
            while (connected){
                try {
                    String messageFromServer = in.readUTF();
                    System.out.printf("Server: %s%n", messageFromServer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        inputThread.start();
    }
}
