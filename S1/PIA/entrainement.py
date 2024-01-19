# -*- coding: utf-8 -*-
"""
Created on Sun Dec 31 10:33:32 2023

@author: matth
"""
from copy import deepcopy
import copy
import numpy as np
import math


"""
#1
#parametre du probleme
nbr = 8
#variable du probleme
reine = [-1]*nbr
Trouve = False

def accept(pos,e):
    global reine, Trouve, nbr
    if pos in reine:
        return False
    for ligne in range(e):
        if abs(e-ligne) == abs(pos-reine[ligne]):
            return False
    return True

def placerReine(e):
    global nbr, reine, Trouve
    if e == nbr:
        Trouve = True ; return
        
    for pos in range(nbr):
        if accept(pos,e):
            reine[e] = pos
            placerReine(e+1)
            if Trouve: return
            reine[e]=-1
        
placerReine(0)
            
""" 
"""    

#2
from copy import deepcopy

#parametre du probleme
barre = [0, 2, 5, 7, 9, 10, 12, 14, 15]
Taillebarre = len(barre)-1

#variable du probleme
decoupe = []
prix = 0
bestDecoupe = []
bestprix = 0

def accept(e):
    global barre, Taillebarre
    if (e + sum(decoupe)) > Taillebarre:
        return False
    return True

def meilleurDecoupe(e):
    global barre, Taillebarre
    global decoupe, prix, bestDecoupe, bestprix
    
    if sum(decoupe) >= Taillebarre:
        if prix > bestprix:
            bestDecoupe = deepcopy(decoupe)
            bestprix = prix
        return   
    
    for pos in [True,False]:
        if (accept(e)):
            if pos == True:
                decoupe.append(e)
                prix += barre[e]
                meilleurDecoupe(e)
                prix -= barre[e]
                del decoupe[-1]
            else:
                meilleurDecoupe(e+1)

meilleurDecoupe(1)
print(bestprix)
print(bestDecoupe)
            
"""
"""
#3
#Parametre de mon probleme
Prix = [0,4,4,3,3,5,5,3,3,5,6,5,5]
poids = [0,5,7,2,2,6,8,3,4,9,11,8,7]
TailleSac = len(poids)
PoidsMax = 15

#Variables
Sac = [] ; PoidsSac = 0 ; PrixSac = 0
BestSac = [] ; BestPoids = 0 ; BestPrix = 0; compt = 0


#etape 5 fct acceptable
def accepte(e):
    global poids, PoidsSac, PoidsMax
    if (poids[e] + PoidsSac) <= PoidsMax:
        return True
    return False
        

#etape 4 fct remplir
def remplir(e):
    global Prix, poids ,PoidsMax
    global Sac, PoidsSac, PrixSac, compt
    global BestSac, BestPrix, BestPoids, TailleSac
    compt +=1
    if (e == TailleSac) or (PoidsSac == PoidsMax):
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

"""   
"""
#4
#parametre du probleme
lab = np.loadtxt("Laby.txt")  
D = (0,0) ; A = (lab.shape[0]-1,lab.shape[1]-1) 
Direction = [(1,0),(0,1),(-1,0),(0,-1)]

#variable du probleme
e = (0,0)
Trouve = False
bestlab = []
bestCases = math.inf
nbCases = 0

def accept(e, d):
    global lab
    x = e[0]+d[0] ; y = e[1]+d[1]
    if x < 0: return False
    if x >= lab.shape[0] : return False
    if y < 0: return False
    if y >= lab.shape[1] : return False
    if lab[x,y] != 0 : return False
    return True
    

    
def recherche(e):
    global lab, D, A, Direction
    global Trouve
    
    if e == A:
        lab[e] = 1
        Trouve = True ; return
    for d in Direction:
        if accept(e, d):
            lab[e] = 1
            recherche((e[0]+d[0], e[1]+d[1]))
            if Trouve : return
            lab[e]= 0

#res = recherche(D)




def bestrecheche(e):
    global lab, D, A, Direction
    global bestCases, bestlab, nbCases
   
    if e == A:
        if nbCases < bestCases:
            bestlab = copy.deepcopy(lab)
            bestlab[e] = 1
            bestCases = nbCases; 
        return  
    for d in Direction:
        if accept(e, d):
            lab[e] = 1
            nbCases += 1
            bestrecheche( (e[0]+d[0], e[1]+d[1]) )
            nbCases -= 1
            lab[e] = 0
            
bestrecheche((0,0))
""" 
"""

#5

#Parametre du probleme
reseau = np.loadtxt("reseau.txt")
D = 0 ; A = 5
TailleReseau = len(reseau)


#variable du probleme
route = [D] ; Trouve = False
km = 0 ; bestRoute = [] ; bestkm = math.inf

def accept(e, s):
    global route , reseau
    if reseau[e, s] == 0 : return False
    if s in route : return False
    return True

    

def chemin(e):
    global reseau, D, A, TailleReseau
    global route, Trouve
    
    if e == A:
        Trouve = True ; return
    
    for s in range(TailleReseau):
        if accept(e, s):
            route.append(s)
            chemin(s)
            if Trouve : return
            del route[-1]
            
            
def bestChemin(e):
    global reseau, D, A, TailleReseau
    global route, Trouve, km, bestRoute, bestkm
    
    if e == A:
        if km < bestkm:
            bestRoute = copy.deepcopy(route)
            bestkm = km
        return
    for s in range(TailleReseau):
        if accept(e, s):
            route.append(s)
            km += reseau[e, s]
            bestChemin(s)
            km -= reseau[e, s]
            del route[-1]
            
chemin(0)
    
"""        
    

#6

#Parametre du probleme
sudoku = np.loadtxt('sudoku.txt')
casesVides = np.where(sudoku==0)
Trouve = False
compt = 0

def accept(e, i):
    global sudoku , casesVides
    x = casesVides[0][e] ; y = casesVides[1][e]
    if i in sudoku[:,y] : return False
    if i in sudoku[x,:] : return False
    A = (x//3)*3 ; B = (y//3)*3
    if i in sudoku[A:A+3,B:B+3]: return False
    return True
    

def completerSudoku(e):
    global sudoku, casesVides, Trouve, compt
    compt += 1
    if e == len(casesVides[0]):
        Trouve = True ; return
        
    for i in range(1,10):
        if accept(e, i):
            x = casesVides[0][e]; y = casesVides[1][e]
            sudoku[x,y] = i
            completerSudoku(e+1)
            if Trouve : return
            sudoku[x, y] = 0

completerSudoku(0)
            























          
            
        
    
    
            
    




























