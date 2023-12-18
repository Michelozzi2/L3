package cdpoo.TP2_Pokemon;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
//import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Cette classe représente un dresseur de Pokémon.
 * Un dresseur possède un nom, une liste de Pokémon attrapés, une équipe de
 * Pokémon et un dictionnaire de bonbons.
 * Le dresseur peut attraper des Pokémon, les ajouter à son équipe, les
 * modifier, les supprimer, les transférer, les faire évoluer, etc.
 */
public class Dresseur implements Serializable {
    private String nom;
    private List<Object> pokemonAttrape = new ArrayList<>();
    private List<Pokemon> equipe = new ArrayList<>();
    private HashMap<String, Integer> dictionnaireBonbon = Bonbons.getDictionnaireBonbons();

    public Dresseur(String nom) {
        this.nom = nom;
    }

    static void connectToServer(Dresseur dresseur) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
            String clientMessage = "", serverMessage = "";

            // rename le thread dans le server avec le pseudo du joueur
            clientMessage = "name " + dresseur.getNom();
            outStream.writeUTF(clientMessage);
            outStream.flush();

            // demande de combattre dans l'arène et attend qu'un adversaire rejoigne
            clientMessage = "combat";
            outStream.writeUTF(clientMessage);
            outStream.flush();
            serverMessage = inStream.readUTF();
            System.out.println("vous venez d'entrer dans l'arène. Le combat commencera dès qu'un adversaire rejoindra");
            // le server désigne qui jouera en premier et qui jouera en second à pile ou
            // face

            if (serverMessage.equals("premier")) {
                System.out.println(serverMessage);
                combat1(dresseur, socket);
            } else {
                System.out.println(serverMessage);
                combat2(dresseur, socket);
            }

