# -*- coding: utf-8 -*-

import re

nom_fichier = './compilation/compilateurPython/monProgramme.txt'
# Ouvrir le fichier en mode lecture
with open(nom_fichier, 'r') as fichier:
    # Lire le contenu du fichier
    code = fichier.read()

code = code.replace('(', ' ( ').replace(')', ' ) ').replace(',', ' , ').replace(';', ' ; ').replace('.', ' . ')

liste_mots = code.split()

# La liste de mot pour l'exemple est :
# liste_mots=["program",'abc',';','const','C','=','10',';','D','=','8',';',
#          'var','A',',','B',';',
#          'begin',
#          'A',':=','0',';',
#          'B',':=','0',';',
#          'while','A','<>','0','do',
#          'begin',
#          'read','(','A',')',';',
#          'B',':=','A','+','B',';',
#          'end',';',
#          "write",'(','B',')',';', 
#          'end','.']

TOKENS=["program","begin","end","read","write","if","while","(",")","var"]
i=0 #indice du token actuel
ID='[a-zA-Z][a-zA-Z_0-9]*'
NUM='[0-9]+'

token=liste_mots[0]

offset=0
TABLESYM=[]

def entrerSym(classe,value):
    """
    La fonction `entrerSym` ajoute un symbole à la table des symboles avec la classe et la valeur
    données.
    
    :param classe: Le paramètre "classe" permet de préciser la classe du symbole saisi. Il peut s'agir
    d'une constante, d'une variable, d'une fonction, etc
    :param value: Le paramètre value est la valeur associée au symbole saisi. Il peut s'agir d'une
    valeur constante ou de toute autre valeur selon la classe du symbole
    """
    global TABLESYM,offset
    if classe=='constant':
        value=liste_mots[i+1]
    TABLESYM+=[(liste_mots[i-1],classe,value)]
    offset+=1
    
def chercherSym(sym):
    """
    La fonction `chercherSym` recherche un symbole dans la liste `TABLESYM` et le renvoie s'il est
    trouvé, sinon elle appelle la fonction `erreur_dec`.
    
    :param sym: Le paramètre "sym" est un symbole recherché dans la liste "TABLESYM"
    :return: La fonction `chercherSym(sym)` renvoie le symbole `sym` s'il se trouve dans la liste
    `TABLESYM`. Si `sym` n'est pas trouvé, la fonction appelle la fonction `erreur_dec(sym)`.
    """
    global TABLESYM
    res=False
    for s in TABLESYM:
        if s[0]==sym:
            res=s
    if res:
        return res
    else:
        erreur_dec(sym)

length=len(liste_mots)

def next_token():
    global i,token
    if i<(len(liste_mots)-1):
        i+=1
        token=liste_mots[i]
    
    
def erreur_dec(sym):
    """
    La fonction `erreur_dec` imprime un message d'erreur indiquant qu'une variable n'est pas déclarée.
    
    :param sym: Le paramètre "sym" représente un symbole ou une variable non déclarée
    """
    print("variable {} not declared".format(sym))

    
def erreur(exp_token,given_token):
    print("ERREUR ", "expected: ",exp_token, " given: ",given_token)
    
def teste(test_token):
    print('expected:',test_token,'given: ',token) 
    if test_token==token or re.match(test_token,token):
        next_token()
        return 1
    else:
        erreur(test_token, token)
        next_token()
        return 0
        
def test_et_entre(test_token, classe):
    """
    La fonction `test_et_entre` vérifie si un jeton de test donné réussit un test et entre dans le
    symbole avec une classe et une valeur de décalage spécifiées.
    
    :param test_token: Le paramètre `test_token` est un jeton en cours de test. Il s'agit probablement
    d'une variable ou d'une valeur transmise à la fonction
    :param classe: Le paramètre « classe » est une variable qui représente la classe ou le type du token
    testé. Il est utilisé comme argument lors de l'appel de la fonction "entrerSym"
    """
    global offset
    if teste(test_token)==1:
        entrerSym(classe,value=offset)
        
def test_et_cherche(test_token):
    """
    La fonction "test_et_cherche" prend en entrée un jeton de test, vérifie s'il réussit un test, puis
    recherche un symbole.
    
    :param test_token: Le paramètre `test_token` est une variable qui représente un jeton
    """
    tok=token
    if teste(test_token)==1:
        chercherSym(tok)
    
        
def consts():
    teste("const")       
    while re.match(ID,token) and token!='var':
        test_et_entre(ID,"constant")
        teste("=")
        teste(NUM)
        teste(";")

def Vars():
    teste("var")
    test_et_entre(ID,'variable')
    while token==",":
        next_token()
        test_et_entre(ID,'variable')
    teste(";")
    
def fact():
    if re.match(ID,token):
        test_et_cherche(ID)
    elif re.match(NUM, token):
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
    test_et_cherche(ID)
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
    teste("read")
    teste("(")
    test_et_cherche(ID)
    while token==",":
        next_token()
        teste(ID)
    teste(")")

def insts():
    teste("begin")
    inst()  
    while token==";":
        next_token()
        #print("insts:",token)
        inst()
    teste("end")
    
def inst():   
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
    if token=="const":
        consts()
    if token=="var":
        Vars()
    insts()
    
def program():
    teste("program")
    test_et_entre(ID, 'program')
    teste(";")
    block()
    if token != ".":
        erreur(".",token)
    
program()