#include <stdio.h>
#include <stdlib.h>

int main() {
    char* charPtr;
    int* intPtr;
    float* floatPtr;
    char choice;

    do {
        charPtr = (char*)malloc(sizeof(char));
        if (charPtr == NULL) {
            printf("Echec de l'allocation mémoire pour un char.\n");
            return 1;
        }

        intPtr = (int*)malloc(sizeof(int));
        if (intPtr == NULL) {
            printf("Echec de l'allocation mémoire pour un int.\n");
            free(charPtr);
            return 1;
        }

        floatPtr = (float*)malloc(sizeof(float));
        if (floatPtr == NULL) {
            printf("Echec de l'allocation mémoire pour un float.\n");
            free(charPtr);
            free(intPtr);
            return 1;
        }

        printf("Entrer un char: ");
        scanf(" %c", charPtr);

        printf("Entrer un int: ");
        scanf("%d", intPtr);

        printf("Entrer un float: ");
        scanf("%f", floatPtr);

        printf("Char: %c\n", *charPtr);
        printf("Int: %d\n", *intPtr);
        printf("Float: %f\n", *floatPtr);

        free(charPtr);
        free(intPtr);
        free(floatPtr);

        printf("Voulez-vous quitter? (y/n): ");
        scanf(" %c", &choice);
    } while (choice != 'y');

    return 0;
}
