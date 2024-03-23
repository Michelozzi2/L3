#include <stdio.h>
#include <stdlib.h>
#include "pile.h"


int main() {
    // Créer une nouvelle pile
    Stack* my_stack = init_stack();

    // Empiler quelques valeurs
    push(my_stack, 1);
    push(my_stack, 2);
    push(my_stack, 3);

    // Créer une pile temporaire pour afficher les valeurs
    Stack* temp_stack = init_stack();

    // Afficher les valeurs de la pile
    printf("Pile d'origine: ");
    while (!is_empty(my_stack)) {
        int value = pop(my_stack);
        printf("%d ", value);
        push(temp_stack, value);
    }
    printf("\n");

    // Remettre les valeurs dans la pile originale
    while (!is_empty(temp_stack)) {
        push(my_stack, pop(temp_stack));
    }

    // Libérer la mémoire de la pile temporaire
    free_stack(temp_stack);

    // Créer une autre pile pour renverser la première
    Stack* reverse_stack = init_stack();

    // Déplacer tous les éléments de la première pile à la deuxième
    while (!is_empty(my_stack)) {
        push(reverse_stack, pop(my_stack));
    }

    // Libérer la mémoire de la première pile
    free_stack(my_stack);

    // Afficher la valeur du sommet de la pile renversée
    printf("premier element de la pile renverse: %d\n", peek(reverse_stack));

    // Dépiler et afficher les valeurs de la pile renversée
    printf("Pile renverse: ");
    while (!is_empty(reverse_stack)) {
        printf("%d ", pop(reverse_stack));
    }
    printf("\n");

    // Libérer la mémoire de la pile renversée
    free_stack(reverse_stack);

    return 0;
}