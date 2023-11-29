# -*- coding: utf-8 -*-
"""
Created on Mon Nov 27 08:38:26 2023

@author: matth
"""

instruction = " * - 3 5 + 2 7 "
op = instruction.split()
pos = 0

def evaluation():
    global op, pos
    if op[pos] not in ["+","-","*","/"]:
        return int(op[pos])
    operation = op[pos]
    pos += 1 ; op1 = evaluation()
    pos += 1 ; op2 = evaluation()
    if operation == "+":
        return op1 + op2
    elif operation == "-":
        return op1 - op2
    elif operation == "*":
        return op1 * op2
    elif operation == "/":
        return op1 / op2

print(evaluation())

V = [False, False, False, False, False]
I = ['and 0 not 4', 'or 1 and 2 3', 'or not 0 not 1', 
     'or and 1 3 and 2 not 4', 'or 2 and 1 4']
op = []
for ligne in I:
    op.append(ligne.split())
pos = 0

def expressionBool(num):
    global V, pos, op
    if op[num][pos] not in ["and", "or", "not"]:
        ind = int(op[num][pos])
        return V[ind]
    operation = op[num][pos]
    pos += 1
    op1 = expressionBool(num)
    if operation != 'not':
        pos += 1
        op2 = expressionBool(num)
    if operation == 'and':
        return op1 and op2
    elif operation == 'or':
        return op1 or op2
    else:
        return not op1
    
def ouverture():
    global V, op, pos
    for num in range(len(op)):
        pos = 0
        if expressionBool(num)==False:
            return False
    return True

def interrupteur(num):
    global V, op, trouve
    if num == len(V): return
    if ouverture() == True :
        trouve = True ; return
    for val in [True, False] :
        V[num] = val
        interrupteur(num+1)
        if trouve : return
        V[num] = False
        

        
        
    
    
    
    
    

resultat = ouverture()
