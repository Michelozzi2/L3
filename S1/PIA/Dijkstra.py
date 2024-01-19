# -*- coding: utf-8 -*-
"""
Created on Mon Nov 27 14:04:27 2023

@author: matth
"""

import numpy as np 
import math

reseau = np.loadtxt('Reseau.txt')
fp = open('Reseau.txt')
line = fp.readline()
fp.close()
noms = line.split()
noms[0]= noms[0][1:]
chemins = []
for i in range(len(noms)):
    chemins.append([None, math.inf, 'Blanc'])

def petitGris():
    global chemins, noms
    nom = '' ; taille = math.inf
    for num in range(len(noms)):
        if (chemins[num][2] == 'Gris' and chemins[num][1]<taille):
            nom = noms[num] ; taille = chemins[num][1]
    return nom
            

def dijkstra(D):
    global chemins,noms,reseau
    numD = noms.index(D)
    chemins[numD][1]=0 ; chemins[numD][2] = 'Gris'
    while True:
        nomx = petitGris()
        if nomx=='' : return
        x = noms.index(nomx) ; chemins[x][2]= 'Noir'
        Liste= [i for i in range(len(noms)) if reseau[x,i]!=0 and chemins[i][2]!='Noir' ]
        for y in Liste:
            if reseau[x,y]+chemins[x][1] < chemins[y][1]:
                chemins[y][1] = reseau[x,y] + chemins[x][1]
                chemins[y][0] = nomx
                chemins[y][2] = 'Gris'
                    


dijkstra('S0')

"""
reseau = np.loadtxt('Astar.txt')
fp = open('Astar.txt')
noms = fp.readline().split()[:-1]
noms[0] = noms[0][1:]
fp.close()
chemins = [[math.inf, reseau[i,-1], None]for i in range(len(noms))]
reseau = reseau[:,:-1]

def minLO(LO):
    global chemins, noms
    X = LO[0] ; numX= noms.index(X)
    for Y in LO[1:]:
        numY = noms.index(Y)
        if chemins[numX][0]+chemins[numY][1]<chemins[numX][0]+chemins[numX][1]:
            X = Y ; numX =numY
    return X, numX

def Astar(D, A):
    global chemins, reseau, noms
    LO = [D] ; LF = []
    chemins[noms.index(D)][0] = 0
    while len(LO)>0:
        X,numX = minLO(LO); LF.append(X)
        LO.remove(X)
        if X==A : return
        liste = [i for i in range(len(noms)) if reseau[numX,i]!=0]
        for numY in liste:
            cout = chemins[numX][0]+reseau[numX,numY]
            if cout < chemins[numY][0]:
                chemins[numY][0] = cout
                chemins[numY][2] = X
                Y = noms[numY]
                if (Y not in LO) and (Y not in LF):
                    LO.append(Y)
                    
resultat = Astar('S0', 'S10')
                
"""     


