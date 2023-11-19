# -*- coding: utf-8 -*-


import re

TOKENS=["program","begin","end","read","write","if","while","(",")"]
i=0 #indice du token actuel
ID='[a-zA-Z][a-zA-Z_0-9]*'
NUM='[0-9]+'

PROGRAM=["program",'abc',';','const','C','=','10',';','var','A',',','B',';',
         'begin',
         'A',':=','0',';',
         'B',':=','0',';',
         'while','A','<>','0','do',
         'begin',
         'read','(','A',')',';',
         'B',':=','A','+','B',';',
         'end',';',
         "write",'(','B',')',';', 
         'end','.']

token=PROGRAM[0]

length=len(PROGRAM)

def next_token():
    """
    La fonction `next_token()` met à jour les variables globales `i` et `token` avec le jeton suivant
    dans la liste `PROGRAM` s'il y a plus de jetons disponibles.
    """
    global i,token
    if i<(len(PROGRAM)-1):
        i+=1
        token=PROGRAM[i]
    
    

def erreur(exp_token,given_token):
    print("ERREUR ", "expected: ",exp_token, " given: ",given_token)
    
def teste(test_token):
    #print('expected:',test_token,'given: ',token) 
    if test_token==token or re.match(test_token,token):
        next_token()
        return 1
    else:
        erreur(test_token, token)
        next_token()
        
def consts():
    teste("const")   
    while re.match(ID,token) and token!='var':
        teste(ID)
        teste("=")
        teste(NUM)
        teste(";")
    

def Vars():
    teste("var")
    teste(ID)
    while token==",":
        next_token()
        teste(ID)
    teste(";")
    
def fact():
    if re.match(ID,token) or re.match(NUM, token):
        next_token()
    else:
        teste("(")
        expr()
        teste(")")
    
def term():
    fact()
    while token in ["*","/"]:
        next_token()
        fact()
    
def expr():
    #print("expr_token: ",token)
    term()
    while token in ["+","-"]:
        next_token()
        term()

def cond():
    expr()
    if token in ["==","<>","<",">","<=",">="]:
        next_token()
        expr()
    
def affec():
    teste(ID)
    teste(":=")
    expr()

def si():
    teste("if")
    cond()
    teste("then")
    inst()

def tantQue():
    teste("while")
    cond()
    teste("do")
    inst()

def ecrire():
    teste("write")
    teste("(")
    expr()
    while token==",":
        next_token()
        expr()
    teste(")")

def lire():
    """
    La fonction ci-dessus est un extrait de code Python qui définit une fonction appelée « lire » qui
    lit les entrées de l'utilisateur.
    """
    teste("read")
    teste("(")
    teste(ID)
    while token==",":
        next_token()
        teste(ID)
    teste(")")

def insts():
    """
    La fonction `insts` exécute une série d'instructions jusqu'à ce que le jeton ne soit plus égal à ";"
    ou le jeton est égal à "fin".
    """
    teste("begin")
    inst()  
    while token==";":
        next_token()
        #print("insts:",token)
        inst()
    teste("end")
    
def inst():   
    """
    La fonction `inst()` vérifie la valeur de la variable `token` et appelle différentes fonctions en
    fonction de sa valeur.
    """
    if token=="if":
        si()
    elif token=="while":
        tantQue()
    elif token=="begin":
        insts()
    elif token=="write":
        ecrire()
    elif token=="read":
        lire()
    elif re.match(ID,token) and token not in TOKENS:        
        affec()

        
def block():
    """
    La fonction "block" vérifie la valeur du token et appelle différentes fonctions en fonction de sa
    valeur, puis appelle la fonction "insts".
    """
    if token=="const":
        consts()
    if token=="var":
        Vars()
    insts()
    
def program():
    """
    La fonction "programme" appelle d'autres fonctions et vérifie si le jeton est "." à la fin.
    """
    teste("program")
    teste(ID)
    teste(";")
    block()
    if token != ".":
        erreur(".",token)
    
program()
