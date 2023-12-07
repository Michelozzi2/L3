# -*- coding: utf-8 -*-
"""
Created on Mon Oct 16 10:53:17 2023

@author: matth
"""

import numpy as np
import math
import copy
import random as rd
import itertools as it

"""
valeurs = [9,7,3,8,100,50]
Resultat = 604
op = ['*','+','-','/']
operations = []
trouve = False

def acceptable(N1,N2):
    global op
    list_op = []
    if N1>N2:
        list_op.append('+')
        list_op.append('*')
        if N1!=N2:
            list_op.append('-')
        if N1%N2==0:
            list_op.append('/')
    return list_op

def calcul(N1,N2,op):
    if op =='+':return N1+N2
    if op =='-':return N1-N2
    if op =='*':return N1*N2
    return N1/N2

def LeCompteEstBon(values):
    global Resultat, op, operations, trouve
    if Resultat in values :
        trouve = True
        return
    if len(values)==1 :
        return
    for N1,N2 in it.permutations(values,2):
        for op in acceptable(N1, N2):
            R = calcul(N1, N2, op)
            liste = copy.deepcopy(values)
            liste.remove(N1)
            liste.remove(N2)
            liste.append(R)
            operations.append('{} {} {} = {}'.format(N1, op, N2, R))
            LeCompteEstBon(liste)
            if trouve == True:
                return
            del operations[-1]
            
LeCompteEstBon(valeurs)
            
        
        
    
""" 
    

"""
L = list(range(1,11))*2+[25,50,75,100]
valeurs = []
for i in range(6):
    v = rd.choice(L)
    valeurs.append(v)
    L.remove(v)
Resultat = rd.randint(101, 1000)
"""

"""
sudoku = np.loadtxt('sudoku.txt')
cases = np.where(sudoku==0)
trouve = False


def bloc(Mat,i,j):
    L = []
    for x in range(3*(i//3), 3*(i//3)+3):
        for y in range(3*(j//3), 3*(j//3)+3):
            if Mat[x,y]!=0:
                L.append(Mat[x,y])
    return L

def conflits(Mat,i,j):
    L = [x for x in sudoku[i,:] if x>0]
    L = L+ [x for x in sudoku[:,j] if x>0]
    L = L+ bloc(Mat, i, j)
    return set(L)


def fill_sudoku(num):
    global sudoku, cases, trouve, compteur
    compteur+=1
    if num==len(cases[0]):
        trouve=True
        return
    conf = conflits(sudoku, cases[0][num], cases[1][num])
    for e in range(1,10):
        if e not in conf:
            sudoku[cases[0][num], cases[1][num]]=e
            fill_sudoku(num+1)
            if trouve :
                return
            sudoku[cases[0][num], cases[1][num]]=0
            
compteur = 0    
fill_sudoku(0)

"""
"""
posibilite=[]
for x,y in zip(cases[0],cases[1]):
    posibilite.append(conflits(sudoku, x, y))
    
L = [ind for ind in range(len(posibilite)) if len(posibilite[ind])==8 ]
            
 """ 



Tab = [-1]*8
Trouve = False
def acceptable(e, numReine):
    if e in Tab :
        return False
    for ind in range(len(Tab)):
        if Tab[ind]==-1 :
            return True
        if abs(ind-numReine)==abs(Tab[ind]-e) :
            return False
    return True


def placerReine(numReine):
    global Trouve
    if numReine == 8 :
        Trouve = True
        return
    for e in range(8):
        if acceptable(e, numReine):
            Tab[numReine] = e
            placerReine(numReine+1)
            if Trouve == True : 
                return
            Tab[numReine] = -1
            
