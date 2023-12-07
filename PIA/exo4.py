# -*- coding: utf-8 -*-
"""
Created on Mon Dec  4 08:54:49 2023

@author: matth
"""
import numpy as np 
import math
import copy

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

Barre = [0,2,5,7,9,10,12,14,15]

#Variables du probleme
Decoupe = [] ; TailleMax= len(Barre)-1
Prix = 0 ; PrixOp = 0
DecoupeOp = []

def decouper():
    global Barre ,TailleMax
    global Decoupe, Prix, DecoupeOp, PrixOp
    taille=sum(Decoupe)
    if taille == TailleMax :
        if Prix>PrixOp :
            DecoupeOp = copy.deepcopy(Decoupe)
            PrixOp = Prix
        return
    for i in range(1,(TailleMax-taille)+1) :
        Decoupe.append(i)
        Prix = Prix + Barre[i]
        decouper()
        Prix = Prix - Barre[i]
        del Decoupe[-1]
        
res = decouper()
        


            
        
            
    


    
   
        
    


   