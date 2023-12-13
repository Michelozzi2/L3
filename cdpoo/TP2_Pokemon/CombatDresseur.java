package cdpoo.TP2_Pokemon;

import java.util.Scanner;

public class CombatDresseur {
    protected static Dresseur dresseur1;
    protected static Dresseur dresseur2;

    public static void AddDresseur(Dresseur dresseur) {
        if (dresseur1 == null) {
            dresseur1 = dresseur;
        } else {
            dresseur2 = dresseur;
        }
        System.out.println(dresseur1);
        System.out.println(dresseur2);
    }

    // Démarre un combat entre deux dresseurs
    static void startCombat() {

        // Affiche le nom des deux dresseurs qui vont combattre
        System.out.println("Combat entre " + dresseur1.getNom() + " et " + dresseur2.getNom());

        // Continue le combat tant que les deux dresseurs ont encore des Pokémon dans
        // leur équipe
        while (dresseur1.getEquipe().size() > 0 && dresseur2.getEquipe().size() > 0) {

            // Affiche les informations sur l'équipe de chaque dresseur
            dresseur1.afficherEquipe();
            dresseur2.afficherEquipe();

            // Effectue un tour de combat pour chaque dresseur
            // Le dresseur1 attaque en premier, puis le dresseur2
            executeCombatTurn(dresseur1, dresseur2);
            executeCombatTurn(dresseur2, dresseur1);
        }

        // Une fois que l'un des dresseurs n'a plus de Pokémon dans son équipe, le
        // combat se termine
        // Affiche le nom du dresseur qui a encore des Pokémon dans son équipe,
        // c'est-à-dire le gagnant
        if (dresseur1.getEquipe().size() == 0) {
            System.out.println(dresseur2.getNom() + " a gagné !");
        } else {
            System.out.println(dresseur1.getNom() + " a gagné !");
        }
    }

    // Cette méthode simule un tour de combat entre deux dresseurs
    private static void executeCombatTurn(Dresseur attaquant, Dresseur adversaire) {
        // Crée un scanner pour lire l'entrée de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demande à l'attaquant de choisir un Pokémon pour attaquer
        System.out.println(attaquant.getNom() + ", choisissez un Pokémon pour attaquer :");
        attaquant.afficherEquipe();
        int choixPokemon = scanner.nextInt();
        Pokemon pokemonAttaquant = (Pokemon) attaquant.getEquipe().get(choixPokemon);

        // Demande à l'adversaire de choisir un Pokémon pour défendre
        System.out.println(adversaire.getNom() + ", choisissez un Pokémon pour défendre :");
        adversaire.afficherEquipe();
        int choixPokemonAdversaire = scanner.nextInt();
        Pokemon pokemonAdversaire = (Pokemon) adversaire.getEquipe().get(choixPokemonAdversaire);

        // Effectue l'attaque
        System.out.println(pokemonAttaquant.getNom() + " attaque " + pokemonAdversaire.getNom());
        while (pokemonAttaquant.getPv() > 0 && pokemonAdversaire.getPv() > 0) {
            if (Math.random() < 0.1) {
                // Il y a 10% de chance que l'attaque échoue
                System.out.println("L'attaque a échoué !");
            } else {
                // Si l'attaque réussit, le Pokémon attaquant attaque le Pokémon adversaire
                pokemonAttaquant.attaque(pokemonAdversaire);
                // Affiche les points de vie restants du Pokémon adversaire
                System.out.println(pokemonAdversaire.getNom() + " a " + pokemonAdversaire.getPv() + " PV");
            }
        }
        // Ferme le scanner
        scanner.close();
    }

}