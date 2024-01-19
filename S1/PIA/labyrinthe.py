# -*- coding: utf-8 -*-
"""
Created on Thu Dec  7 13:40:55 2023

@author: matth
"""

import numpy as np
import math
import copy

#parametre du probleme
lab = np.loadtxt("Laby.txt")
D = (0,0); A = (lab.shape[0]-1,lab.shape[1]-1)
Direction = [(1,0),(0,1),(-1,0),(0,-1)]

#variables du probleme
e = (0,0)
Trouve = False 
BestCases = math.inf
BestLab = []
nbCases = 0
compt = 0

def accept(e, d):
    global lab
    x = e[0]+d[0] ; y = e[1]+d[1]
    if x < 0 : return False
    if x >= lab.shape[0] : return False
    if y < 0 : return False
    if y >= lab.shape[1] : return False
    if lab[x,y]!=0 : return False
    return True
    
"""

def recherche(e):
    global lab, D, A, Trouve, Direction, compt
    compt += 1
    if e == A: 
        lab[e] = 1
        Trouve = True ; return
    for d in Direction:
        if accept(e, d):
            lab[e]=1
            recherche((e[0]+d[0], e[1]+d[1]))
            if Trouve : return
            lab[e]=0

res = recherche(D)
            
"""


    
def chercherBest(e):
    global lab, D, A, Direction
    global BestCases, BestLab, nbCases, compt
    compt +=1
    if e == A:
        if nbCases < BestCases:
            BestLab = copy.deepcopy(lab)
            BestLab[e] = 1
            BestCases = nbCases; 
        return  
    for d in Direction:
        if accept(e, d):
            lab[e] = 1
            nbCases += 1
            chercherBest( (e[0]+d[0], e[1]+d[1]) )
            nbCases -= 1
            lab[e] = 0
            
chercherBest((0,0))
      
         
  
    


