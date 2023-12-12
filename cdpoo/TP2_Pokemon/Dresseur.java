package cdpoo.TP2_Pokemon;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Dresseur implements Serializable {
    private String nom;
    private List<Object> pokemonAttrape = new ArrayList<>();
    private List<Object> equipe = new ArrayList<>();
    private HashMap<String, Integer> dictionnaireBonbon = Bonbons.getDictionnaireBonbons();

    public Dresseur(String nom) {
        this.nom = nom;
    }

    // public Dresseur(String nom, List<Object> pokemonAttrape, List<Object> equipe,
    // List<Object> bonbons) {
    // this.nom = nom;
    // this.pokemonAttrape = pokemonAttrape;
    // this.equipe = equipe;
    // this.bonbons = bonbons;
    // }

    public String getNom() {
        return nom;
    }

    public List<Object> getPokemonAttrape() {
        return pokemonAttrape;
    }

    public List<Object> getEquipe() {
        return equipe;
    }

    // public void setNom(String nom) {
    // this.nom = nom;
    // }

    public void setPokemonAttrape(Pokemon pokemonAttrape) {
        this.pokemonAttrape.add(pokemonAttrape);
    }

    public void setEquipe(List<Object> equipe) {
        this.equipe = equipe;
    }

    public void chassePokemon(List<Pokemon> lootbox, Scanner lire) {
        Random random = new Random();
        int index = random.nextInt(lootbox.size());
        Pokemon pokemon = lootbox.get(index);

        System.out.println("Voullez vous attraper le pokémon " + pokemon.getNom() + " ?");
        System.out.println("1. Oui");
        System.out.println("2. Non");
        String choix = lire.nextLine();
        switch (choix) {
            case "1":
                System.out.println("Vous avez attrapé le pokémon " + pokemon.getNom() + " !");
                pokemonAttrape.add(pokemon);
                int nombreAleatoire = random.nextInt(11) + 10;
                pokemon.setPC(nombreAleatoire);
                nombreAleatoire = random.nextInt(21) + 10;
                pokemon.setPV(nombreAleatoire);
                Bonbons.ajouterBonbons(pokemon.getType(), 2);
                break;
            case "2":
                System.out.println("Vous n'avez pas attrapé le pokémon " + pokemon.getNom() + " !");
                break;
            default:
                System.out.println("Veuillez choisir une option valide.");
                break;
        }
    }

    public void ajouterEquipe(Object pokemon) {
        if (equipe.size() < 6) {
            equipe.add(pokemon);
        } else {
            System.out.println("Vous avez déjà 6 pokémons dans votre équipe.");
        }
    }

    public void modifierEquipe(Object pokemon, int index) {
        if (index < 6) {
            equipe.set(index, pokemon);
        } else {
            System.out.println("Vous ne pouvez pas ajouter plus de 6 pokémons dans votre équipe.");
        }
    }

    public void supprimerEquipe(int index) {
        if (index < 6) {
            equipe.remove(index);
        } else {
            System.out.println("Vous ne pouvez pas supprimer plus de 6 pokémons dans votre équipe.");
        }
    }

    public void afficherEquipe() {
        for (int i = 0; i < equipe.size(); i++) {
            System.out.println(equipe.get(i));
        }
    }

    public void afficherbonbons() {
        for (int i = 0; i < dictionnaireBonbon.size(); i++) {
            System.out.println(dictionnaireBonbon);
        }
    }

    public void afficherPokemonAttrape() {
        if (pokemonAttrape.size() == 0) {
            System.out.println("Vous n'avez pas encore attrapé de pokémon.");
        } else {
            for (int i = 0; i < pokemonAttrape.size(); i++) {
                Pokemon pokemon = (Pokemon) pokemonAttrape.get(i);
                System.out.println(i + ". " + pokemon);
                if (dictionnaireBonbon.containsKey(pokemon.getType())) {
                    int nbBonbons = dictionnaireBonbon.get(pokemon.getType());
                    System.out.println("Nombre de bonbons de type " + pokemon.getType() + " pour " + pokemon.getNom()
                            + " : " + nbBonbons);
                }
            }
        }
    }

    public void utiliserBonbon(Object bonbon, Object pokemon) {
        if (dictionnaireBonbon.containsKey(bonbon)) {
            dictionnaireBonbon.remove(bonbon);
            pokemonAttrape.remove(pokemon);
            pokemonAttrape.add(pokemon);
        } else {
            System.out.println("Vous ne possédez pas ce bonbon.");
        }
    }

    public void transfererPokemon(Object pokemon) {
        if (pokemonAttrape.contains(pokemon)) {
            pokemonAttrape.remove(pokemon);
        } else {
            System.out.println("Vous ne possédez pas ce pokémon.");
        }
    }

}