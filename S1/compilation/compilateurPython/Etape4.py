# -*- coding: utf-8 -*-

import re
import Interpreteur as etape1


nom_fichier = './compilation/compilateurPython/monProgramme.txt'
# Ouvrir le fichier en mode lecture
with open(nom_fichier, 'r') as fichier:
    # Lire le contenu du fichier
    code = fichier.read()

code = code.replace('(', ' ( ').replace(')', ' ) ').replace(
    ',', ' , ').replace(';', ' ; ').replace('.', ' . ')

liste_mots = code.split()

TOKENS = ["program", "begin", "end", "read",
          "write", "if", "while", "(", ")", "var"]
i = 0  # indice du token actuel
ID = '[a-zA-Z][a-zA-Z_0-9]*'
NUM = '[0-9]+'

# PROGRAM=["program",'abc',';',
#         'var','A',',','B',';',
#         'begin',
#         'A',':=','0',';',
#         'B',':=','0',';',
#         'while','A','<>','0','do',
#         'begin',
#         'read','(','A',')',';',
#         'B',':=','A','+','B',';',
#         'end',';',
#         "write",'(','B',')',';',
#         'end','.']

token = liste_mots[0]

offset = 0
TABLESYM = []


def next_inst(compt):
    return False


def getAdresseFromTableSym(nomVar):
    """
    La fonction `getAdresseFromTableSym` renvoie l'adresse d'une variable stockée dans la table
    `TABLESYM` en fonction de son nom.

    :param nomVar: Le paramètre "nomVar" est une chaîne qui représente le nom d'une variable
    :return: l'adresse de la variable nommée "nomVar" de la table TABLESYM.
    """
    ADDR = 0
    for dec in TABLESYM:
        if dec[0] == nomVar:
            ADDR = dec[2]
    return ADDR


def entrerSym(classe, value):
    global TABLESYM, offset
    if classe == 'constant':
        value = liste_mots[i+1]
    TABLESYM += [(liste_mots[i-1], classe, value)]
    offset += 1


def chercherSym(sym):
    global TABLESYM
    res = False
    for s in TABLESYM:
        if s[0] == sym:
            res = s
    if res:
        return res
    else:
        erreur_dec(sym)


length = len(liste_mots)


def next_token():
    global i, token
    if i < (len(liste_mots)-1):
        i += 1
        token = liste_mots[i]


def erreur_dec(sym):
    print("variable {} not declared".format(sym))


def erreur(exp_token, given_token):
    print("ERREUR ", "expected: ", exp_token, " given: ", given_token)


def teste(test_token):
    # print('expected:',test_token,'given: ',token)
    if test_token == token or re.match(test_token, token):
        next_token()
        return 1
    else:
        erreur(test_token, token)
        next_token()
        return 0


def test_et_entre(test_token, classe):
    global offset
    if teste(test_token) == 1:
        entrerSym(classe, value=offset)


def test_et_cherche(test_token):
    tok = token
    if teste(test_token) == 1:
        chercherSym(tok)


def consts():
    teste("const")
    while re.match(ID, token) and token != 'var':
        test_et_entre(ID, "constant")
        teste("=")
        teste(NUM)
        teste(";")


def Vars():
    teste("var")
    test_et_entre(ID, 'variable')
    while token == ",":
        next_token()
        test_et_entre(ID, 'variable')
    teste(";")


def fact():
    if re.match(ID, token):
        nomVar = token
        test_et_cherche(ID)
        for line in TABLESYM:
            if line[1] == 'constant':
                generer2('LDI', TABLESYM.index(line))
            if line[1] == 'variable':
                generer2('LDA', getAdresseFromTableSym(nomVar))
                generer1('LDV')
    elif re.match(NUM, token):
        generer2('LDI', token)
        next_token()

    else:
        teste("(")
        expr()
        teste(")")


def term():
    global token
    fact()
    while token in ["*", "/"]:
        op = token
        next_token()
        fact()
        if op == "*":
            generer1('MUL')
        else:
            generer1('DIV')


