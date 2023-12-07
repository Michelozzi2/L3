# -*- coding: utf-8 -*-
"""
Created on Tue Dec  5 15:57:36 2023

@author: matth
"""

nbR = 8
Reines = [-1]*nbR
Trouve = False

def accepter(pos,e):
    global Reines
    #if pos in Reines[0:e]
    if pos in Reines:
        return False
    for ligne in range(e):
        if abs(e-ligne)==abs(pos-Reines[ligne]):
            return False
    return True

def placerReine(e):
    global nbR, Reines, Trouve
    if e==nbR:
        Trouve=True; return
    for pos in range(8):
        if accepter(pos, e):
            Reines[e]=pos
            placerReine(e+1)
            if Trouve : return
            Reines[e]=-1

placerReine(0)