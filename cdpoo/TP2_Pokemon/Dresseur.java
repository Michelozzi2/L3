package cdpoo.TP2_Pokemon;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Dresseur implements Serializable {
    private String nom;
    private List<Object> pokemonAttrape = new ArrayList<>();
    private List<Object> equipe = new ArrayList<>();
    private List<Object> bonbons = new ArrayList<>();

    public Dresseur(String nom, List<Object> pokemonAttrape, List<Object> equipe, List<Object> bonbons) {
        this.nom = nom;
        this.pokemonAttrape = pokemonAttrape;
        this.equipe = equipe;
        this.bonbons = bonbons;
    }

    public String getNom() {
        return nom;
    }

    public List<Object> getPokemonAttrape() {
        return pokemonAttrape;
    }

    public List<Object> getEquipe() {
        return equipe;
    }

    public List<Object> getBonbons() {
        return bonbons;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPokemonAttrape(List<Object> pokemonAttrape) {
        this.pokemonAttrape = pokemonAttrape;
    }

    public void setEquipe(List<Object> equipe) {
        this.equipe = equipe;
    }

    public void setBonbons(List<Object> bonbons) {
        this.bonbons = bonbons;
    }

    public void chassePokemon(List<Object> lootbox) {
        Random random = new Random();
        int index = random.nextInt(lootbox.size());
        Object pokemon = lootbox.get(index);
        pokemonAttrape.add(pokemon);
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
        for (int i = 0; i < bonbons.size(); i++) {
            System.out.println(bonbons.get(i));
        }
    }

    public void afficherPokemonAttrape() {
        for (int i = 0; i < pokemonAttrape.size(); i++) {
            System.out.println(pokemonAttrape.get(i));
        }
    }

    public void utiliserBonbon(Object bonbon, Object pokemon) {
        if (bonbons.contains(bonbon)) {
            bonbons.remove(bonbon);
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

    

    

    






    