def expr():
    global token
    # print("expr_token: ",token)
    term()
    while token in ["+", "-"]:
        op = token
        next_token()
        term()
        if op == "+":
            generer1('ADD')
        else:
            generer1("SUB")


def cond():
    expr()
    if token in ["==", "<>", "<", ">", "<=", ">="]:
        op = token
        next_token()
        expr()
        if op == "==":
            generer1('EQU')
        elif op == "<>":
            generer1('NEQ')
        elif op == "<":
            generer1('INF')
        elif op == ">":
            generer1('SUP')
        elif op == "<=":
            generer1('INFE')
        elif op == ">=":
            generer1('SUPE')


def affec():
    global token
    # recherche de l'adresse de la variable
    ADDR = getAdresseFromTableSym(token)
    test_et_cherche(ID)
    generer2('LDA', ADDR)
    teste(":=")
    expr()
    generer1('STO')


def si():
    teste("if")
    cond()
    teste("then")
    generer2('BZE', 0)
    inst()


def tantQue():
    global PC
    adresse_debut_boucle = PC  # Sauvegarder l'index du début de la boucle
    teste("while")
    cond()
    generer2('BZE', None)  # Laisser l'index de fin de boucle vide pour l'instant
    adresse_fin_boucle = PC - 1  # Sauvegarder l'index de l'instruction BZE
    teste("do")
    inst()
    generer2('BRN', adresse_debut_boucle)  # Sauter au début de la boucle
    PCODE[adresse_fin_boucle] = ('BZE', PC)  # Mettre à jour l'index de fin de boucle dans l'instruction BZE


def ecrire():
    teste("write")
    teste("(")
    expr()
    generer1('PRN')
    while token == ",":
        next_token()
        expr()
        generer1('PRN')
    teste(")")


def lire():
    teste("read")
    teste("(")
    nomVar = token
    test_et_cherche(ID)
    generer2('LDA', getAdresseFromTableSym(nomVar))
    generer1('INN')
    while token == ",":
        next_token()
        nomVar = token
        teste(ID)
        generer2('LDA', getAdresseFromTableSym(nomVar))
        generer1('INN')
    teste(")")


def insts():
    teste("begin")
    inst()
    while token == ";":
        next_token()
        inst()
    teste("end")


def inst():
    if token == "if":
        si()
    elif token == "while":
        tantQue()
    elif token == "begin":
        insts()
    elif token == "write":
        ecrire()
    elif token == "read":
        lire()
    elif re.match(ID, token) and token not in TOKENS:
        affec()


def block():
    global offset
    if token == "const":
        consts()
    if token == "var":
        Vars()
    generer2('INT', offset)
    insts()


def program():
    teste("program")
    test_et_entre(ID, 'program')
    teste(";")
    block()
    generer1('HLT')
    if token != ".":
        erreur(".", token)


PCODE = [0]*50
PC = 0


def generer1(m):
    """
    La fonction `generer1` attribue une valeur `m` à la liste `PCODE` à l'index `PC` et incrémente `PC`
    de 1.

    :param m: Le paramètre "m" dans la fonction "generer1" permet de préciser la valeur qui sera stockée
    dans le tableau PCODE à la position actuelle indiquée par la variable PC
    """
    global PCODE, PC
    if PC == len(liste_mots):
        print('Error len')
    PCODE[PC] = (m, None)  # Générer un tuple avec m et None
    PC += 1


def generer2(m, a):
    """
    La fonction `generer2` prend deux arguments `m` et `a` et les affecte respectivement aux variables
    globales `PCODE` et `PC`.

    :param m: Le paramètre "m" dans la fonction "generer2" permet de préciser le mode de l'instruction.
    Il peut prendre des valeurs telles que « 0 » pour le mode immédiat, « 1 » pour le mode direct, etc
    :param a: Le paramètre "a" est une valeur qui sera stockée dans la liste PCODE à l'index PC actuel.
    Il représente la deuxième partie de l'instruction ou des données qui doivent être stockées
    """
    global PCODE, PC
    if PC == len(liste_mots):
        print('Error len')
    PCODE[PC] = (m, a)  # Générer un tuple avec m et a
    PC += 1


program()

print(PCODE)

etape1.interpreteur(PCODE)