#define _DEFAULT_SOURCE
#include <stdlib.h>
#include <stdio.h>
#include "libMatthieu.h"

int main() {
    char str[] = "Hello, World!";
    char* new_str = reverse(str); // Appelle la fonction reverse() pour inverser la chaîne str et stocke le résultat dans new_str
    printf("%s\n", str); // Affiche la chaîne inversée
    return 0;
}