            outStream.close();
            inStream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void combat1(Dresseur dresseur, Socket socket) throws NumberFormatException, IOException {
        // Initialise les fonctions de communication avec le serveur
        DataInputStream inStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
        String clientMessage = "";
    
        int index = 0;
        while (!dresseur.getEquipe().isEmpty()) {
            Pokemon selfPokemon = (Pokemon) dresseur.getEquipe().get(index);
            int selfHp = selfPokemon.getPv();
            int result = 0;
    
            // Envoie les informations de son Pokémon à l'adversaire
            outStream.writeUTF(String.valueOf(selfHp));
            outStream.flush();
    
            // Gestion des types de Pokémon
            String type = selfPokemon.getType();
            String type1, type2;
            if (type.contains("/")) {
                String[] types = type.split("/");
                type1 = types[0];
                type2 = types[1];
            } else {
                type1 = type;
                type2 = "none";
            }
    
            outStream.writeUTF(type1);
            outStream.flush();
            outStream.writeUTF(type2);
            outStream.flush();
    
            outStream.writeUTF(selfPokemon.getNom());
    
            // Recoit les informations du Pokémon adverse
            int opponentHp = Integer.parseInt(inStream.readUTF());
            String opponentType1 = inStream.readUTF();
            String opponentType2 = inStream.readUTF();
            String opponentPokemon = inStream.readUTF();
    
            System.out.println("Adversaire trouvé: le combat va bientôt commencer");
            System.out.println("Vous êtes le 1er joueur");
            System.out.println("Vous envoyez " + selfPokemon.getNom() + " au combat");
            System.out.println("L'adversaire envoie un " + opponentPokemon + " au combat");
            System.out.println("PV de votre Pokémon: " + selfHp + "; PV du Pokémon adverse: " + opponentHp);
    
            // L'ordre est inversé en fonction du premier ou du deuxième joueur
            // Après l'attaque de l'adversaire, si le Pokémon est KO, le combat s'arrête
            while (selfHp >= 0 && opponentHp >= 0) {
                // Attaque le Pokémon adverse
                result = GestionTypeCombat.attackOnline(selfPokemon, opponentType1, opponentType2, selfPokemon.getNom(), opponentPokemon);
                opponentHp -= result;
                opponentHp = Math.max(opponentHp, 0); // Pour éviter d'avoir des PV négatifs
                System.out.println("Vous venez d'infliger " + result + " au Pokémon adverse");
                System.out.println("PV restant du Pokémon adverse: " + opponentHp);
                clientMessage = String.valueOf(result);
                outStream.writeUTF(clientMessage);
                outStream.flush();

                // Vérifie si le Pokémon adverse est KO avant de se faire attaquer
                if (opponentHp <= 0) {
                    break;
                }
    
                // Se fait attaquer
                result = Integer.parseInt(inStream.readUTF());
                selfHp -= result;
                selfHp = Math.max(selfHp, 0); // Pour éviter d'avoir des PV négatifs
                System.out.println("Le Pokémon adverse a attaqué, votre Pokémon a subi " + result + " dégâts");
                System.out.println("PV restant de votre Pokémon: " + selfHp);
    
                // Après la vérification de KO du Pokémon actuel
                if (selfHp <= 0) {
                    System.out.println("Votre Pokémon est KO!");
                    index++;
                    if (index < dresseur.getEquipe().size()) {
                        selfPokemon = (Pokemon) dresseur.getEquipe().get(index);
                        selfHp = selfPokemon.getPv();
                        System.out.println("Envoi du prochain Pokémon : " + selfPokemon.getNom());
    
                        // Envoi des PV, du nom et des types du nouveau Pokémon
                        outStream.writeUTF(String.valueOf(selfHp));
                        outStream.flush();
                        outStream.writeUTF(selfPokemon.getNom());
                        outStream.flush();
                        String[] newTypes = selfPokemon.getType().split("/");
                        outStream.writeUTF(newTypes[0]);
                        outStream.flush();
                        outStream.writeUTF(newTypes.length > 1 ? newTypes[1] : "none");
                        outStream.flush();
                    }
                    continue;

                }
                
    
            }
    
            if (opponentHp <= 0) {
                System.out.println("Félicitation, vous avez gagné!");
                continue;
            } else if (selfHp <= 0) {
                System.out.println("Votre Pokémon est KO!");
            } else {
                System.out.println("Erreur !!");
            }
        }
    }
    
    
    public static void combat2(Dresseur dresseur, Socket socket) throws NumberFormatException, IOException {
        // Initialise les fonctions de communication avec le serveur
        DataInputStream inStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
        String clientMessage = "";
    
        int index = 0;
        while (!dresseur.getEquipe().isEmpty()) {
            Pokemon selfPokemon = (Pokemon) dresseur.getEquipe().get(index);
            int selfHp = selfPokemon.getPv();
            int result = 0;
    
            // Envoie les informations de son Pokémon à l'adversaire
            outStream.writeUTF(String.valueOf(selfHp));
            outStream.flush();
    
            // Gestion des types de Pokémon
            String type = selfPokemon.getType();
            String type1, type2;
            if (type.contains("/")) {
                String[] types = type.split("/");
                type1 = types[0];
                type2 = types[1];
            } else {
                type1 = type;
                type2 = "none";
            }
    
            outStream.writeUTF(type1);
            outStream.flush();
            outStream.writeUTF(type2);
            outStream.flush();
    
            outStream.writeUTF(selfPokemon.getNom());
    
            // Recoit les informations du Pokémon adverse
            int opponentHp = Integer.parseInt(inStream.readUTF());
            String opponentType1 = inStream.readUTF();
            String opponentType2 = inStream.readUTF();
            String opponentPokemon = inStream.readUTF();
    
            System.out.println("Adversaire trouvé: le combat va bientôt commencer");
            System.out.println("Vous êtes le 2ème joueur");
            System.out.println("Vous envoyez " + selfPokemon.getNom() + " au combat");
            System.out.println("L'adversaire envoie un " + opponentPokemon + " au combat");
            System.out.println("PV de votre Pokémon: " + selfHp + "; PV du Pokémon adverse: " + opponentHp);
    
            // L'ordre est inversé en fonction du premier ou du deuxième joueur
            // Après l'attaque de l'adversaire, si le Pokémon est KO, le combat s'arrête
            while (selfHp >= 0 && opponentHp >= 0) {
                // Se fait attaquer
                result = Integer.parseInt(inStream.readUTF());
                selfHp -= result;
                selfHp = Math.max(selfHp, 0); // Pour éviter d'avoir des PV négatifs
                System.out.println("Le Pokémon adverse a attaqué, votre Pokémon a subi " + result + " dégâts");
                System.out.println("PV restant de votre Pokémon: " + selfHp);
    
                // Après la vérification de KO du Pokémon actuel
                if (selfHp <= 0) {
                    System.out.println("Votre Pokémon est KO!");
                    index++;
                    if (index < dresseur.getEquipe().size()) {
                        selfPokemon = (Pokemon) dresseur.getEquipe().get(index);
                        selfHp = selfPokemon.getPv();
                        System.out.println("Envoi du prochain Pokémon : " + selfPokemon.getNom());
                        
                        // Envoi des PV, du nom et des types du nouveau Pokémon
                        outStream.writeUTF(String.valueOf(selfHp));
                        outStream.flush();
                        outStream.writeUTF(selfPokemon.getNom());
                        outStream.flush();
                        String[] newTypes = selfPokemon.getType().split("/");
                        outStream.writeUTF(newTypes[0]);
                        outStream.flush();
                        outStream.writeUTF(newTypes.length > 1 ? newTypes[1] : "none");
                        outStream.flush();
                    }
                    continue;
                }

                if (inStream.available() > 0) {
                    opponentHp = Integer.parseInt(inStream.readUTF());
                    opponentPokemon = inStream.readUTF();
                    opponentType1 = inStream.readUTF();
                    opponentType2 = inStream.readUTF();
                } 

                if (opponentHp <= 0) {
                    break;
                }
                
                // Attaque le Pokémon adverse
                result = GestionTypeCombat.attackOnline(selfPokemon, opponentType1, opponentType2, selfPokemon.getNom(), opponentPokemon);
                opponentHp -= result;
                opponentHp = Math.max(opponentHp, 0); // Pour éviter d'avoir des PV négatifs
                System.out.println("Vous venez d'infliger " + result + " au Pokémon adverse");
                System.out.println("PV restant du Pokémon adverse: " + opponentHp);
                clientMessage = String.valueOf(result);
                outStream.writeUTF(clientMessage);
                outStream.flush();
            }
    
            if (opponentHp <=0 ) {
                System.out.println("Félicitation, vous avez gagné!");
                continue;
            } else if (selfHp <= 0) {
                System.out.println("Votre Pokémon est KO!");
                continue;
            } else {
                System.out.println("Erreur !!");
            }
        }
    }
    
