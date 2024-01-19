# -*- coding: utf-8 -*-
"""
Created on Mon Dec  4 08:54:49 2023

@author: matth
"""
import numpy as np 
import math
import copy
from copy import deepcopy
"""
reseau = np.loadtxt("reseau.txt")
fp = open('Reseau.txt')
sommets = fp.readline().split()
sommets[0]= sommets[0][1:]
S = fp.readline().split()
D = S[0][1:] ; A = S[1]
fp.close()

#Variables du probleme
Chemin = [D] ; Distance = 0
PCC = [] ; DistancePCC = math.inf


def accepter(ne,i):
    global reseau, Distance
    global sommets, DistancePCC
    if reseau[ne,i]==0 : return False
    if sommets[i] in Chemin : return False
    if (Distance+reseau[ne,i])>DistancePCC :
        return False
    return True
    


def CheminLePlusCourt():
    global sommets, reseau, A
    global Chemin, Distance, PCC, DistancePCC
    e = Chemin[-1]
    if e==A :
        if Distance<DistancePCC:
            DistancePCC = Distance
            PCC = copy.deepcopy(Chemin)
        return
    ne=sommets.index(e) 
    for i in range(len(sommets)):
        if accepter(ne, i):
            Chemin.append(sommets[i])
            Distance = Distance+reseau[ne, i]
            CheminLePlusCourt()
            Distance = Distance-reseau[ne, i]
            del Chemin[-1]
            
res = CheminLePlusCourt()
"""


# 1 - Parametre du problème 
barre = [0, 2, 5, 7, 9, 10, 12, 14, 15]
tailleBarre = len(barre) -1

# 2 - Variable
decoupe = []
prix = 0
bestDecoupe = []
bestPrix = 0

# 3 - etape
def backtracking(e): 
    global barre, tailleBarre
    global decoupe, prix, bestDecoupe, bestPrix

    # 4 - solution 
    if sum(decoupe) >= tailleBarre: 
        if prix > bestPrix : 
            bestDecoupe = deepcopy(decoupe)
            bestPrix = prix
        return 

    # 5 - etape suivante
    for pos in [True, False]: 
        # 6 - Acceptable 
        if (accepte(e)):
            if  pos==True:
                decoupe.append(e)
                prix += barre[e]
                backtracking(e)
                prix -= barre[e]
                del decoupe[-1]
            else : 
                backtracking(e+1)

# 6 - Accepte
def accepte(e): 
    global decoupe, tailleBarre
    if e + sum(decoupe)> tailleBarre : 
        return False 
    else : 
        return True
    
backtracking(1)
print(bestPrix)
print(bestDecoupe)


            
        
            
    


    
   
        
    


   