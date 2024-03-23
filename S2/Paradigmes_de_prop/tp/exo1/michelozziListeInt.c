#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <errno.h>
#include "michelozziListeInt.h"


/* Initialise un nouvel élément de la liste avec une valeur aléatoire
   @input : aucun
   @output : maillon_int*, pointeur sur le nouvel élément
   @precondition : aucune
   @postcondition : un nouvel élément de la liste est créé avec une valeur aléatoire
*/
maillon_int* init_elt()
{
    maillon_int* p_nv_elt = malloc(sizeof(maillon_int));
    p_nv_elt->val = rand() % 21;
    p_nv_elt->p_suiv = NULL;
    return p_nv_elt;
}

/* Ajoute un nouvel élément en tête de la liste (version 1)
   @input : maillon_int* p_tete, pointeur sur l'élément de tête de la liste
            maillon_int* p_nv_elt, pointeur sur le nouvel élément à ajouter
   @output : maillon_int*, pointeur sur le nouvel élément de tête de la liste
   @precondition : p_nv_elt pointe sur un élément valide
   @postcondition : le nouvel élément est ajouté en tête de la liste
*/
maillon_int* ajout_tete_v1(maillon_int* p_tete, maillon_int* p_nv_elt)
{
    p_nv_elt->p_suiv = p_tete;
    p_tete = p_nv_elt;
    return p_tete;
}

/* Ajoute un nouvel élément en tête de la liste (version 2)
   @input : maillon_int** p_p_tete, pointeur sur le pointeur de l'élément de tête de la liste
            maillon_int* p_nv_elt, pointeur sur le nouvel élément à ajouter
   @output : void
   @precondition : p_p_tete pointe sur un pointeur valide, p_nv_elt pointe sur un élément valide
   @postcondition : le nouvel élément est ajouté en tête de la liste
*/
void ajout_tete_v2(maillon_int** p_p_tete, maillon_int* p_nv_elt)
{
    p_nv_elt->p_suiv = *p_p_tete;
    *p_p_tete = p_nv_elt;
}

/* Parcourt et affiche les éléments de la liste
   @input : maillon_int* p_tete, pointeur sur l'élément de tête de la liste
   @output : void
   @precondition : p_tete est soit NULL (liste vide) soit pointe sur le premier élément d'une liste d'entiers
   @postcondition : les éléments de la liste sont affichés à l'écran
*/
void parcourir(maillon_int* p_tete)
{
    if (p_tete == NULL)
        printf("liste vide");
    else
        while (p_tete != NULL) {
            printf("%d--", p_tete->val);
            p_tete = p_tete->p_suiv;
        }
    putchar('\n');
}

/* Insère un nouvel élément dans la liste en respectant l'ordre croissant des valeurs (version 1)
   @input : maillon_int* p_tete, pointeur sur l'élément de tête de la liste
            maillon_int* p_nv_elt, pointeur sur le nouvel élément à ajouter
   @output : maillon_int*, pointeur sur le nouvel élément de tête de la liste
   @precondition : p_nv_elt pointe sur un élément valide
   @postcondition : le nouvel élément est inséré dans la liste en respectant l'ordre croissant des valeurs
*/
maillon_int* inserer1(maillon_int* p_tete, maillon_int* p_nv_elt)
{
    maillon_int* n, * prec;
    
    if (p_tete == NULL || p_nv_elt->val <= p_tete->val) {  
        p_nv_elt->p_suiv = p_tete;
        p_tete = p_nv_elt;
    }
    else {  
        n = prec = p_tete;
        while (n != NULL && p_nv_elt->val > n->val) {
            prec = n;
            n = n->p_suiv;
        }
        p_nv_elt->p_suiv = n;
        prec->p_suiv = p_nv_elt;
    }
    return p_tete;
}

/* Insère un nouvel élément dans la liste en respectant l'ordre croissant des valeurs (version 2)
   @input : maillon_int** prem, pointeur sur le pointeur de l'élément de tête de la liste
            maillon_int* e, pointeur sur le nouvel élément à ajouter
   @output : void
   @precondition : prem pointe sur un pointeur valide, e pointe sur un élément valide
   @postcondition : le nouvel élément est inséré dans la liste en respectant l'ordre croissant des valeurs
*/
void inserer2(maillon_int** prem, maillon_int* e)
{
    maillon_int* n, * prec;
    if (*prem == NULL || e->val <= (*prem)->val){ 
        e->p_suiv = *prem;
        *prem = e;
    }
    else {  
        n = prec = *prem;
        while (n != NULL && e->val > n->val) {
            prec = n;
            n = n->p_suiv;
        }
        e->p_suiv = n;
        prec->p_suiv = e;
    }
}

/* Supprime l'élément de tête de la liste
   @input : maillon_int** prem, pointeur sur le pointeur de l'élément de tête de la liste
   @output : void
   @precondition : prem pointe sur un pointeur valide
   @postcondition : l'élément de tête de la liste est supprimé
*/
void supprimer_debut(maillon_int** prem)
{
    maillon_int* n;
    if (*prem != NULL) {
        n = *prem;
        *prem = (*prem)->p_suiv;
        free(n);
    }
}