    /**
     * Renvoie le nom du dresseur
     *
     * @return le nom du dresseur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Renvoie la liste des Pokémon attrapés par le dresseur.
     *
     * @return la liste des Pokémon attrapés
     */
    public List<Object> getPokemonAttrape() {
        return pokemonAttrape;
    }

    /**
     * Renvoie la liste des Pokémon de l'équipe du dresseur.
     *
     * @return la liste des Pokémon de l'équipe
     */
    public List<Pokemon> getEquipe() {
        return equipe;
    }

    /**
     * Ajoute un Pokémon attrapé à la liste des Pokémon du dresseur.
     * 
     * @param pokemonAttrape le Pokémon à ajouter
     */
    public void setPokemonAttrape(Pokemon pokemonAttrape) {
        this.pokemonAttrape.add(pokemonAttrape);
    }

    public void setEquipe(List<Pokemon> equipe) {
        this.equipe = equipe;
    }

    /**
     * Méthode permettant de chasser un Pokémon en faisant un random dans une liste
     * de Pokémons.
     * 
     * @param lootbox la liste de Pokémons dans laquelle chasser
     * @param lire    le scanner pour lire la réponse de l'utilisateur
     */
    public void chassePokemon(List<Pokemon> lootbox, Scanner lire) {
        // Crée un nouvel objet Random
        Random random = new Random();

        // Sélectionne un index aléatoire dans la liste de Pokémons
        int index = random.nextInt(lootbox.size());

        // Récupère le Pokémon à cet index
        Pokemon pokemon = lootbox.get(index);

        // Affiche une question à l'utilisateur
        System.out.println("Voullez vous attraper le pokémon " + pokemon.getNom() + " ?");
        System.out.println("1. Oui");
        System.out.println("2. Non");

        // Lit la réponse de l'utilisateur
        String choix = lire.nextLine();

        // Traite la réponse de l'utilisateur
        switch (choix) {
            case "1":
                // Si l'utilisateur veut attraper le Pokémon
                System.out.println("Vous avez attrapé le pokémon " + pokemon.getNom() + " !");
                pokemonAttrape.add(pokemon);

                // Définit les points de combat (PC) du Pokémon de manière aléatoire
                int nombreAleatoire = random.nextInt(11) + 10;
                pokemon.setPC(nombreAleatoire);

                // Définit les points de vie (PV) du Pokémon de manière aléatoire
                nombreAleatoire = random.nextInt(21) + 10;
                pokemon.setPV(nombreAleatoire);
                pokemon.setPvSave(nombreAleatoire);

                // Ajoute des bonbons au dictionnaire de bonbons en fonction du type du Pokémon
                // attrapé
                Bonbons.ajouterBonbons(pokemon.getType(), 5);

                // Vérifie si le Pokémon a un deuxième type
                if (pokemon.getType2() != null) {
                    // Si oui, ajoute des bonbons pour le deuxième type
                    Bonbons.ajouterBonbons(pokemon.getType2(), 5);
                }
                break;
            case "2":
                // Si l'utilisateur ne veut pas attraper le Pokémon
                System.out.println("Vous n'avez pas attrapé le pokémon " + pokemon.getNom() + " !");
                break;
            default:
                // Si l'utilisateur n'a pas choisi une option valide
                System.out.println("Veuillez choisir une option valide.");
                break;
        }
    }

