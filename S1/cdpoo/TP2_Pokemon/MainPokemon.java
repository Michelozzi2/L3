package cdpoo.TP2_Pokemon;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class MainPokemon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("==================================================");
            System.out.println("Bienvenue dans le jeu Pokemon !");
            System.out.println("==================================================");
            System.out.print("Veuillez entrer votre nom : ");
            // Lit le nom de l'utilisateur depuis la console
            String nomDresseur = scanner.nextLine();
            // Efface la console
            System.out.print("\033\143");

            File file = new File("cdpoo/TP2_Pokemon/saves/" + nomDresseur + ".txt");
            Dresseur dresseur;

            // Vérifie si le fichier de sauvegarde du dresseur existe
            if (file.exists()) {
                // Crée une instance de la classe Open_Save pour ouvrir la sauvegarde
                Open_Save openSave = new Open_Save();
                System.out.println("Bienvenue, " + nomDresseur + " !");
                // Ouvre la sauvegarde du dresseur
                dresseur = openSave.ouvrirSave("cdpoo/TP2_Pokemon/saves/" + nomDresseur + ".txt");
            } else {
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
                System.out.println("==================================================");
                System.out.println("MENU PRINCIPAL");
                System.out.println("==================================================");
                System.out.println("1. Consulter les Pokemons attrapés");
                System.out.println("2. Consulter l'équipe");
                System.out.println("3. Attraper les Pokemons");
                System.out.println("4. Combat MultiJoueur");
                System.out.println("5. Quitter");
                System.out.println("==================================================");
                System.out.print("Votre choix : ");

                choix = scanner.nextLine();

                // Efface la console
                System.out.print("\033\143");

                // Exécute une action en fonction du choix de l'utilisateur
                switch (choix) {
                    // Si le choix est 1, affiche les pokemons attrapés
                    case "1":
                        System.out.println("\n==================================================");
                        System.out.println("POKEMONS ATTRAPÉS");
                        System.out.println("==================================================");
                        dresseur.afficherPokemonAttrape();
                        System.out.println("==================================================");
                        System.out.println("1. Faire évoluer un Pokémon");
                        System.out.println("2. Transférer un Pokémon");
                        System.out.println("3. Retourner au menu principal");
                        System.out.println("==================================================");
                        System.out.print("Votre choix : ");
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

                        System.out.println("\n==================================================");
                        System.out.println("ÉQUIPE ACTUELLE");
                        System.out.println("==================================================");
                        dresseur.afficherEquipe();
                        System.out.println("==================================================");
                        System.out.println("Voulez-vous ajouter ou retirer un Pokémon de votre équipe ? (O/N)");
                        System.out.println("==================================================");
                        dresseur.afficherPokemonAttrape();
                        System.out.print("Votre choix : ");
                        String ajout = scanner.nextLine();
                        if (ajout.equals("O")||ajout.equals("o")) {
                            System.out.println("\nQuel Pokémon voulez-vous ajouter ? (0,1,2,3,...)");
                            int choixPokemon = scanner.nextInt();
                            try {
                                dresseur.ajouterEquipe(choixPokemon);
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("ERREUR : L'index est hors des limites de la liste.");
                            }
                        }

                        System.out.println("\nVoulez-vous retirer un Pokémon de votre équipe ? (O/N)");
                        String retrait = scanner.nextLine();
                        if (retrait.equals("O")||retrait.equals("o")) {
                            System.out.println("\nQuel Pokémon voulez-vous retirer ? (0,1,2,3,...)");
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
                            dresseur.chassePokemon(nonEvoPokemons, scanner);
                            System.out.println("\n==================================================");
                            System.out.println("Voulez-vous retourner au menu principal ? (O/N)");
                            System.out.println("==================================================");
                            System.out.print("Votre choix : ");
                            r3 = scanner.nextLine();
                            if (r3.equals("O")||r3.equals("o")) {
                                System.out.println("\nRetour au menu principal...\n");
                                break;
                            }
                        } while (!r3.equals("O")||!r3.equals("o"));
                        break;
                       

                    case "4":

                        Dresseur.connectToServer(dresseur);
                        break;

                    // Si le choix est 5, quitte le programme et enregistre la sauvegarde
                    case "5":
                        Save_dresseur save = new Save_dresseur();
                        save.enregistrerDresseur(dresseur, "cdpoo/TP2_Pokemon/saves/" + nomDresseur + ".txt");
                        System.out.print("\033\143");
                        System.out.println("\n========================================");
                        System.out.println("Merci d'avoir joué. À bientôt !");
                        System.out.println("========================================");
                        break;
                }
            } while (!choix.equals("5"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}