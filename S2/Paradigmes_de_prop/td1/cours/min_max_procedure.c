#include <stdio.h>
#include <stdlib.h>

void get_max_and_min(double nombre[], int taille, double *max, double *min);

int main(int argc, char *argv[]) {
    double nombre[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    double max, min;
    int taille = sizeof(nombre) / sizeof(nombre[0]);
    printf("Taille du tableau : %d\n", taille);
    get_max_and_min(nombre, taille, &max, &min);
    printf("Le maximum est %f et le minimum est %f\n", max, min);
    return 0;
  
}

/**
 * La fonction "get_max_and_min" trouve les valeurs maximales et minimales dans un tableau de doubles.
 * 
 * @param nombre Le paramètre "nombre" est un tableau de type double qui contient les nombres pour
 * lesquels on veut trouver les valeurs maximales et minimales.
 * @param taille Le paramètre "taille" représente la taille ou la longueur du tableau "nombre". Il
 * indique le nombre d'éléments dans le tableau.
 * @param max Un pointeur vers une variable double qui stockera la valeur maximale dans le tableau.
 * @param min Un pointeur vers une variable double qui stockera la valeur minimale dans le tableau.
 * 
 * @return Dans ce code, rien n'est renvoyé. La fonction a un type de retour void, ce qui signifie
 * qu'elle ne renvoie aucune valeur.
 */
void get_max_and_min(double nombre[], int taille, double *max, double *min) {
    if (taille == 0) {
        return;
    }
    *max = nombre[0];
    *min = nombre[0];
    for (int i = 1; i < taille; i++) {
        if (nombre[i] > *max) {
            *max = nombre[i];
        }
        if (nombre[i] < *min) {
            *min = nombre[i];
        }
    }
}
