import copy
import numpy as np
import math 

"""

Prix = [0,4,4,3,3,5,5,3,3,5,6,5,5]
poids = [0,5,7,2,2,6,8,3,4,9,11,8,7]
PoidsMax = 15
sac = []; PoidsSac=0; PrixSac=0
bestSac=[]; bestPrix=0; bestPoids=0

def remplir(e):
    global Prix, poids ,PoidsMax
    global sac, PoidsSac, PrixSac
    global bestSac, bestPrix, bestPoids
    if e == len(Prix)-1:
        if PrixSac > bestPrix:
            bestSac = copy.deepcopy(sac)
            bestPrix = PrixSac
            bestPoids = PoidsSac
        return
    for ei in range(e+1,len(Prix)):
        if PoidsSac + poids[ei] <= PoidsMax:
            sac.append(ei)
            PoidsSac += poids[ei]
            PrixSac += Prix[ei]
            remplir(ei)
            sac.pop()
            PoidsSac -= poids[ei]
            PrixSac -= Prix[ei]
            del sac[-1]
        else:
            remplir(ei)

remplir(3)
"""
#Parametre de mon probleme
Prix = [0,4,4,3,3,5,5,3,3,5,6,5,5]
poids = [0,5,7,2,2,6,8,3,4,9,11,8,7]
PoidsMax = 15

#Variables
Sac = [] ; PoidsSac = 0 ; PrixSac = 0
BestSac = [] ; BestPoids = 0 ; BestPrix = 0


#etape 5 fct acceptable
def accepte(e):
    global poids, PoidsSac, PoidsMax
    if (poids[e] + PoidsSac) <= PoidsMax:
        return True
    return False
        

#etape 4 fct remplir
def remplir(e):
    global Prix, poids ,PoidsMax
    global Sac, PoidsSac, PrixSac
    global BestSac, BestPrix, BestPoids
    if (e == len(Prix)) or (PoidsSac == PoidsMax):
        if (PrixSac > BestPrix):
            BestSac = copy.deepcopy(Sac)
            BestPoids = PoidsSac
            BestPrix = PrixSac
        return
    for pos in [True,False]:
        if (pos == True) and accepte(e):
            Sac.append(e)
            PrixSac += Prix[e]
            PoidsSac += poids[e]
            remplir(e+1)
            PoidsSac -= poids[e]
            PrixSac -= Prix[e]
            del Sac[-1]
        else:
            remplir(e+1)
            
remplir(1)












