#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>
#include "util_rand.h"


#define VALEUR_MAX_DE 6

// Fonction pour lancer un dé
int lancer_de() {
    return randint_max(VALEUR_MAX_DE) + 1;
}


// Fonction pour lancer plusieurs dés et retourner le score total
int lancer_des(int *nombre_des) {
    int faces[6] = {0,0,0,0,0,0};
    int identiques;

    do {
        // Réinitialisez le tableau de faces et la variable identiques
        for(int i = 0; i < 6; i++) {
            faces[i] = 0;
        }
        identiques = 0;

        // Lancez les dés et comptez les faces
        for(int i = 0; i < *nombre_des; i++) {
            int lancer = lancer_de();
            faces[lancer-1]++;
            printf("Des %d: %d\n", i+1, lancer);
        }

        // Vérifiez s'il y a des faces identiques
        int arretPossible = 1;
        for(int i = 0; i < 6 && arretPossible; i++) {
            if (faces[i] > 1) {
                identiques = 1;
                arretPossible = 0;
                
            }
        }

        if(identiques) {
            printf("Relancez les des!\n");
            printf("\n");
        } 
    } while(identiques);

    // Calculez le score total
    int score = 0;
    for(int i = 0; i < 6; i++) {
        score += (i+1) * faces[i];
    }

    return score;

}

int main() {
    srand(time(NULL));
   
    int nombre_des;
    printf("Entrez le nombre de des a lancer (1-4): ");
    scanf("%d", &nombre_des);

    if (nombre_des < 1 || nombre_des > 4) {
        printf("Nombre de dés invalide.\n");
        return 1;
    }

    int total = lancer_des(&nombre_des);
    printf("Score total: %d\n", total);

    int cible = (2 * VALEUR_MAX_DE * nombre_des) / 3;
    printf("Score cible: %d\n", cible);

    if (total > cible) {
        printf("Vous gagnez par %d points!\n", total - cible);
    } else if (total < cible) {
        printf("Vous perdez par %d points.\n", cible - total);
    } else {
        printf("C'est un match nul!\n");
    }

    return 0;
}