/**
 * La classe Facturation calcule le coût d'écoute de la musique et la rémunération des artistes en
 * fonction de la durée de l'écoute et du choix ou non de l'utilisateur du son HD.
 */
public class Facturation {
       // Tarif standard par 5 minutes (en euros)
       private static final double TARIF_STANDARD = 0.02;
    
       // Tarif pour le son HD par 5 minutes (en euros)
       private static final double TARIF_HD = 0.03;
       
       // Pourcentage redistribué aux artistes
       private static final double POURCENTAGE_REMUNERATION_ARTISTES = 0.66;
   
       /**
        * Calcule le coût d'écoute pour un utilisateur donné.
        * 
        * @param utilisateur L'utilisateur pour lequel calculer le coût.
        * @param dureeEcoute La durée de l'écoute en minutes.
        * @param estSonHD Indique si l'utilisateur a choisi le son HD.
        * @return Le coût total de l'écoute.
        */
       public static double calculerCoutEcoute(Utilisateur utilisateur, Float dureeEcoute, boolean estSonHD) {
           double tarifPar5Minutes = estSonHD ? TARIF_HD : TARIF_STANDARD;
           double coutTotal = (dureeEcoute / 5) * tarifPar5Minutes;
           return coutTotal;
       }
   
       /**
        * Calcule la rémunération des artistes pour une écoute donnée.
        * 
        * @param coutEcoute Le coût total de l'écoute.
        * @return La rémunération des artistes.
        */
       public static double calculerRemunerationArtistes(double coutEcoute) {
           return coutEcoute * POURCENTAGE_REMUNERATION_ARTISTES;
       }
       
}