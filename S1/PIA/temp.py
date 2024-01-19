# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
import numpy as np
import copy
data = np.loadtxt('sac_a_dos.txt', dtype=int)
"""
x = data[:,1]/data[:,2]
data = np.c_[data,x]

def bigger(indices):
    indPG = indices[0]
    for ind in indices:
        if data[ind,3]>data[indPG,3] :
            indPG = ind
    return indPG
    
def biggers(nb):
    L = []
    
    for ind in range(len(data)) :
        L.append(ind)
    ListePG = []
    for i in range(nb):
        ind = bigger(L)
        ListePG.append(ind)
        L.remove(ind)
    return ListePG

def remplir(w=15):
    objets = []
    poids = 0
    cout = 0
    L = []
    for ind in range(len(data)) :
        L.append(ind)
    for i in range(len(data)) :
        ind = bigger(L)
        if poids+data[ind,2]<=w :
            objets.append(ind)
            poids = poids + data[ind,2]
            cout = cout + data[ind,1]
        L.remove(ind)
    return objets, poids, cout
        
print(biggers(4))
objets ,poids , cout = remplir(17)
"""
data = np.delete(data, (0), axis=1)

def dynamique(Weigth):
    """
    Cpred = []
    for i in range(Weigth+1):
        Cpred.append(0)
    print(Cpred)
    """
    Cpred = [0]*(Weigth+1)
    SacPred = [[]] *(Weigth+1)
    for ind in range(len(data)):
        C = [0] *(Weigth+1)
        Sac = []
        for w in range(0, Weigth+1):
            poids = data[ind][1]
            cout = data[ind][0]
            if((w<poids) or (Cpred[w] > (Cpred[w-poids]+cout))):
                C[w] = Cpred[w]
                Sac.append(list(SacPred[w]))
            else:
                C[w] = Cpred[w-poids] + cout
                Sac.append(list(SacPred[w-poids]))
                Sac[-1].append(ind)
        
        Cpred = copy.deepcopy(C)
        SacPred = copy.deepcopy(Sac)
    return Sac, C
Sac, C = dynamique(15)
print(Sac, C)
    
    

        
    
