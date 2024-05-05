
#include "train.h"

int main() {
    liste_horaire_train* liste = (liste_horaire_train*)malloc(sizeof(liste_horaire_train));
    liste->tete = NULL;
    int choix;
    char ville_depart [50], ville_arrivee[50];

    ajouter_horaire(liste, "Lille", "Paris", "08:00", "08:59", 237);
    ajouter_horaire(liste, "Lille", "Lyon", "07:00", "10:00", 709);
    ajouter_horaire(liste, "Lille", "Calais", "15:19", "18:34", 110);
    ajouter_horaire(liste, "Paris", "Marseille", "12:00", "18:00", 900);
    ajouter_horaire(liste, "Lyon", "Marseille", "10:07", "15:01", 450);
    ajouter_horaire(liste, "Lyon", "Marseille", "11:50", "17:00", 450);

    do {
        printf("\n-----------Menu-----------\n");
        printf("1. Afficher les horaires\n");
        printf("2. Rechercher un horaire\n");
        printf("3. Quitter\n");
        printf("Votre choix: ");
        scanf("%d", &choix);
        switch (choix)
        {
          case 1:
                printf("Entrez une ville: ");
                scanf("%s", ville_depart);
                afficher_trains(liste, ville_depart );
                break;
            case 2:
                printf("Ville de départ: ");
                scanf("%s", ville_depart);
                printf("Ville d'arrivée: ");
                scanf("%s", ville_arrivee);
                trouver_trajet(liste, ville_depart, ville_arrivee);
                break;
            case 3:
                break;
            default:
                printf("Choix invalide\n");
        }
          
    } while (choix != 3);

    // Libérer la mémoire
    liberer_liste_horaires(liste);

    return 0;
}
