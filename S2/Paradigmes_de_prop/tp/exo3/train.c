
#include "train.h"
#include <limits.h>


void ajouter_horaire(liste_horaire_train* liste, char* ville_depart, char* ville_arrivee, char* heure_depart, char* heure_arrivee, int distance) {
    horaire_train* nouveau = (horaire_train*)malloc(sizeof(horaire_train));
    nouveau->ville_depart = strdup(ville_depart);    //dupli des chaînes pour éviter les modifications extérieures.
    nouveau->ville_arrivee = strdup(ville_arrivee);
    nouveau->heure_depart = strdup(heure_depart);
    nouveau->heure_arrivee = strdup(heure_arrivee);
    nouveau->distance = distance;
    nouveau->suivant = liste->tete;
    liste->tete = nouveau;
}

void afficher_trains(liste_horaire_train* liste, char* ville_depart) {
    horaire_train* actuel = liste->tete;
    while (actuel != NULL) {
        if (strcmp(actuel->ville_depart, ville_depart) == 0) {
            printf("%s -> %s | Départ : %s - Arrivée : %s | Distance : %d km\n",
                   actuel->ville_depart, actuel->ville_arrivee, actuel->ville_depart, actuel->ville_arrivee, actuel->distance);
        }
        actuel = actuel->suivant;
    }
}

void trajet_vitesse_max(liste_horaire_train* liste) {
    horaire_train* actuel = liste->tete;
    double vitesse_max = 0;
    horaire_train* trajet_max = NULL;

    while (actuel != NULL) {
        int heure_depart, minute_depart, heure_arrivee, minute_arrivee;
        double vitesse, duree_heures;
        sscanf(actuel->heure_depart, "%2d:%2d", &heure_depart, &minute_depart);
        sscanf(actuel->heure_arrivee, "%2d:%2d", &heure_arrivee, &minute_arrivee);
        

        int duree_minutes = (heure_arrivee * 60 + minute_arrivee) - (heure_depart * 60 + minute_depart);
        if (duree_minutes < 0) {
            duree_minutes += 24 * 60;  
        }

        duree_heures = duree_minutes / 60.0;
        vitesse = (duree_heures > 0) ? (double) actuel->distance / duree_heures : 0;

        if (vitesse > vitesse_max) {
            vitesse_max = vitesse;
            trajet_max = actuel;
        }

        actuel = actuel->suivant;
    }

    if (trajet_max != NULL) {
        printf("Trajet le plus rapide trouvé : %s -> %s | Vitesse moyenne : %.2f km/h\n", 
               trajet_max->ville_depart, trajet_max->ville_arrivee, vitesse_max);
    } else {
        printf("Aucun trajet trouvé.\n");
    }
}

void trier_horaires(liste_horaire_train* liste_horaires) {
    int est_modifie;
    do {
        est_modifie = 0;
        horaire_train **horaire_courant = &(liste_horaires->tete);
        while (*horaire_courant != NULL && (*horaire_courant)->suivant != NULL) {
            horaire_train *horaire_actuel = *horaire_courant;
            horaire_train *horaire_suivant = horaire_actuel->suivant;
            if (strcmp(horaire_actuel->heure_depart, horaire_suivant->heure_depart) > 0) { // Si l'heure de départ de horaire_actuel est plus tard que celle de horaire_suivant
                // Echanger horaire_actuel et horaire_suivant
                horaire_actuel->suivant = horaire_suivant->suivant;
                horaire_suivant->suivant = horaire_actuel;
                *horaire_courant = horaire_suivant;
                est_modifie = 1;
            }
            horaire_courant = &((*horaire_courant)->suivant);
        }
    } while (est_modifie);
}


