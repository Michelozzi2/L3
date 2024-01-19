package cdpoo.TD5.exo4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class BroadcastMessage {
    private List<Socket> clients;

    public BroadcastMessage(List<Socket> clients) {
        this.clients = clients;
    }

    public void send(String message, Socket sender) {
        for (Socket client : clients) {
            if (client != sender) {
                PrintWriter out = null;
                try {
                    out = new PrintWriter(client.getOutputStream(), true);
                    out.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}