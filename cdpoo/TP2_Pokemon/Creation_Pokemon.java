package cdpoo.TP2_Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Creation_Pokemon {
    private static List<Pokemon> PokemonNonEvo;
    private static List<Pokemon_evolution1> PokemonEvo1;
    private static List<Pokemon_evolution2> PokemonEvo2;

    // Cette méthode initialise les pokémons à partir d'un fichier XLSX
    public static void Initialisation_pokemon(List<List<String>> Pokemon_liste) throws Exception {
        // Création d'une nouvelle instance de la classe ReadXLSX

        // Création d'une liste vide pour stocker les instances de Pokemon
        List<Pokemon> instancesPokList = new ArrayList<>();
        List<Pokemon_evolution1> instancesPokEvo1List = new ArrayList<>();
        List<Pokemon_evolution2> instancesPokEvo2List = new ArrayList<>();
        // Liste des types de Pokémon possibles pour une vérification ultérieure
        List<String> types = Arrays.asList("Normal", "Feu", "Eau", "Plante", "Électrik", "Glace", "Combat",
                "Poison", "Sol", "Vol", "Psy", "Insecte", "Roche", "Spectre", "Dragon", "Ténèbres", "Acier", "Fée");

        // Parcours de la liste Pokemon_liste de la fin vers le début (pour éviter les
        // erreurs d'index du fait de la suppression d'éléments)
        for (int i = Pokemon_liste.size() - 1; i >= 0; i--) {
            List<String> sous_liste = Pokemon_liste.get(i);

            // Si la sous-liste ne contient pas d'espace ou si le troisième élément est un
            // espace
            if (!sous_liste.contains(" ") || sous_liste.get(2).equals(" ")) {
                // Si la taille de la sous-liste est 5
                if (sous_liste.size() == 5) {
                    // Création d'une nouvelle instance de Pokemon et ajout à la liste instances
                    Pokemon p1Pokemon = new Pokemon(sous_liste.get(0), sous_liste.get(3), sous_liste.get(4), 0, 0);
                    instancesPokList.add(p1Pokemon);
                    // Suppression du premier élément de la sous-liste
                    sous_liste.remove(0);
                } else {
                    // Création d'une nouvelle instance de Pokemon et ajout à la liste instances
                    Pokemon p1Pokemon = new Pokemon(sous_liste.get(0), sous_liste.get(3), 0, 0);
                    instancesPokList.add(p1Pokemon);
                    // Suppression du premier élément de la sous-liste
                    sous_liste.remove(0);
                }

                // Si la taille de la sous-liste est 4
                if (sous_liste.size() == 4) {
                    // Création d'une nouvelle instance de Pokemon_evolution1 et ajout à la liste
                    // instances
                    Pokemon_evolution1 p1Evolution1 = new Pokemon_evolution1(sous_liste.get(0), sous_liste.get(2),
                            sous_liste.get(3), 0, 0);
                    instancesPokEvo1List.add(p1Evolution1);
                    // Suppression du premier élément de la sous-liste
                    sous_liste.remove(0);
                } else {
                    // Création d'une nouvelle instance de Pokemon_evolution1 et ajout à la liste
                    // instances
                    Pokemon_evolution1 p1Evolution1 = new Pokemon_evolution1(sous_liste.get(0), sous_liste.get(2), 0,
                            0);
                    instancesPokEvo1List.add(p1Evolution1);
                    // Suppression du premier élément de la sous-liste
                    sous_liste.remove(0);
                }
            }

            // Si la sous-liste est vide ou si le premier élément est un type, on passe à la
            // suite
            if (sous_liste.isEmpty() || types.contains(sous_liste.get(0))) {
                continue;
            }

            // Si le premier élément de la sous-liste est un espace
            if (sous_liste.get(0).equals(" ")) {
                // Effacement de tous les éléments de la sous-liste
                sous_liste.clear();
            } else if (sous_liste.size() == 3) {
                // Création d'une nouvelle instance de Pokemon_evolution2 et ajout à la liste
                // instances
                Pokemon_evolution2 p1Evolution2 = new Pokemon_evolution2(sous_liste.get(0), sous_liste.get(1),
                        sous_liste.get(2), 0, 0);
                instancesPokEvo2List.add(p1Evolution2);
                // Suppression du premier élément de la sous-liste
                sous_liste.remove(0);
            } else {
                // Création d'une nouvelle instance de Pokemon_evolution2 et ajout à la liste
                // instances
                Pokemon_evolution2 p1Evolution2 = new Pokemon_evolution2(sous_liste.get(0), sous_liste.get(1), 0,
                        0);
                instancesPokEvo2List.add(p1Evolution2);
                // Suppression du premier élément de la sous-liste
                sous_liste.remove(0);
            }
        }
        PokemonNonEvo = instancesPokList;
        PokemonEvo1 = instancesPokEvo1List;
        PokemonEvo2 = instancesPokEvo2List;

    }

    public static List <Pokemon> getNonEvo() {
        return PokemonNonEvo;
    }

    public static List <Pokemon_evolution1> getEvo1() {
        return PokemonEvo1;
    }

    public static List <Pokemon_evolution2> getEvo2() {
        return PokemonEvo2;
    }
}