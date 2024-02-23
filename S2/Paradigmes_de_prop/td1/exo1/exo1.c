#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[]) {
    /* Ce bloc de code vérifie si le nombre d'arguments de ligne de commande transmis au programme est
    inférieur à 3. Si c'est le cas, cela signifie que le programme n'a pas été exécuté avec le
    nombre de paramètres attendu. Dans ce cas, il imprime un message d'erreur indiquant
    l'utilisation correcte du programme et renvoie 1, indiquant une erreur. */
    if (argc < 3) {
        printf("Wrong usage, at least 2 parameters expected:\n");
        printf("%s param1 param2\n", argv[0]);
        return 1;
    }


    /* Le code calcule la somme des arguments de ligne de commande transmis au programme. */
    int sum = 0;
    for (int i = 1; i < argc; i++) {
        int num = atoi(argv[i]);
        /* La condition `if (num == 0 && argv[i][0] != '0')` vérifie si la conversion de l'argument de
        ligne de commande `argv[i]` en un entier `num` a réussi. */
        if (num == 0 && argv[i][0] != '0') {
            printf("There is a problem with args %d, %s. It could not be transformed in int. Please retry !\n", i, argv[i]);
            return 1;
        }
        sum += num;
    }

    printf("%d\n", sum);
    return 0;
}
