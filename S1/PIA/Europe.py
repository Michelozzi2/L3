# -*- coding: utf-8 -*-
"""
Created on Tue Oct 24 16:11:51 2023

@author: matth
"""
import numpy as np
import math
import random as rd


class CSP():
    def __init__(self, file_name):
        filin = open(file_name, "r")
        self.Pays = filin.readline().split();
        self.size = len(self.Pays)
        self.contrainte = np.zeros((self.size,self.size), dtype=int)
        self.Domaine = []
        self.valeur = []
        lines = filin.readlines() ; filin.close()
        for line in lines:
            pays = line.split()  
            x = pays[0] ; indX = self.Pays.index(x)
            for y in pays[1:]:
                indY = self.Pays.index(y)
                self.contrainte[indX,indY]=1
            self.Domaine.append(['Rouge','Vert','Bleu','Jaune'])
            self.valeur.append("") 
         
        self.MRV()   
         
    def MRV(self):
        nonAffect = [i for i in range(self.size) if self.valeur[i] == "" ]
        if len(nonAffect)==0 : return []
        minMRV = min(len(self.Domaine[i])for i in nonAffect)
        MRVs = [i for i in nonAffect if len(self.Domaine[i])==minMRV]
        if len(MRVs)==1 : return MRVs
        Degree = []
        for s in MRVs:
            Degree.append(sum(self.contrainte[s][x] for x in range(self.size) if self.valeur[x]==""))
        DHs = [MRVs[s] for s in range(len(MRVs)) if Degree[s]==max(Degree)]
        return DHs
        
    def nextvalue(self, indS):
        nonAffect = [s for s in range(self.size) if self.contrainte[indS, s]!=0 and self.valeur[s]==""]
        if len(nonAffect)==0 : return self.Domaine[indS]
        minValide = []
        for v in self.Domaine[indS] :
            minVal = math.inf
            for s in nonAffect:
                val = len(self.Domaine[s]) ; 
                if v in self.Domaine[s] : val -=1 ; 
                if val < minVal : minVal = val
            minValide.append(minVal)
            valeursValides = self.Domaine[indS][:]
            while (0 in minValide) : 
                pos = minValide.index(0) ; 
            del minValide[pos] ; 
            del valeursValides[pos]
            valeursTries = [X for Y, X in sorted(zip(minValide,valeursValides), reverse=True)]
            return valeursTries 


    
europe = CSP('Europe.txt')
Termine = False

def backtracking_search():
    global europe, Termine
    listeVariables = europe.MRV()
    if len(listeVariables)==0 :
        Termine=True ; return
    S = listeVariables[0]
    listeValeurs = europe.nextValue(S)
    for V in listeValeurs:
        europe.Variables[S]=V
        domainesModifies = [x for x in range(europe.size) if europe.Contraintes[S,x]!=0 and 
		europe.Variables[x]=="" and V in europe.Domaine[x]]
        for indS in domainesModifies:
            indV = europe.Domaine[indS].index(V)
            del europe.Domaine[indS][indV]
        backtracking_search()
        if (Termine==True) : return
        for indS in domainesModifies:
            europe.Domaine[indS].append(V)
        europe.Variables[S]=""

backtracking_search()



