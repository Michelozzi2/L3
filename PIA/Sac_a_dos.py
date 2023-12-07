import copy
import numpy as np
import math 



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

remplir(0)