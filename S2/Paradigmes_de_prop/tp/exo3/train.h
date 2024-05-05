
#ifndef TRAIN_HORAIRE_H
#define TRAIN_HORAIRE_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct horaire_train {
    char* ville_depart;      
    char* ville_arrivee;    
    char* heure_depart;      
    char* heure_arrivee;     
    int distance;           
    struct horaire_train* suivant; 
} horaire_train;


typedef struct liste_horaire_train {
    horaire_train* tete;  
} liste_horaire_train;


void ajouter_horaire(liste_horaire_train* liste, char* ville_depart, char* ville_arrivee, char* heure_depart, char* heure_arrivee, int distance);
void afficher_trains(liste_horaire_train* liste, char* ville_depart);
void trajet_vitesse_max(liste_horaire_train* liste);
void trier_horaires(liste_horaire_train* liste);
void trouver_trajet(liste_horaire_train* liste, char* ville_depart, char* ville_arrivee);
void liberer_liste_horaires(liste_horaire_train* liste);

#endif // TRAIN_HORAIRE_H
