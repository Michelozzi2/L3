#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>
#include "min_max_structure.h"

int main(int argc, char *argv[]) {
    double nombre[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int taille = sizeof(nombre) / sizeof(nombre[0]);
    printf("Taille du tableau : %d\n", taille);
    double_pair min_max = get_max_and_min(nombre, taille);
    printf("Le maximum est %d et le minimum est %d\n", min_max.max, min_max.min);
    return 0;
}

/**
 * La fonction "get_max_and_min" trouve les valeurs maximales et minimales dans un tableau de doubles.
 * 
 * @param nombre Le paramètre "nombre" est un tableau de type double qui contient les nombres pour
 * lesquels on veut trouver les valeurs maximales et minimales.
 * @param taille Le paramètre "taille" représente la taille ou la longueur du tableau "nombre". Il
 * indique le nombre d'éléments dans le tableau.
 * 
 * @return La fonction renvoie une structure de type double_pair qui contient les valeurs maximales et
 * minimales trouvées dans le tableau.
 */

double_pair get_max_and_min(double nombre[], int taille) {
    double_pair min_max;
    if (taille == 0) {
        min_max.min = 0;
        min_max.max = 0;
        return min_max;
    }
    min_max.min = nombre[0];
    min_max.max = nombre[0];
    for (int i = 1; i < taille; i++) {
        if (nombre[i] > min_max.max) {
            min_max.max = nombre[i];
        }
        if (nombre[i] < min_max.min) {
            min_max.min = nombre[i];
        }
    }
    return min_max;
}





