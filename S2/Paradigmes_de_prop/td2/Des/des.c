#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define VALEUR_MAX_DE 6

// Fonction pour lancer un dé
int lancer_de() {
    return rand() % VALEUR_MAX_DE + 1;
}

// Fonction pour lancer plusieurs dés et retourner le score total
int lancer_des(int *nombre_des) {
    int total = 0;
    for (int i = 0; i < *nombre_des; i++) {
        int lancer = lancer_de();
        printf("Dé %d: %d\n", i + 1, lancer);
        total += lancer;
    }
    return total;
}

int main() {
    srand(time(NULL)); // Initialiser le générateur de nombres aléatoires

    int nombre_des;
    printf("Entrez le nombre de dés à lancer (1-4): ");
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