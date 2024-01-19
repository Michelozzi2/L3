# -*- coding: utf-8 -*-
"""
Created on Tue Dec 12 13:57:45 2023

@author: matth
"""
import numpy as np


#parametres et variables
sudoku = np.loadtxt('sudoku.txt')
cases = np.where(sudoku==0)
trouve = False


def accepte(e, i):
    global sudoku, cases
    x = cases[0][e] ; y = cases[1][e]
    if i in sudoku[:,y] : return False
    if i in sudoku[x,:] : return False
    A = (x//3)*3 ; B = (y//3)*3    
    if i in sudoku[A:A+3, B:B+3] : return False
    return True


def fill_sudoku(e):
    global sudoku, cases, trouve, compteur
    compteur+=1
    if e==len(cases[0]):
        trouve=True
        return
    for i in range(1,10):
        if accepte(e, i):
            x = cases[0][e] ; y = cases[1][e]
            sudoku[x,y] = i
            fill_sudoku(e+1)
            if trouve :
                return
            sudoku[x,y] = 0
          
compteur = 0    
fill_sudoku(0)
