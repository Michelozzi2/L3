package cdpoo.TD5.exo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * La classe AcceptClient accepte les connexions client entrantes, les ajoute à une liste et crée un
 * nouveau thread pour gérer l'entrée de chaque client et la diffuser à tous les autres clients.
 */
public class AcceptClient extends Thread {
    private ServerSocket server;
    private List<Socket> clients;
    private BroadcastMessage broadcaster;

    public AcceptClient(ServerSocket server, List<Socket> clients) {
        this.server = server;
        this.clients = clients;
        this.broadcaster = new BroadcastMessage(clients);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket client = server.accept();
                clients.add(client);
                new Thread(() -> {
                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        String message;
                        while ((message = in.readLine()) != null) {
                            broadcaster.send(message, client);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}