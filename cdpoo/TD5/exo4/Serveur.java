package cdpoo.TD5.exo4;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.net.Socket;

public class Serveur {
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket server;

        try{
            server = new ServerSocket(2000);
            AcceptClient client = new AcceptClient(server, clients);
            client.start();

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}