# -*- coding: utf-8 -*-
"""
Created on Mon Nov 20 11:45:43 2023

@author: matth
"""

import numpy as np
import math

class CSP():
    def __init__(self, name) :
        self.grille = np.loadtxt(name)
        self.toFill = []
        self.domaines = []
        self.size=len(self.grille)
    
    def constraints(self, x, y):
        if (x==2 )and (y==4):
            a=1
        libre = []
        occupee = []
        #Parcours de la ligne
        for i in range(self.size):
            if i==y : continue
            if self.grille[x,i]==0: libre.append((x,i))
            else : occupee.append((x,i))
        #Parcours des colonnes
        for j in range(self.size):
            if j==x : continue
            if self.grille[j,y]==0 : libre.append((j,y))
            else : occupee.append((j,y))
        #Parcours de la case (3*3)
        for i in range(3*(x//3), 3*(x//3)+3) :
            for j in range(3*(y//3), 3*(y//3)+3) :
              if (i==x) or (j==y) : continue
              if self.grille[i,j]==0 : libre.append((i,j))
              else : occupee.append((i,j))
        return libre, occupee
    
    def accepte(self):
        domaine = []
        for s in self.toFill:
            libre, occupee = self.constraints(s[0],s[1])
            values = []
            for x in occupee :
                values.append(self.grille[x[0],x[1]])
            domaine.append([x for x in range(1,self.size+1) if x not in values])
        return domaine
    
    def MRV(self):
        nonAffecte = np.where(self.grille==0)
        self.toFill=[(x,y) for x,y in zip(nonAffecte[0],nonAffecte[1])]
        if len(self.toFill)==0 : return []
        self.domaines = self.accepte()
        minMRV = min( len(self.domaines[s]) for s in range(len(self.domaines)))
        MRVs = [self.toFill[s] for s in range(len(self.toFill)) if len(self.domaines[s])==minMRV]
        if len(MRVs)==1 : return MRVs
        Degree=[]
        for s in MRVs:
            libre, occupee =  self.constraints(s[0],s[1])
            Degree.append(len(libre))
        DHs = [ MRVs[s] for s in range(len(MRVs)) if Degree[s]==max(Degree) ]
        return DHs
        
    def nextValue(self, S):
        nonAffect, occupee = self.constraints(S[0],S[1])
        indS = self.toFill.index(S)
        if len(nonAffect)==0 : return self.domaines[indS]
        impact = []
        for v in self.domaines[indS]:
            compte = sum(v in self.domaines[self.toFill.index(s)] for s in nonAffect)
            impact.append(compte)
        valeursTries = [x for y, x in sorted(zip(impact,self.domaines[indS]), reverse=True)]
        return valeursTries 

def backtracking_search():
    global sudoku, Termine, decompte
    decompte += 1
    listeVariables = sudoku.MRV()
    #S'il n'y a plus de variables à sélectionner on a terminé l'algorithme
    if len(listeVariables)==0 : Termine=True ; return 
    S = listeVariables[0] 
    #On classe les valeurs à mettre dans S dans l'ordre de l'impact minimum qu'elles peuvent avoir 
    listeValeurs = sudoku.nextValue(S)
    for V in listeValeurs:
        sudoku.grille[S[0],S[1]]=V
        backtracking_search()
        if (Termine==True) : return
        sudoku.grille[S[0],S[1]]=0

sudoku = CSP('Sudoku.txt')
Termine=False
decompte=0
backtracking_search()