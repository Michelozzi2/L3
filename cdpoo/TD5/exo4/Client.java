package cdpoo.TD5.exo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;



public class Client {
    
     public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 2000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = in.readLine();
            System.out.println(message);
        } catch (UnknownHostException e) {
            System.out.println("The host is unknown.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An I/O error occurred.");
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while closing the socket.");
                    e.printStackTrace();
                }
            }
        }
    }

}
