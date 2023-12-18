package cdpoo.TP2_Pokemon;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

//thread demarré par le serveur unique à chaque client
//permet au client de communiquer avec le serveur
class ThreadClientInServer extends Thread {
    Socket serverClient;
    int clientNo;
    String threadDest;
  
    ThreadClientInServer(Socket inSocket,int counter){
      serverClient = inSocket;
      clientNo=counter;
    }

    //redistribue un message venant du serveur
    //fait le pont entre serveur et TCP
    public void fromServer(String mess){
      try {
        DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
        outStream.writeUTF(mess);
        outStream.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    //cela permettra au thread de communiquer des messages spécifiquement au thread de l'adversaire
    public void setAdverssaire(String name){
      this.threadDest = name;
    }
    
    //redef de la fonction run()
    public void run() {
      try {
        DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
        DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
        String clientMessage = "", serverMessage = "";
        
        // On écoute le client en continu et on attend de lui
        // soit un message soit une commande
        while (!clientMessage.equals("quit")) {
          clientMessage = inStream.readUTF();

          // Le joueur souhaite connaitre la liste des autres joueurs connectés à l'arène
          if (clientMessage.equals("joueur")) {
            serverMessage = "Liste des joueurs connectés:\n" + AreneServeur.format();
            outStream.writeUTF(serverMessage);
            outStream.flush();
          }
          // Le joueur souhaite effectuer un combat
          // Il est placé dans la liste d'attente jusqu'à ce qu'un adversaire rejoigne la salle d'attente
          else if (clientMessage.equals("combat")) {
            AreneServeur.arene(this);
          }
          // Renomme le nom du thread
          else if (clientMessage.contains("name")) {
            AreneServeur.rename(serverClient, clientMessage.split(" ")[1]);
          }
          // Communication utilisée lors du combat afin de transmettre les dégâts infligés de part et d'autre
          else {
            AreneServeur.messagePerso(threadDest, this, clientMessage);
          }
        }

        // Client décide de quitter le combat, envoie "exit" pour terminer la connexion proprement
        outStream.writeUTF("exit");
        outStream.flush();

        inStream.close();
        outStream.close();
        serverClient.close();
      } catch (Exception ex) {
        System.out.println(ex);
      } finally {
        System.out.println("Client - " + clientNo + " exit!!");
      }
    }
}
