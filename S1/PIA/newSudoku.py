# -*- coding: utf-8 -*-
"""
Created on Mon Nov 13 09:53:33 2023

@author: matth
"""

import numpy as np


class CSP():
    def __init__(self, file_name):
        
        self.Grille=np.loadtxt(file_name)
        self.toFill= []
        self.domaines= []
        self.size = len(self.Grille)
        
    def contrainte(self, x, y):        

        libre = []
        occupe = []
        
        #Parcours de la ligne
        for ligne in range(self.size):
            if ligne ==y: continue
            if self.Grille[x,ligne]==0:
                libre.append((x,ligne))
            else:
                occupe.append((x,ligne))
                
        #Parcours des colonnes       
        for col in range(self.size):
            if col ==x: continue
            if self.Grille[col,y]==0:
                libre.append((col,y))
            else:
                occupe.append((col,y))
                
        #Parcours de la case (3x3)
        for ligne in range(3*(x//3), 3*(x//3)+3):
            for col in range(3*(y//3), 3*(y//3)+3):
                if (ligne==x) or (col==y): continue
                if self.Grille[ligne,col]==0 : 
                    libre.append((ligne,col))
                else:
                    occupe.append((ligne,col))
                    
        return libre, occupe
       
    def accepte(self):
        domaines = []
        for s in self.toFill:
            libre, occupe = self.contrainte(s[0], s[1])
            values = []
            for x in occupe : 
                values.append(self.Grille[x[0],x[1]])
            domaines.append([x for x in range(1,self.size+1) if x not in values])
        return domaines
        
    def MRV(self):
       #self.toFill = []
       #for i in range(self.size):
       #   for j in range(self.size):
       #       if self.grille[i,j]==0:
       #           self.toFill.append((i,j))
       nonAffecte = np.where(self.Grille==0)
       self.toFill=[(x,y) for x,y in zip(nonAffecte[0],nonAffecte[1])]
       if len(self.toFill)==0 : return []    
       self.domaines = self.accepte()
       minMRV = min( len(self.domaines[s]) for s in range(len(self.domaines)))
       MRVs = [self.toFill[s] for s in range(len(self.toFill)) if len(self.domaines[s])==minMRV]
       if len(MRVs)==1 : return MRVs
       degree = []
       for s in MRVs:
           libre, occupe = self.contrainte(s[0],s[1])
           degree.append(len(libre)) 
       DHs = [ MRVs[s] for s in range(len(MRVs)) if degree[s]==max(degree) ]    
       return DHs
   
    def nextValue(self, indS, x, y):
        nonAffecte, occupe = self.contrainte(x, y)
        if len(nonAffecte)==0 : return self.domaines[indS]
        impact = []
        for val in self.domaines[indS] : 
            compte = sum(val in self.domaines[s] for s in nonAffecte)
            impact.append(compte)
        valeursTries = [x for y, x in sorted(zip(impact,self.domaines[indS]), reverse=True)]
        return valeursTries  
    
def backtracking_search():
    global sudoku, Termine, decompte
    decompte += 1
    #On recherche quel pays choisir en premier en fonction du MRV puis du degré
    listeVariables = sudoku.MRV()
    #S'il n'y a plus de variables à sélectionner on a terminé l'algorithme
    if len(listeVariables)==0 : Termine=True ; return 
    #On choisi un pays au hasard, le premier fait l'affaire 
    S = listeVariables[0]
    #On classe les valeurs à mettre dans S dans l'ordre de l'impact minimum qu'elles peuvent avoir 
    listeValeurs = sudoku.nextValue(S)
    for V in listeValeurs:
        sudoku.Grille[S[0],S[1]]=V
        backtracking_search()
        if (Termine==True) : return
        #On enléve la couleur affectée précédement
        sudoku.Grille[S[0],S[1]]=0
            
sudoku = CSP('sudoku.txt')
Termine = False 
decompte = 0
backtracking_search()