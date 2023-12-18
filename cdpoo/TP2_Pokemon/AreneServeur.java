// AreneServeur.java
package cdpoo.TP2_Pokemon;

import java.net.*;
import java.util.ArrayList;
import java.util.Random;

//classe du Serveur 
public class AreneServeur {
    public static ArrayList <ThreadClientInServer> listeCo = new ArrayList<>();
    public static ArrayList <ThreadClientInServer> attente = new ArrayList<>();

    //envoi d'un message à tous les clients
    public static void broadcast() {
        for(ThreadClientInServer i :listeCo){
            i.fromServer("le combat va debuter ..");
        }
    }

    //permet de renommer un thread pour differencier les joueurs
    public static void rename(Socket nomsSocket,String name){
        for(ThreadClientInServer i: listeCo){
            if(i.serverClient.equals(nomsSocket)){
                i.setName(name);
            }
        }
    }

    //envoi d'un message à un seul joueur
    public static void  messagePerso(String nomsSocket,ThreadClientInServer expediteur,String message){
        for(ThreadClientInServer i: listeCo){
            System.out.println(i.getName());
            if(i.getName().equals(nomsSocket)){
                i.fromServer(message);
            }
        }
    }


    //la fonction decide qui commencera premier et declanche le combat dans les TCP
    //cela est déterminé à pile ou face
    public static void arene(ThreadClientInServer joueur){
        attente.add(joueur); 
        System.out.println(attente.size());
        if(attente.size()==2){
            Random r=new Random();
            int num=r.nextInt(2);
            ThreadClientInServer j1,j2;
            if(num==1){
                j1=attente.get(1);
                j2=attente.get(0);
            }
            else{
                j1=attente.get(0);
                j2=attente.get(1);
            }
            //modifie l'attribut adversaire du ServerThread afin qu'il connaisse le thread de son adversaire pour utiliser la fonction MessagePerso
            j1.setAdverssaire(j2.getName());
            j2.setAdverssaire(j1.getName());
            j1.fromServer("premier");
            j2.fromServer("second");
            //supprime la liste d'attente
            attente.clear();
        }
        else if (attente.size()>2){
            joueur.fromServer("trop de joueur connecté dans l'arene");
        }
    }

    //renvoi la liste des joueurs dans un format lisible
    public static String format(){
        String mess="";
        for(ThreadClientInServer i:listeCo){
            mess+=i+"\n";
        }
        return mess;
    }
    //le serveur enregistre les joueurs qui se connectent et les stocke dans une liste puis 
    //demarre un thread pour chaque joueur
    public static void main(String[] args) throws Exception {
        try{
            try (ServerSocket server = new ServerSocket(8888)) {
                int counter=0;
                System.out.println("Server Started ....");
                while(true){
                    counter++;
                    Socket serverClient=server.accept();  //serveur accepte le client 
                    System.out.println(" >> " + "Client No:" + counter + " started!");
                    ThreadClientInServer sct = new ThreadClientInServer(serverClient,counter); //demarre le thread
                    AreneServeur.listeCo.add(sct);
                    System.out.println(listeCo.size() + "size");
                    sct.start();
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}