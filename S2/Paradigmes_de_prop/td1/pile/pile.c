#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct noeud {
    int element;
    struct noeud* suivant;
} noeud;

typedef struct pile {
    noeud* sommet;
} pile;

int pileVide(pile* p) {
    return p->sommet == NULL;
}

int empileElement(pile* p, int element) {
    noeud* nouveauNoeud = malloc(sizeof(noeud));
    if (nouveauNoeud == NULL) {
        fprintf(stderr, "Unable to allocate memory for new noeud\n");
        return false;
    }
    nouveauNoeud->element = element;
    nouveauNoeud->suivant = p->sommet;
    p->sommet = nouveauNoeud;
    return true;
}

int depileElement(pile* p, int* element) {
    if (pileVide(p)) {
        fprintf(stderr, "Stack underflow\n");
        return false;
    } else {
        noeud* temp = p->sommet;
        *element = temp->element;
        p->sommet = p->sommet->suivant;
        free(temp);
        return true;
    }
}

int main() {
    pile* p = malloc(sizeof(pile));
    p->sommet = NULL;
    int element;
    int i;

    for (i = 0; i < 10; i++) {
        empileElement(p, i);
    }

    while (!pileVide(p)) {
        depileElement(p, &element);
        printf("%d\n", element);
    }

    free(p);
    return 0;
}