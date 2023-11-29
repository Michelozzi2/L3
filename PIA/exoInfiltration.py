# -*- coding: utf-8 -*-
"""
Created on Mon Nov 27 09:07:43 2023

@author: matth
"""

import numpy as np



length = 20; deep = 20 ; percent = 0.40
def createsol(deep,length,percent):
    sol=np.zeros((length,deep)) 
    """
    indices = []
    for x in range(length):
        for y in range(deep):
            indices.append((x,y))"""
    nbPo = int(length*deep*percent)
    indPo = np.random.choice(length*deep, nbPo, replace = False)
    for i in indPo :
        #x = indices[i][0] ; y = indices[i][1]
        #sol[x,y]=1
        sol[i//length, i%length] = 1
    return sol

def acceptable(x, y):
    global length, deep, sol
    if (y == length) or (y == -1)  : return False
    if x == deep : return False
    if sol[x,y] != 0 : return False
    return True


def infiltrationtest(x, y):
    global sol
    directions = [(0, 1), (0, -1), (-1, 0), (1, 0)]
    for dx, dy in directions:
        #ne = (x + dx, y + dy)
        ne1 = x + dx
        ne2 = y + dy
        if acceptable(ne1, ne2):
            sol[ne1[0], ne1[1], ne2[0], ne2[1]] = 2
            infiltration(ne1, ne2)
    return sol

def infiltration(x,y):
    for D in [(1, 0), (0, 1), (0, -1)]:
        if acceptable(x+D[0], y+D[1]):
            sol[x+D[0], y+D[1]] = 2
            infiltration(x+D[0], y+D[1])
    return 

def infiltrations():
    for y in range(length):
        if sol[0,y]==0:
            sol[0,y]=2
            infiltration(0, y)
            
        
    

sol = createsol(length, deep, percent)
Lzero = [(0,y)for y in range(length) if sol[0,y]==0]
#res = infiltration(Lzero[0][0], Lzero[0][1])
infiltrations()







