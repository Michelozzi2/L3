#include <stdio.h>
#include <stdlib.h>

// Fonction pour inverser une chaîne de caractères
char* reverse(char* str) {
    int length = 0;
    while (str[length] != '\0') {
        length++;
    }
    for (int i = 0; i < length / 2; i++) {
        char temp = str[i]; // Stocke le caractère actuel dans une variable temporaire
        str[i] = str[length - i - 1]; // Remplace le caractère actuel par le caractère symétrique à l'autre extrémité de la chaîne
        str[length - i - 1] = temp; // Remplace le caractère symétrique par le caractère stocké dans la variable temporaire
    }
    return str; // Retourne la chaîne inversée
} 