void trouver_trajet(liste_horaire_train* liste_trains, char* ville_depart, char* ville_arrivee) {
    horaire_train* trajet_direct = NULL;
    horaire_train* premier_train = NULL;
    horaire_train* deuxieme_train = NULL;
    double temps_minimal = INT_MAX; //initialise avec une grande valeur pour la comparaison

    // Parcourir tous les trajets possibles
    for (horaire_train* train_depart = liste_trains->tete; train_depart != NULL; train_depart = train_depart->suivant) {
        if (strcmp(train_depart->ville_depart, ville_depart) == 0) {
            if (strcmp(train_depart->ville_arrivee, ville_arrivee) == 0) {
                //trajet direct, calcule de la durée
                int heure_depart, minute_depart, heure_arrivee, minute_arrivee;
                sscanf(train_depart->heure_depart, "%2d:%2d", &heure_depart, &minute_depart);
                sscanf(train_depart->heure_arrivee, "%2d:%2d", &heure_arrivee, &minute_arrivee);
                double duree = (heure_arrivee * 60 + minute_arrivee) - (heure_depart * 60 + minute_depart);
                if (duree < 0) duree += 1440; //jour suivant
                if (duree < temps_minimal) {
                    temps_minimal = duree;
                    trajet_direct = train_depart;
                }
            } else {
                //chercher une correspondance
                for (horaire_train* train_correspondance = liste_trains->tete; train_correspondance != NULL; train_correspondance = train_correspondance->suivant) {
                    if (strcmp(train_correspondance->ville_depart, train_depart->ville_arrivee) == 0 && strcmp(train_correspondance->ville_arrivee, ville_arrivee) == 0) {
                        // Vérifier le temps de correspondance
                        int heure_arrivee, minute_arrivee, heure_correspondance, minute_correspondance;
                        sscanf(train_depart->heure_arrivee, "%2d:%2d", &heure_arrivee, &minute_arrivee);
                        sscanf(train_correspondance->heure_depart, "%2d:%2d", &heure_correspondance, &minute_correspondance);
                        double temps_attente = (heure_correspondance * 60 + minute_correspondance) - (heure_arrivee * 60 + minute_arrivee);
                        if (temps_attente < 0) temps_attente += 1440; //jour suivant
                        
                        //correspondance valide si l'attente est entre 5 minutes et 2 heures
                        if (temps_attente >= 5 && temps_attente <= 120) {
                            int heure_depart, minute_depart;
                            sscanf(train_depart->heure_depart, "%2d:%2d", &heure_depart, &minute_depart);
                            double duree_totale = temps_attente + ((heure_arrivee * 60 + minute_arrivee) - (heure_depart * 60 + minute_depart));
                            if (duree_totale < temps_minimal) {
                                temps_minimal = duree_totale;
                                premier_train = train_depart;
                                deuxieme_train = train_correspondance;
                            }
                        }
                    }
                }
            }
        }
    }

    if (trajet_direct != NULL) {
        printf("Trajet direct le plus rapide de %s à %s: %s -> %s | Départ : %s - Arrivée : %s | Durée: %.0f mins\n",
               ville_depart, ville_arrivee, trajet_direct->ville_depart, trajet_direct->ville_arrivee, trajet_direct->heure_depart, trajet_direct->heure_arrivee, temps_minimal);
    } else if (premier_train != NULL && deuxieme_train != NULL) {
        printf("Trajet avec correspondance le plus rapide de %s à %s:\n1er train: %s -> %s | Départ : %s - Arrivée : %s\n2e train: %s -> %s | Départ : %s - Arrivée : %s | Durée totale: %.0f mins\n",
               ville_depart, ville_arrivee, 
               premier_train->ville_depart, premier_train->ville_arrivee, premier_train->heure_depart, premier_train->heure_arrivee,
               deuxieme_train->ville_depart, deuxieme_train->ville_arrivee, deuxieme_train->heure_depart, deuxieme_train->heure_arrivee, temps_minimal);
    } else {
        printf("Aucun trajet trouvé de %s à %s.\n", ville_depart, ville_arrivee);
    }
}


void liberer_liste_horaires(liste_horaire_train* liste_trains) {
    horaire_train* train_actuel = liste_trains->tete;
    while (train_actuel != NULL) {
        horaire_train* train_a_supprimer = train_actuel; 
        train_actuel = train_actuel->suivant; 

        // Libération des chaînes de caractères 
        free(train_a_supprimer->ville_depart);
        free(train_a_supprimer->ville_arrivee);
        free(train_a_supprimer->heure_depart);
        free(train_a_supprimer->heure_arrivee);

        // Libération du noeud
        free(train_a_supprimer);
    }
    liste_trains->tete = NULL;
}
