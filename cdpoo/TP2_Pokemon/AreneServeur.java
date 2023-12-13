// AreneServeur.java
package cdpoo.TP2_Pokemon;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class AreneServeur {
    public static List<Socket> dresseurs_Socket = new ArrayList<>();
    public static final int PORT = 2000; // Ajout d'une constante pour le port

    
    public static void main(String[] args) {
        ServerSocket server;

        try {
            server = new ServerSocket(PORT);
            AcceptDresseur dresseur = new AcceptDresseur(server, dresseurs_Socket);
            dresseur.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}