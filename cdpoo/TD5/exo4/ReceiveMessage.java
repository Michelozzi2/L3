package cdpoo.TD5.exo4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class ReceiveMessage extends Thread {
    private BufferedReader in;

    public ReceiveMessage(Socket socket) throws IOException {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() {
        String message;
        try {
            while ((message = in.readLine()) != null) {
                System.out.println(message);
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
