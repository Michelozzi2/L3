package cdpoo.TP2_Pokemon;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class AcceptDresseur extends Thread {
    private ServerSocket server;
    private List<Socket> dresseurs;

    public AcceptDresseur(ServerSocket server, List<Socket> dresseurs) {
        this.server = server;
        this.dresseurs = dresseurs;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = server.accept();
                dresseurs.add(socket);
                System.out.println("Un client s'est connecté !");
                BroadcastMessage broadcastMessage = new BroadcastMessage(dresseurs, "Un nouveau client s'est connecté !");
                broadcastMessage.send();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}