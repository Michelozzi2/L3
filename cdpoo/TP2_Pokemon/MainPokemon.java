package cdpoo.TP2_Pokemon;

import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class MainPokemon {
    private static Socket connectToServer() { // Ajout d'une méthode pour se connecter au serveur
        Socket socket = null;
        try {
            socket = new Socket("localhost", AreneServeur.PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return socket;
    }
    public static void main(String[] args) {
        connectToServer(); // Connexion au serveur
        Scanner scanner = new Scanner(System.in);
        try {

            // recupère le nom inscrit dans la console
            System.out.println("Veuillez entrer votre nom :");
            String nomDresseur = scanner.nextLine();
            System.out.print("\033\143");
            // Crée une référence à un fichier avec le nom du dresseur dans le dossier
            // "saves"
            File file = new File("cdpoo/TP2_Pokemon/saves/" + nomDresseur + ".txt");
            // Déclare une variable pour le dresseur
            Dresseur dresseur;
            // Crée une instance de la classe Open_Save pour ouvrir
            Open_Save openSave = new Open_Save();

            // Vérifie si le fichier du dresseur existe
            if (file.exists()) {
                // Si le fichier existe, affiche un message de bienvenue
                System.out.println("Bienvenue, " + nomDresseur + " !");
                // Ouvre la sauvegarde du dresseur
                dresseur = openSave.ouvrirSave("cdpoo/TP2_Pokemon/saves/" + nomDresseur + ".txt");
                // Efface la console
            } else {
                // Si le fichier n'existe pas, affiche un message indiquant qu'un nouveau
                // dresseur est créé
                System.out.println("Création d'un nouveau dresseur...");
                // Crée un nouveau dresseur avec le nom rentrer dans la console (à la 10lignes)
                dresseur = new Dresseur(nomDresseur);
            }
            ReadXLSX reader = new ReadXLSX();
            // Lecture des données du fichier XLSX et stockage dans la liste Pokemon_liste
            List<List<String>> Pokemon_liste = reader.readXLSX();
            Creation_Pokemon.Initialisation_pokemon(Pokemon_liste);
            List<Pokemon> nonEvoPokemons = Creation_Pokemon.getNonEvo();
            String choix;
            do {
                System.out.println("Veuillez choisir une option :");
                System.out.println("1. Consulter les Pokemons attrapés ");
                System.out.println("2. Consulter les Bonbons");
                System.out.println("3. Attraper les Pokemons");
                //
                System.out.println("4. Quitter");

                choix = scanner.nextLine();
                System.out.print("\033\143");

                switch (choix) {
                    case "1":
                        dresseur.afficherPokemonAttrape();
                        System.out.println("Voulez vous retourner au menu principal ? (O/N)");
                        String r = scanner.nextLine();
                        if (r.equals("O")) {
                            System.out.print("\033\143");
                            break;
                        }
                    case "2":
                        dresseur.afficherbonbons();
                        break;

                    case "3":
                        dresseur.chassePokemon(nonEvoPokemons, scanner);
                        System.out.println("Voulez vous retourner au menu principal ? (O/N)");
                        String r1 = scanner.nextLine();
                        if (r1.equals("O")) {
                            System.out.print("\033\143");
                            break;
                        }
                    case "4":
                        System.out.println("Au revoir !");
                        Save_dresseur save = new Save_dresseur();
                        save.enregistrerDresseur(dresseur, "cdpoo/TP2_Pokemon/saves/" + nomDresseur + ".txt");
                        break;

                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                        break;
                }
            } while (!choix.equals("4"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