/* Supprime tous les éléments de la liste ayant une certaine valeur (version 1)
   @input : maillon_int* prem, pointeur sur l'élément de tête de la liste
            int val, la valeur à supprimer
   @output : maillon_int*, pointeur sur le nouvel élément de tête de la liste
   @precondition : prem est soit NULL (liste vide) soit pointe sur le premier élément d'une liste d'entiers
   @postcondition : tous les éléments de la liste ayant la valeur val sont supprimés
*/
maillon_int* critere_supp_un1(maillon_int* prem, int val)
{
    maillon_int* e = prem, * prec = NULL, * n;

    while (e != NULL) {
        n = NULL;
        if (e->val == val) {
            n = e;
            if (prec == NULL)
                prem = e->p_suiv;
            else
                prec->p_suiv = e->p_suiv;
        }
        else
            prec = e;
        e = e->p_suiv;
        if (n != NULL)
            free(n);
    }
    return prem;

}

/* Supprime tous les éléments de la liste ayant une certaine valeur (version 2)
   @input : maillon_int** prem, pointeur sur le pointeur de l'élément de tête de la liste
            int val, la valeur à supprimer
   @output : void
   @precondition : prem pointe sur un pointeur valide
   @postcondition : tous les éléments de la liste ayant la valeur val sont supprimés
*/
void critere_supp_un2(maillon_int** prem, int val)
{
    maillon_int* e = *prem, * prec = NULL, * n;

    while (e != NULL) {
        n = NULL;
        if (e->val == val) {
            n = e;
            if (prec == NULL)
                *prem = e->p_suiv;
            else
                prec->p_suiv = e->p_suiv;
        }
        else
            prec = e;
        e = e->p_suiv;
        if (n != NULL)
            free(n);
    }
}

/* Détruit la liste entière (version 1)
   @input : maillon_int** prem, pointeur sur le pointeur de l'élément de tête de la liste
   @output : void
   @precondition : prem pointe sur un pointeur valide
   @postcondition : tous les éléments de la liste sont supprimés
*/
void detruire_liste(maillon_int** prem)
{
    maillon_int* n;
    while (*prem != NULL) {
        n = *prem;
        *prem = (*prem)->p_suiv;
        free(n);
    }
}

/* Détruit la liste entière (version 2)
   @input : maillon_int** prem, pointeur sur le pointeur de l'élément de tête de la liste
   @output : void
   @precondition : prem pointe sur un pointeur valide
   @postcondition : tous les éléments de la liste sont supprimés
*/
void detruire_liste2(maillon_int** prem)
{
    while (*prem != NULL)
        supprimer_debut(prem);
    
}

/* Permet la sérialisation format binaire dans le fichier
"saveliste.bin" de la liste d'entier (maillon_int) dont
le pointeur sur le premier élément est passé en paramètre
@input : maillon_int * prem, pointeur sur l'élément de tête de la liste à sérialiser
@output : void
@precondition : le répertoire courant et le processus père permettent l'écriture 
                le pointeur prem, est soit NULL (aucune action) soit pointe sur
                le premier élément d'une liste d'entiers
@postcondition : le fichier saveliste.bin contient les éléments de la liste 
                dont le premier élément est pointé par prem. 
                Nota : il n'y a pas de libération de la mémoire occupée par la 
                liste. Il faut donc la détruire avant d'éventuellement la recharger.
*/
void sauver_liste(maillon_int* prem)
{
    //ouvrir un fichier binaire en écriture : suffixe b
    FILE* f=fopen("saveliste.bin", "wb");
    printf("Ouvertude du fichier %p\n",f);
    // si liste non vide
    if (prem != NULL) {
        if (f==NULL)
            fprintf(stderr,"erreur création fichier :%i\n",errno);
        else // parcourir la liste jusque fin
            while (prem != NULL) {
                // écrire chaque maillon en binaire
                if (1 !=fwrite(prem, sizeof(maillon_int), 1, f))
                    fprintf(stderr,"Erreur d'écriture du maillon %p\n",prem);
                else 
                // passer au maillon suivant
                prem = prem->p_suiv;
            }
            fclose(f);	// fermer le fichier
    }
    else
        fprintf(stderr,"pas de sauvegarde pour une liste vide\n");
}


/* Permet de charger une liste d'entiers (maillon_int) depuis le fichier "saveliste.bin"
   @input : aucun
   @output : maillon_int* prem, pointeur sur l'élément de tête de la liste chargée
   @precondition : le fichier "saveliste.bin" doit exister et être accessible en lecture
   @postcondition : la liste d'entiers dont le premier élément est pointé par prem est chargée en mémoire.
                    Si le fichier n'existe pas ou n'est pas accessible, la fonction retourne NULL
*/
maillon_int* load_liste()
{
    FILE* f;
    maillon_int* prem = NULL, * p, e;
    if ((f= fopen("saveliste.bin", "rb")) != NULL) {
        prem = malloc(sizeof(maillon_int));
        fread(prem, sizeof(maillon_int), 1, f);
        p = prem;
        while (fread(&e, sizeof(maillon_int), 1, f)) {
            p->p_suiv = malloc(sizeof(maillon_int));
            p = p->p_suiv;
            *p = e;
            p->p_suiv = NULL;
        }
        fclose(f);
    }
    else
        printf("erreur ou fichier inexistant");
    return prem;
}

