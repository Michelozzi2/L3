package cdpoo.TP2_Pokemon;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class BroadcastMessage {
    private List<Socket> dresseurs_Sockets;
    private String message;


    public BroadcastMessage(List<Socket> dresseurs, String message) {
        this.dresseurs_Sockets = dresseurs;
        this.message = message;
    }

    public void send() {
        for (Socket socket : dresseurs_Sockets) {
            try {
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                writer.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}