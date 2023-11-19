# -*- coding: utf-8 -*-
"""
Created on Mon Nov 13 09:53:33 2023

@author: matth
"""

import numpy as np
import math

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
            if ligne ==x: continue
            if self.Grille[x,ligne]==0:
                libre.append((x,ligne))
            else:
                occupe.append((x,ligne))
                
        #Parcours des colonnes       
        for col in range(self.size):
            if col ==y: continue
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
        self.toFill = [(0,0),(1,4)]
        for s in self.toFill:
            libre, occupe = self.contrainte(s[0], s[1])
            values = []
            for x in occupe : 
                values.append(self.Grille[x[0],x[1]])
            domaines.append([x for x in range(1,self.size+1) if x not in values])
        return domaines
        
    def MRV(self):
        case = np.where(sudoku == 0)
        self.toFill = [(x,y) for x,y in zip(case[0],case[1])]
        return case
    
    
sudoku = CSP('sudoku.txt')
domaines = sudoku.MRV()  