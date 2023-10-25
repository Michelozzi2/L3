# -*- coding: utf-8 -*-
"""
Created on Tue Oct 24 16:11:51 2023

@author: matth
"""
import numpy as np


class CSP():
    def __init__(self, file_name):
        filin = open(file_name, "r")
        self.Pays = filin.readline().split();
        self.size = len(self.Pays)
        self.Domaine = []
        lines = filin.readlines() ; filin.close()
        for line in lines:
            frontieres = line.split()
        
monCSP = CSP('Europe.txt')


