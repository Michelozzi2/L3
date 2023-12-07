package cdpoo.TD5.exo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 2000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Entrez votre nom d'utilisateur:");
            String username = scanner.nextLine();
            out.println("newUser: " + username);

            new Thread(() -> {
                String message;
                try {
                    while ((message = in.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            String input;
            while ((input = scanner.nextLine()) != null) {
                out.println(username + ": " + input);
            }
            scanner.close();
        } catch (UnknownHostException e) {
            System.out.println("L'hôte est inconnu.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Une erreur d'E/S s'est produite.");
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Une erreur s'est produite lors de la fermeture du socket.");
                    e.printStackTrace();
                }
            }
        }
    }
}