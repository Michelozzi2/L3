import java.util.ArrayList;
import java.util.List;

public class MainSpotizer {
    public static void main(String[] args) {
        // Création de quelques titres de musique
        TitreMusique titre1 = new TitreMusique("Chanson 1", 1.3f, "Pop", null, null, false, false);
        TitreMusique titre2 = new TitreMusique("Chanson 2", 2.5f, "Rock", null, null, false, false);
        TitreMusique titre3 = new TitreMusique("Chanson 3", 4.5f, "R&B", null, null, false, false);

        // Création d'une liste de titres musicaux
        List<TitreMusique> titres = new ArrayList<>();
        titres.add(titre1);
        titres.add(titre2);
        titres.add(titre3);

        // Création d'un artiste et ajout des titres musicaux
        Artiste artiste = new Artiste("Artiste Nom", titres, "Image de l'artiste");

        // Création d'un nouvel utilisateur
        Utilisateur user = new Utilisateur("Nom d'Utilisateur", "test@gmail.com");

        // L'utilisateur ajoute de l'argent à son solde
        user.ajouterAuSolde(50.0);

        // L'utilisateur souscrit un abonnement
        user.souscrireAbonnement();

        // L'utilisateur active l'accès HD
        user.activerAccesHD();

        // Création d'un album et ajout des titres musicaux de l'artiste
        Album album = new Album("Album 1", artiste, artiste.getTitresMusicaux(), "Visuel de l'album");

        // Création d'une playlist et ajout de morceaux (titres de musique) à la playlist
        Playlist playlist = new Playlist("Ma Playlist", user);
        playlist.ajouterMorceau(titre1);
        playlist.ajouterMorceau(titre2);

        // Création d'une écoute et ajout de morceaux (titres de musique) à l'écoute
        Ecoute ecoute = new Ecoute("Mon Écoute", user);
        ecoute.ajouterMorceau(titre2);
        ecoute.ajouterMorceau(titre3);

        // Affichage des informations de l'artiste, de l'album, de l'utilisateur, de la playlist et de l'écoute
        System.out.println(artiste);
        System.out.println(album);
        System.out.println(user);
        System.out.println(playlist);
        System.out.println(ecoute);
        

       // TEST de la durée d'écoute et calcul du prix par minute
        ecoute.CalculerDureeTotale();
        System.out.println();
        System.out.println("Le prix pour " + ecoute.getDureeTotale()+" minute d'écoute est de " + 
        Facturation.calculerCoutEcoute(user, ecoute.getDureeTotale(), user.isaUnAccesHD()) + "€");
        
        //REMUNERATION DE L'ARTISTE
        System.out.println("La rémunération de l'artiste sera donc de "+
        Facturation.calculerRemunerationArtistes(Facturation.calculerCoutEcoute(user, ecoute.getDureeTotale(), user.isaUnAccesHD())) + "€");
    }
}