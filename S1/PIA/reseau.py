# -*- coding: utf-8 -*-
"""
Created on Mon Dec 11 11:12:53 2023

@author: matth
"""

import numpy as np
import math
import copy

#Parametre du probleme
reseau = np.loadtxt("reseau.txt")
D = 0 ; A = 5
TailleReseau = len(reseau)

#variables
Trouve = False
Route = [D] ; km=0
bestRoute = [] ; bestKm = math.inf


def Accepte(e,s):
    global reseau, Route
    if reseau[e,s] == 0:
        return False
    if s in Route :
        return False
    return True


def chemin(e):
    global reseau, Trouve, Route
    #etape 3 et 4 sur quoi on se base pour la recherche plus condition d'arret
    if e == A:
        Trouve = True ; return
    #etape 5 parcours des etapes verification si acceptable appel fct recursive
    for s in range(TailleReseau):
        if Accepte(e, s) :
            Route.append(s)
            chemin(s)
            if Trouve : return
            del Route[-1]
            
def bestChemin(e):
    global reseau, Route, km, bestRoute, bestKm
    if e == A:
        if km < bestKm:
            bestRoute = copy.deepcopy(Route) ; 
            bestKm = km
        return
    for s in range(TailleReseau):
        if Accepte(e, s):
            Route.append(s)
            km += reseau[e,s]
            bestChemin(s)
            km -= reseau[e,s]
            del Route[-1]
            
        
            
bestChemin(0)
                   