placerReine(0)


            
"""
def factorielle(N):
    if(N<0):
        return ValueError("erreur")
    if(N == 0 or N == 1):
        return 1
    else:
        return factorielle(N-1)*N
    
print("factorielle de N = ",factorielle(3))


T1 = [3,2,1]
T2 = []
T3 = []
def hanoi(N,TA,TB,TC,NomA,NomB,NomC):
    if N==1:
         TB.append(TA[-1])
         del TA[-1]
         print("deplacer {} de {} vers {}".format(TB[-1], NomA, NomB))
    else:
        hanoi(N-1, TA, TC, TB, NomA, NomB, NomC)
        hanoi(1, TA, TB, TC, NomA, NomB, NomC)
        hanoi(N-1, TC, TB, TA, NomA, NomB, NomC)
         
hanoi(len(T1), T1, T2, T3, "T1", "T2", "T3")



def somme(N):
    if(N == 0):
        return 0
    else:
        return N+somme(N-1)
    
print("La somme jusqu'a N choisie est : ",somme(3))


def ContientZero(N, pos):
    if N == 0:
        return True, pos
    if N <= 9:
        return False
    if (N%10 == 0):
        return True, pos
    return ContientZero(N//10, pos+1)

print(ContientZero(156464650654, 0))



def puissance(x,n):
    r = 1
    while n > 0 :
        if n % 2 == 1 : r *= x
        x *= x
        n //= 2
    return r

for i in range(0,9) :
    print("8^{0}={1}".format(i, puissance( 8, i)))
    
    
def puissance2(x, n):
    R = 1
    for i in range(n):
        R = R * x
    return R

for i in range(10):
    print(puissance2(2, i))
    
def puissanceRec(x, n):
    if n == 0:
        return 1
    return x * puissanceRec(x, n-1)    

for i in range(10):
    print(puissanceRec(2, i))
    
    
def entier_le_plus_proche(x, tableau):
    # On initialise la variable qui va contenir l'entier le plus proche
    entier_proche = None
    # On initialise la variable qui va contenir la distance minimale
    distance_min = float('inf')

    # On parcourt le tableau d'entiers
    for entier in tableau:
        # On calcule la distance entre x et l'entier actuel
        distance = abs(x - entier)

        # Si la distance actuelle est plus petite que la distance minimale
        if distance < distance_min:
            distance_min = distance
            entier_proche = entier

    return entier_proche

x = 7
tableau = [1,50, 10, 8, 12, 15]
entier_plus_proche = entier_le_plus_proche(x, tableau)
print(f"L'entier le plus proche de {x} dans le tableau est {entier_plus_proche}")


def fibonacci(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)

n = 10 
for i in range(n):
    print(fibonacci(i))
    
def listeFibonacci(N):
    Fib = []
    for i in range(N-1):
        Fib.append(fibonacci(i))
    return Fib

print(listeFibonacci(10))
"""
"""
Tab = np.random.randint(0,5,20)

def compter(D, F, N):
    if D >= F :
        return 0
    M = (D+F)//2
    Milieu = int(Tab[M] == N)
    Gauche = compter(D, M, N)
    Droite = compter(M+1, F, N)
    return Gauche+Droite+Milieu

print(compter(0, len(Tab), 0))

"""
"""

Labyrinthe = np.loadtxt('Laby.txt')
Direction = [ (0,1), (1,0), (0,-1), (-1,0)]
A = (Labyrinthe.shape[0]-1, Labyrinthe.shape[1]-1)
trouve = False
e = (0,0)
Labyrinthe[e[0],e[1]]=1

def acceptable(e, D):
    px = e[0]+D[0]
    py = e[1]+D[1]
    if (px >= Labyrinthe.shape[0]) or (py >= Labyrinthe.shape[1]):
        return False
    if (px < 0) or (py <0):
        return False
    if (Labyrinthe[px,py] ==-1) or (Labyrinthe[px,py] ==1):
        return False
    return True

def chercher(A, e):
    global trouve
    if (A[0]==e[0]) and (A[1]==e[1]) :
        trouve = True ; return
    for D in Direction:
        if acceptable(e, D):
            ne = (e[0]+D[0], e[1]+D[1])
            Labyrinthe[ne[0], ne[1]]=1
            chercher(A, ne)
            if trouve == True:
                return
            Labyrinthe[ne[0], ne[1]]=2
 
#chercher(A, e)



nbEBest = math.inf
LabyrintheBest = copy.deepcopy(Labyrinthe)

    
def chercherBest(A, e, nbE):
    global nbEBest, LabyrintheBest
    if (A[0]==e[0]) and (A[1]==e[1]) :
        if (nbE < nbEBest):
            nbEBest = nbE; LabyrintheBest = copy.deepcopy(Labyrinthe)
            return
        
    for D in Direction:
        if acceptable(e, D):
            ne = (e[0]+D[0], e[1]+D[1])
            Labyrinthe[ne[0], ne[1]]=1
            chercherBest(A, ne, nbE+1)
            Labyrinthe[ne[0], ne[1]]=0
            
chercherBest(A, e, 1)
"""
                
    







    
    
    
