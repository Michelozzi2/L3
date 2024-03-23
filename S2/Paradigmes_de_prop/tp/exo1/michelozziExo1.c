#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "michelozziListeInt.h"

/* Affiche un menu à l'utilisateur et retourne son choix
   @input : aucun
   @output : int, le choix de l'utilisateur
   @precondition : aucune
   @postcondition : le choix de l'utilisateur est retourné
*/
int menu()
{
    int choix = 0;
    printf("1 Creer une liste d'entiers compris entre 0 et 20 de taille aleatoire comprise entre 1 et 20\n"
        "2 Ajouter un élément entier aléatoire (compris entre 0 et 20) en tête de liste\n"
        "3 Inserer un élément entier aléatoire dans sa place dans la liste suivant l'ordre croissant des premiers éléments\n"
        "4 Supprimer l'élément de tête\n"
        "5 Supprimer tous les maillons d'une valeur donnee\n"
        "6 Detruire liste\n"
        "7 Sauver la liste courante en binaire dans le fichier \"saveliste.bin\"\n"
        "8 Charger une liste depuis le fichier \"savelist.bin\"\n"
        "9 Afficher la liste\n");

    scanf("%d", &choix);
    rewind(stdin);

    return choix;
}

int main()
{
    maillon_int* premier = NULL;
    maillon_int* nouveau;
    int fin = 0;
    int i, nb;
    

    srand((unsigned)time(NULL));
    while (!fin) {
        i = menu();
        switch (i) {

        case 1: //Créer une liste de taille aléatoire
            nb = rand() % 20 + 1;
            for (int j = 0; j < nb; j++) {
                nouveau = init_elt();
                ajout_tete_v2(&premier, nouveau);
            }
            break;

        case 2: // Ajouter
            nouveau = init_elt();
            ajout_tete_v2(&premier, nouveau);
            break;

        case 3: // Insérer (ordre croissant)
            nouveau = init_elt();
            inserer2(&premier, nouveau);
            break;

        case 4: //Supprimer début:
            supprimer_debut(&premier);
            break;

        case 5: // Supprimer un maillon d'une valeur donnée
            printf("Entrez la valeur à supprimer : ");
            scanf("%d", &nb);
            critere_supp_un2(&premier, nb);
            break;

        case 6: // détruire liste
            detruire_liste2(&premier);
            break;

        case 7: // Sauver liste
            sauver_liste(premier);
            break;

        case 8: // Charger liste
            premier = load_liste();
            break;

        case 9: // Afficher liste
            parcourir(premier);
            break;

        default:
            fin = 1;
            break;
        }
        
    }

    return 0;
}

/*

make michelozziListeInt.o pour compiler seulement michelozziListeInt.c
make michelozziExo1.o pour compiler seulement michelozziExo1.c
make michelozziExo1 pour compiler l'ensemble du projet
make clean pour nettoyer le répertoire (supprimer les fichiers objet, l'exécutable et savelist.bin)

*/