package cdpoo.TP2_Pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainPokemon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Demande à l'utilisateur d'entrer son nom
            System.out.println("Veuillez entrer votre nom :");
            // Lit le nom de l'utilisateur depuis la console
            String nomDresseur = scanner.nextLine();
            // Efface la console
            System.out.print("\033\143");

            // Crée un objet File pour le fichier de sauvegarde du dresseur
            File file = new File("cdpoo/TP2_Pokemon/saves/" + nomDresseur + ".txt");
            // Déclare une variable pour le dresseur
            Dresseur dresseur;

            // Vérifie si le fichier de sauvegarde du dresseur existe
            if (file.exists()) {
                // Crée une instance de la classe Open_Save pour ouvrir la sauvegarde
                Open_Save openSave = new Open_Save();
                // Si le fichier existe, affiche un message de bienvenue
                System.out.println("Bienvenue, " + nomDresseur + " !");
                // Ouvre la sauvegarde du dresseur
                dresseur = openSave.ouvrirSave("cdpoo/TP2_Pokemon/saves/" + nomDresseur + ".txt");
            } else {
                // Si le fichier n'existe pas, affiche un message indiquant qu'un nouveau
                // dresseur est créé
                System.out.println("Création d'un nouveau dresseur...");
                // Crée un nouveau dresseur avec le nom entré par l'utilisateur
                dresseur = new Dresseur(nomDresseur);
            }

            // Crée une instance de la classe ReadXLSX pour lire les données du fichier XLSX
            ReadXLSX reader = new ReadXLSX();
            // Lit les données du fichier XLSX et les stocke dans la liste Pokemon_liste
            List<List<String>> Pokemon_liste = reader.readXLSX();
            // Initialise les Pokémon à partir des données de la liste Pokemon_liste
            Creation_Pokemon.Initialisation_pokemon(Pokemon_liste);

            // Récupère les listes de Pokémon non évolués, de première évolution et de
            // deuxième évolution
            List<Pokemon> nonEvoPokemons = Creation_Pokemon.getNonEvo();
            List<Pokemon_evolution1> evo1Pokemons = Creation_Pokemon.getEvo1();
            List<Pokemon_evolution2> evo2Pokemons = Creation_Pokemon.getEvo2();

            // Déclare une variable pour stocker le choix de l'utilisateur
            String choix;

            // Boucle jusqu'à ce que l'utilisateur choisisse de quitter
            do {
                // Affiche le menu
                System.out.println("Veuillez choisir une option :");
                System.out.println("1. Consulter les Pokemons attrapés ");
                System.out.println("2. Consulter l'équipe");
                System.out.println("3. Attraper les Pokemons");
                System.out.println("4. Combat MultiJoueur");
                System.out.println("5. Quitter");

                // Lit le choix de l'utilisateur
                choix = scanner.nextLine();
                // Efface la console
                System.out.print("\033\143");

                // Exécute une action en fonction du choix de l'utilisateur
                switch (choix) {
                    // Si le choix est 1, affiche les pokemons attrapés
                    case "1":
                        dresseur.afficherPokemonAttrape();
                        System.out.println("\n1. Voulez vous faire évoluer un Pokémon?");
                        System.out.println("\n2. Voulez vous transférer un Pokémon ?");
                        System.out.println("\n3. Voulez vous retourner au menu principal ?");
                        System.out.println("------------------------------------------------------------");
                        String r1 = scanner.nextLine();
                        if (r1.equals("1")) {
                            System.out.println("\nQuel pokémon voulez vous faire évoluer ? (1,2,3,...)");
                            int choixPokemon = scanner.nextInt();
                            try {
                                dresseur.evoluerPokemon(choixPokemon, nonEvoPokemons, evo1Pokemons, evo2Pokemons);
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("ERREUR : L'index est hors des limites de la liste.");
                            }
                            Thread.sleep(4000);
                            System.out.print("\033\143");
                            break;
                        } else if (r1.equals("2")) {
                            System.out.println("\nQuel pokémon voulez vous transférer ? (1,2,3,...)");
                            int choixPokemon = scanner.nextInt();
                            try {
                                dresseur.transfererPokemon(choixPokemon);
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("ERREUR : L'index est hors des limites de la liste.");
                            }
                            Thread.sleep(4000);
                            System.out.print("\033\143");
                            break;
                        } else if (r1.equals("3")) {
                            System.out.print("\033\143");
                            break;
                        }

                    case "2":

                        System.out.println("\nVoici votre équipe actuelle de Pokémon :");
                        dresseur.afficherEquipe();

                        System.out.println("\nVoulez-vous ajouter un Pokémon à votre équipe ? (O/N)");
                        dresseur.afficherPokemonAttrape();
                        String ajout = scanner.nextLine();
                        if (ajout.equals("O")) {
                            System.out.println("\nQuel Pokémon voulez-vous ajouter ? (1,2,3,...)");
                            int choixPokemon = scanner.nextInt();
                            try {
                                dresseur.ajouterEquipe(choixPokemon);
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("ERREUR : L'index est hors des limites de la liste.");
                            }
                        }

                        System.out.println("\nVoulez-vous retirer un Pokémon de votre équipe ? (O/N)");
                        String retrait = scanner.nextLine();
                        if (retrait.equals("O")) {
                            System.out.println("\nQuel Pokémon voulez-vous retirer ? (1,2,3,...)");
                            int choixPokemon = scanner.nextInt();
                            try {
                                dresseur.supprimerEquipe(choixPokemon);
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("ERREUR : L'index est hors des limites de la listes.");
                            }
                        } else {
                            System.out.println("\n Retour au menu principal");
                            break;
                        }
                        // Si le choix est 3, lance la méthode chassePokemon
                    case "3":
                        String r3 = "";
                        do {
                            // Appelle la méthode chassePokemon de l'objet dresseur
                            dresseur.chassePokemon(nonEvoPokemons, scanner);
                            // Demande à l'utilisateur s'il veut retourner au menu principal
                            System.out.println("Voulez vous retourner au menu principal ? (O/N)");
                            // Lit la réponse de l'utilisateur
                            r3 = scanner.nextLine();
                            // Si l'utilisateur veut retourner au menu principal
                            if (r3.equals("O")) {
                                // Efface la console
                                System.out.print("\033\143");
                            }
                        } while (!r3.equals("O"));
                        break;

                    case "4":

                        Dresseur.connectToServer(dresseur);

                        break;

                    // Si le choix est 5, quitte le programme et enregistre la sauvegarde
                    case "5":
                        System.out.println("Au revoir !");
                        // Crée un nouvel objet Save_dresseur
                        Save_dresseur save = new Save_dresseur();
                        // Enregistre l'objet dresseur dans un fichier
                        save.enregistrerDresseur(dresseur, "cdpoo/TP2_Pokemon/saves/" + nomDresseur + ".txt");
                        break;
                }
            } while (!choix.equals("5"));

        } catch (IndexOutOfBoundsException e) {
            System.out.println("L'index est hors des limites de la liste.");
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier de sauvegarde n'a pas pu être trouvé ou ouvert.");
        } catch (IOException e) {
            System.out.println("Une erreur d'entrée/sortie s'est produite.");
        } catch (ClassNotFoundException e) {
            System.out.println("Une classe nécessaire n'a pas été trouvée.");
        } catch (InterruptedException e) {
            System.out.println("Le thread a été interrompu.");
        } catch (Exception e) {
            // Attrape toute autre exception non spécifiquement gérée ci-dessus
            e.printStackTrace();
        } finally {
            // Ferme le scanner dans le bloc finally pour s'assurer qu'il est fermé même si
            // une exception est levée
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}