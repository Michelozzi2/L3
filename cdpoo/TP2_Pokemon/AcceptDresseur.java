package cdpoo.TP2_Pokemon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class AcceptDresseur extends Thread {
    private ServerSocket server;
    private List<Socket> dresseurs_Sockets;
    public static List<Dresseur> dresseurs_Connected = new ArrayList<>();

    public AcceptDresseur(ServerSocket server, List<Socket> dresseurs_Sockets) {
        this.server = server;
        this.dresseurs_Sockets = dresseurs_Sockets;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = server.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Dresseur d = (Dresseur) objectInputStream.readObject();
                dresseurs_Connected.add(d);
                dresseurs_Sockets.add(socket);

                System.out.println("Nombre de dresseurs connectés : " + dresseurs_Connected.size());

                BroadcastMessage broadcastMessage = new BroadcastMessage(dresseurs_Sockets,
                        "Un nouveau client s'est connecté !");
                broadcastMessage.send();

            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Une erreur est survenue : " + e.getMessage());
                e.printStackTrace();
            }
        }
    }    
}