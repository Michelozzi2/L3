#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void tirageAleatoire();
    
void tirageAleatoire() {
    int occurrences[6] = {0}; // Tableau pour stocker les occurrences de chaque résultat
    
    // Effectuer 100000 tirages aléatoires
    for (int i = 0; i < 100000; i++) {
        int valeur = rand() % 6; // Tirage aléatoire entre 0 et 5
        occurrences[valeur]++; // Incrémenter l'occurrence correspondante
    }
    
    // Afficher les pourcentages
    for (int i = 0; i < 6; i++) {
        float pourcentage = (float)occurrences[i] / 100000 * 100;
        printf("Résultat %d : %.2f%%\n", i, pourcentage);
    }
}

int main() {
    srand(time(NULL)); // Initialiser le générateur de nombres aléatoires
    
    tirageAleatoire(); // Appeler la fonction de tirage aléatoire
    
    return 0;
}
