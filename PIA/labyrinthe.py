# -*- coding: utf-8 -*-
"""
Created on Thu Dec  7 13:40:55 2023

@author: matth
"""

import numpy as np

lab = np.loadtxt("Laby.txt")
D = [0,0]; A = [lab.shape[0]-1,lab.shape[1]-1]
Trouve = False 
Direction = [[1,0],[0,1],[-1,0],[0,-1]]