    public void ajouterEquipe(int pokemonChoix) {
        if (equipe.size() < 6) {
            Pokemon pokemon = (Pokemon) pokemonAttrape.get(pokemonChoix);

            boolean isAlreadyInTeam = false;
            for (Pokemon p : equipe) {

                if (pokemon.equals(p)) {
                    isAlreadyInTeam = true;
                    break;
                }
            }
            if (isAlreadyInTeam) {
                System.out.println("Vous avez déjà ce pokémon dans votre équipe.");
            } else {
                equipe.add(pokemon);
            }
        } else {
            System.out.println("Vous avez déjà 6 pokémons dans votre équipe.");
        }
    }

    public void supprimerEquipe(int pokemonChoix) {
        if (equipe.size() < 6) {
            equipe.remove(pokemonChoix);
        } else {
            System.out.println("Vous ne pouvez pas supprimer plus de 6 pokémons dans votre équipe.");
        }
    }

    public void afficherEquipe() {
        for (int i = 0; i < equipe.size(); i++) {
            System.out.println(equipe.get(i));
        }
    }

    /**
     * La fonction "afficherbonbons" vérifie si le dictionnaire des bonbons est vide
     * et imprime un
     * message si c'est le cas, sinon elle imprime le type et la quantité de chaque
     * bonbon dans le
     * dictionnaire.
     */
    public void afficherbonbons() {
        // Vérifie si la taille du dictionnaire de bonbons est égale à 0, c'est-à-dire
        // s'il n'y a pas de bonbons
        if (dictionnaireBonbon.size() == 0) {
            // Si c'est le cas, affiche un message indiquant qu'il n'y a pas encore de
            // bonbons
            System.out.println("Vous n'avez pas encore de bonbons.");
        } else {
            // Sinon, pour chaque entrée dans le dictionnaire de bonbons
            for (Map.Entry<String, Integer> entry : dictionnaireBonbon.entrySet()) {
                // Affiche le type de bonbon (la clé de l'entrée) et le nombre de bonbons de ce
                // type (la valeur de l'entrée)
                System.out.println("Type: " + entry.getKey() + ", Nombre: " + entry.getValue() + "\n");
            }
        }
    }

    /**
     * Affiche les Pokémons attrapés par le dresseur.
     * Si aucun Pokémon n'a été attrapé, affiche un message approprié.
     * Parcourt la liste des Pokémons attrapés et affiche leurs informations.
     * Vérifie si chaque Pokémon peut évoluer en fonction du nombre de bonbons
     * disponibles.
     */
    public void afficherPokemonAttrape() {
        // Vérifie si le dresseur a attrapé des Pokémons
        if (pokemonAttrape.size() == 0) {
            // Si le dresseur n'a pas attrapé de Pokémon, affiche un message
            System.out.println("Vous n'avez pas encore attrapé de pokémon.");
        } else {
            // Si le dresseur a attrapé des Pokémons, parcourt la liste des Pokémons
            // attrapés
            for (int i = 0; i < pokemonAttrape.size(); i++) {
                // Récupère le Pokémon à l'index i
                Pokemon pokemon = (Pokemon) pokemonAttrape.get(i);

                // Affiche le Pokémon
                System.out.println(i + ". " + pokemon);

                if (dictionnaireBonbon.containsKey(pokemon.getType())) {

                    // Si oui, récupère le nombre de bonbons de ce type
                    int nombreBonbonsType1 = dictionnaireBonbon.get(pokemon.getType());
                    System.out.println("Nombre de bonbons de type " + pokemon.getType() + " : " + nombreBonbonsType1);

                    if (pokemon.getType2() != null && dictionnaireBonbon.containsKey(pokemon.getType2())) {
                        // Si le Pokémon a un deuxième type, récupère le nombre de bonbons de ce type
                        int nombreBonbonsType2 = dictionnaireBonbon.get(pokemon.getType2());
                        System.out.println(
                                "Nombre de bonbons de type " + pokemon.getType2() + " : " + nombreBonbonsType2 + "\n");

                        if (nombreBonbonsType2 >= 5 && nombreBonbonsType1 >= 5
                                && !(pokemon instanceof Pokemon_evolution2)) {
                            System.out.println(pokemon.getNom() + " peut évoluer !");
                        }
                    } else if (nombreBonbonsType1 >= 5 && !(pokemon instanceof Pokemon_evolution2)) {
                        System.out.println(pokemon.getNom() + " peut évoluer !");
                    }
                }

                System.out.println("------------------------------------------------------------");
            }
        }
    }

