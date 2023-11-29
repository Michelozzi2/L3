package cdpoo.TD5.exo4;


import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AcceptClient extends Thread {
    private Socket socket;
    private ServerSocket server;
    private PrintWriter out;

    public AcceptClient( ServerSocket server) {
        this.server = server;
    }

    public void run() {
        System.out.println("Le client est a l'ecoute sur le port 2000");
        int nbclient = 0;
        try{
            while(true){
                socket = server.accept();
                nbclient++;
                System.out.println("Le client numero " + nbclient + " est connecte");
                out = new PrintWriter(socket.getOutputStream());
                out.println("Bienvenue client numero " + nbclient);
                out.flush();
                socket.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
   
}