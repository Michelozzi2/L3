#include <stdio.h>
#include <stdlib.h>
#include "pile.h"


/*
Liste chainée :

Gestion dynamique de la mémoire : Contrairement à un tableau statique, une liste chaînée ne nécessite pas de définir une taille maximale à l'avance. 
Cela signifie que vous pouvez ajouter autant d'éléments que vous le souhaitez (dans la limite de la mémoire disponible), ce qui est un avantage majeur 
pour les piles qui peuvent avoir besoin de croître et de décroître dynamiquement.

Complexité temporelle constante pour les opérations de pile : Les opérations de pile (push et pop) sur une liste chaînée ont une complexité temporelle
 constante O(1), car elles n'impliquent que la modification de quelques pointeurs. C'est plus efficace que les tableaux, où ces opérations peuvent 
 avoir une complexité temporelle linéaire O(n) dans le pire des cas (par exemple, lorsque le tableau doit être redimensionné).

Simplicité : Les listes chaînées sont relativement simples à comprendre et à mettre en œuvre. Elles n'ont pas besoin de la complexité supplémentaire
des listes doublement chaînées ou circulaires pour les opérations de pile de base.
*/

// Tester si la pile est vide
int is_empty(Stack* stack) {
    return stack->top == NULL;
}

// Empiler un nouvel élément de type entier
void push(Stack* stack, int value) {
    Node* new_node = malloc(sizeof(Node));
    new_node->value = value;
    new_node->next = stack->top;
    stack->top = new_node;
}

// Récupérer la valeur de l’élément de sommet de pile
int peek(Stack* stack) {
    if (is_empty(stack)) {
        fprintf(stderr, "Stack is empty\n");
        exit(EXIT_FAILURE);  // or return some default value
    }
    return stack->top->value;
}

// Récupérer la valeur et enlever l’élément de sommet de pile
int pop(Stack* stack) {
    if (is_empty(stack)) {
        fprintf(stderr, "Stack is empty\n");
        exit(EXIT_FAILURE);  // or return some default value
    }
    int top_value = stack->top->value;
    Node* old_top = stack->top;
    stack->top = old_top->next;
    free(old_top);
    return top_value;
}

// Initialiser une nouvelle pile
Stack* init_stack() {
    Stack* stack = malloc(sizeof(Stack));
    if (stack == NULL) {
        fprintf(stderr, "Failed to allocate memory for stack\n");
        exit(EXIT_FAILURE);
    }
    stack->top = NULL;
    return stack;
}

// Libérer la mémoire de la pile
void free_stack(Stack* stack) {
    while (!is_empty(stack)) {
        Node* next = stack->top->next;
        free(stack->top);
        stack->top = next;
    }
    free(stack);
}

// Inverser une liste d'entiers et l'afficher
void reverse_and_print(int* list, int length) {
    // Créer une nouvelle pile
    Stack* stack = init_stack();

    // Empiler tous les entiers de la liste
    for (int i = 0; i < length; i++) {
        push(stack, list[i]);
    }

    // Vérifier si la pile est vide
    if (is_empty(stack)) {
        printf("La liste est vide.\n");
        free_stack(stack);
        return;
    }

    // Dépiler et afficher tous les entiers
    while (!is_empty(stack)) {
        printf("%d ", pop(stack));
    }
    printf("\n");

    // Libérer la mémoire de la pile
    free_stack(stack);
}