    /**
     * La fonction "transfererPokemon" supprime un Pokémon spécifique d'une liste de
     * Pokémon capturés.
     * 
     * @param choixPokemon Le paramètre "choixPokemon" représente l'index des
     *                     Pokémon à transférer
     *                     depuis la liste "pokemonAttrape".
     */
    public void transfererPokemon(int choixPokemon) {
        if (choixPokemon >= 0 && choixPokemon < pokemonAttrape.size()) {
            Pokemon pokemon = (Pokemon) pokemonAttrape.get(choixPokemon);
            System.out.println(pokemon.getNom() + " a été transféré avec succès.");
            pokemonAttrape.remove(pokemon);
        } else {
            System.out.println("L'indice est hors limites");
        }
    }

    /**
     * Fait évoluer un Pokémon en fonction des conditions spécifiées.
     * 
     * @param choixPokemon   L'indice du Pokémon choisi dans la liste des Pokémons
     *                       attrapés.
     * @param nonEvoPokemons La liste des Pokémons non évolués.
     * @param evo1Pokemons   La liste des Pokémons de première évolution.
     * @param evo2Pokemons   La liste des Pokémons de deuxième évolution.
     */
    public void evoluerPokemon(int choixPokemon, List<Pokemon> nonEvoPokemons, List<Pokemon_evolution1> evo1Pokemons,
            List<Pokemon_evolution2> evo2Pokemons) {

        // Obtient l'index du Pokémon choisi dans la liste des Pokémons non évolués
        // par exemple ratata est à l'index 0 dans la liste des pokemonAttrape je
        // cherche
        // l'index de ratata dans la liste des nonEvoPokemons (qui contient tous les
        // pokemons non évolués)
        // dans la liste evo1Pokemons le ratatac se trouve au même index que ratata dans
        // nonEvoPokemons
        try {
            String nomPokemonAttrape = ((Pokemon) pokemonAttrape.get(choixPokemon)).getNom();
            int indexPokemon = -1;

            if (pokemonAttrape.get(choixPokemon) instanceof Pokemon) {
                indexPokemon = -1;
                for (int i = 0; i < nonEvoPokemons.size(); i++) {

                    if (nonEvoPokemons.get(i).getNom().equals(nomPokemonAttrape)) {
                        indexPokemon = i;
                        break;
                    }
                }
            }

            if (pokemonAttrape.get(choixPokemon) instanceof Pokemon_evolution1) {
                indexPokemon = -1;

                for (int i = 0; i <= evo1Pokemons.size(); i++) {
                    System.out.println(nonEvoPokemons.get(i).getNom().equals(nomPokemonAttrape));
                    System.out.println(evo1Pokemons.get(i).getNom());
                    if (evo1Pokemons.get(i).getNom().equals(nomPokemonAttrape)) {
                        indexPokemon = i;
                        break;
                    }
                }
            }

            if (pokemonAttrape.get(choixPokemon) instanceof Pokemon_evolution2) {
                indexPokemon = -1;
                for (int i = 0; i < evo2Pokemons.size(); i++) {
                    if (evo2Pokemons.get(i).getNom().equals(nomPokemonAttrape)) {
                        indexPokemon = i;
                        break;
                    }
                }
            }

            System.out.println("INDEX POKEMON : " + indexPokemon);

            // Vérifie si le dresseur a suffisamment de bonbons pour faire évoluer le
            // Pokémon

            if (dictionnaireBonbon.get(nonEvoPokemons.get(indexPokemon).getType()) >= 5) {

                if (pokemonAttrape.get(choixPokemon) instanceof Pokemon_evolution1) {
                    // Tente de faire évoluer le Pokémon à la troisième évolution
                    Pokemon_evolution2 evolution2 = Pokemon_evolution1.evoluer2(indexPokemon, evo1Pokemons,
                            evo2Pokemons);
                    // Si le Pokémon peut évoluer à la troisième évolution
                    if (evolution2 != null) {
                        // Remplace le Pokémon dans la liste des Pokémons attrapés par sa troisième
                        // évolution
                        pokemonAttrape.set(choixPokemon, evolution2);
                        // Affiche un message indiquant que le Pokémon a évolué
                        System.out.println("\nLe Pokémon a évolué en " + evolution2.getNom() + " !");
                        System.out.println("------------------------------------------------------------");
                    } else {
                        // Si le Pokémon ne peut pas évoluer à la troisième évolution, augmente ses
                        // statistiques
                        int Pc = ((Pokemon) pokemonAttrape.get(choixPokemon)).getPc();
                        int Pv = ((Pokemon) pokemonAttrape.get(choixPokemon)).getPv();
                        ((Pokemon) pokemonAttrape.get(choixPokemon)).setPC(Pc + 50);
                        ((Pokemon) pokemonAttrape.get(choixPokemon)).setPV(Pv + 50);
                        // Affiche un message indiquant que les statistiques du Pokémon ont augmenté
                        System.out.println("\nLe Pokémon a augmenté ses statistiques !");
                        System.out.println("------------------------------------------------------------");
                    }
                } // Si le Pokémon est de la première évolution
                else if (pokemonAttrape.get(choixPokemon) instanceof Pokemon) {
                    // Fait évoluer le Pokémon à la deuxième évolution
                    Pokemon_evolution1 evolution1 = Pokemon.evoluer1(indexPokemon, nonEvoPokemons, evo1Pokemons);
                    // Remplace le Pokémon dans la liste des Pokémons attrapés par sa deuxième
                    // évolution
                    pokemonAttrape.set(choixPokemon, evolution1);
                    // Affiche un message indiquant que le Pokémon a évolué
                    System.out.println("\nLe Pokémon a évolué en " + evolution1.getNom() + " !");
                    System.out.println("------------------------------------------------------------");
                    // Si le Pokémon est de la deuxième évolution
                }

                // Supprime 5 bonbons du type du Pokémon de la réserve de bonbons
                Bonbons.supprimerBonbons(nonEvoPokemons.get(indexPokemon).getType(), 5);
                // Affiche un message indiquant que 5 bonbons du type du Pokémon ont été
                // utilisés
                System.out.println(
                        "5 bonbons de type " + nonEvoPokemons.get(indexPokemon).getType() + " ont été utilisés.");

                // Vérifie si le Pokémon a un deuxième type
                if (nonEvoPokemons.get(indexPokemon).getType2() != null) {
                    // Si oui, supprime 5 bonbons du deuxième type du Pokémon de la réserve de
                    // bonbons
                    Bonbons.supprimerBonbons(nonEvoPokemons.get(indexPokemon).getType2(), 5);
                    // Affiche un message indiquant que 5 bonbons du deuxième type du Pokémon ont
                    // été utilisés
                    System.out.println(
                            "5 bonbons de type " + nonEvoPokemons.get(indexPokemon).getType2() + " ont été utilisés.");
                }
                // Si le dresseur n'a pas suffisamment de bonbons pour faire évoluer le Pokémon
                else {
                    // Affiche un message indiquant que le dresseur n'a pas assez de bonbons pour
                    // faire évoluer le Pokémon
                    System.out.println("Vous n'avez pas assez de bonbons pour faire évoluer ce pokémon");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("L'index du Pokémon est hors des limites de la liste.");
        } catch (NullPointerException e) {
            System.out.println("Un des objets utilisés est null.");
        } catch (Exception e) {
            // Attrape toute autre exception non spécifiquement gérée ci-dessus
            System.out.println("Une erreur inattendue s'est produite.");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Dresseur [nom=" + nom + ", pokemonAttrape=" + pokemonAttrape + ", equipe=" + equipe
                + ", dictionnaireBonbon=" + dictionnaireBonbon + "]";
    }

}