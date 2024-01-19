import re


nom_fichier = './compilation/compilateurPython/monProgramme.txt'
# Ouvrir le fichier en mode lecture
with open(nom_fichier, 'r') as fichier:
    # Lire le contenu du fichier
    code = fichier.read()

code = code.replace('(', ' ( ').replace(')', ' ) ').replace(',', ' , ').replace(';', ' ; ').replace('.', ' . ')
liste_mots = code.split()

# La ligne `TOKENS=["program","begin","end","read","write","if","while","(",")"]` crée une liste
# appelée `TOKENS ` qui contient les mots-clés et les symboles utilisés dans le langage de
# programmation. 
TOKENS=["program","begin","end","read","write","if","while","(",")"]
i=0 #indice du token actuel
ID='[a-zA-Z][a-zA-Z_0-9]*'
NUM='[0-9]+'

# liste_mots=["program",'abc',';','const','C','=','10',';','var','A',',','B',';',
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

token=liste_mots[0]

length=len(liste_mots)


def next_token():
    """
    La fonction `next_token()` met à jour les variables globales `i` et `token` à la valeur suivante
    dans la liste `liste_mots` si `i` est inférieur à la longueur de `liste_mots` moins 1.
    """
    global i,token
    if i<(len(liste_mots)-1):
        i+=1
        token=liste_mots[i]

def erreur(exp_token,given_token):
    """
    La fonction "erreur" imprime un message d'erreur indiquant les tokens attendus et donnés.
    
    :param exp_token: Le jeton attendu, qui est le jeton qui devait être trouvé dans le code
    :param given_token: Le paramètre `given_token` est le jeton qui a été réellement donné en entrée
    """
    print("ERREUR ", "expected: ",exp_token, " given: ",given_token)
    
def teste(test_token):
    """
    La fonction "teste" vérifie si un jeton donné correspond à un jeton attendu et renvoie 1 si c'est le
    cas, sinon elle appelle la fonction "erreur" et passe au jeton suivant.
    
    :param test_token: Le paramètre `test_token` est une variable qui représente la valeur attendue du
    jeton. Il est utilisé pour comparer la valeur réelle du jeton (« jeton ») et déterminer si elles
    correspondent. S'ils correspondent, la fonction passe au jeton suivant et renvoie 1. S'ils ne
    correspondent pas, la fonction appelle
    :return: 1 si le test_token correspond au jeton ou si le test_token est une expression régulière qui
    correspond au jeton. Sinon, il appelle la fonction erreur() puis appelle la fonction next_token().
    """
    print('expected:',test_token,'given: ',token) 
    if test_token==token or re.match(test_token,token):
        next_token()
        return 1
    else:
        erreur(test_token, token)
        next_token()
        
def consts():
    """
    La fonction « consts » vérifie un modèle spécifique de jetons dans une entrée donnée.
    """
    teste("const")   
    while re.match(ID,token) and token!='var':
        teste(ID)
        teste("=")
        teste(NUM)
        teste(";")
    

def Vars():
    """
    La fonction `Vars` vérifie si une série de variables est déclarée correctement dans un langage de
    programmation.
    """
    teste("var")
    teste(ID)
    while token==",":
        next_token()
        teste(ID)
    teste(";")
    
def fact():
    """
    La fonction vérifie si le jeton correspond à un modèle donné et sinon, elle vérifie les parenthèses
    et appelle une autre fonction.
    """
    if re.match(ID,token) or re.match(NUM, token):
        next_token()
    else:
        teste("(")
        expr()
        teste(")")
    
def term():
    """
    La fonction `term()` effectue une série de calculs en appelant la fonction `fact()` puis en
    vérifiant les opérations de multiplication ou de division.
    """
    fact()
    while token in ["*","/"]:
        next_token()
        fact()
    
def expr():
    """
    La fonction `expr()` imprime le jeton actuel, appelle la fonction `term()`, puis continue d'appeler
    `term()` tant que le jeton est "+" ou "-".
    """
    #print("expr_token: ",token)
    term()
    while token in ["+","-"]:
        next_token()
        term()

def cond():
    """
    La fonction `cond` vérifie si un jeton est un opérateur de comparaison puis évalue deux expressions.
    """
    expr()
    if token in ["==","<>","<",">","<=",">="]:
        next_token()
        expr()
    
def affec():
    """
    La fonction `affec()` appelle les fonctions `teste()` et `expr()` avec les arguments `ID` et `":="`
    respectivement.
    """
    teste(ID)
    teste(":=")
    expr()

def si():
    """
    La fonction « si » est une instruction conditionnelle qui vérifie une condition et exécute un
    ensemble d'instructions si la condition est vraie.
    """
    teste("if")
    cond()
    teste("then")
    inst()

def tantQue():
    """
    La fonction "tantQue" est une boucle qui exécute un ensemble d'instructions tant qu'une certaine
    condition est vraie.
    """
    teste("while")
    cond()
    teste("do")
    inst()

def ecrire():
    """
    La fonction "ecrire" écrit les valeurs d'une ou plusieurs expressions dans la sortie.
    """
    teste("write")
    teste("(")
    expr()
    while token==",":
        next_token()
        expr()
    teste(")")

def lire():
    """
    La fonction `lire()` lit une liste d'identifiants séparés par des virgules.
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
    La fonction `insts` exécute une série d'instructions jusqu'à ce que le jeton ne soit plus égal à
    ";".
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
    La fonction "block" vérifie la valeur de la variable "token" et appelle différentes fonctions en
    fonction de sa valeur, puis appelle la fonction "insts".
    """
    if token=="const":
        consts()
    if token=="var":
        Vars()
    insts()
    
def program():
    """
    La fonction "program" appelle d'autres fonctions et vérifie si le token de fin est ".".
    """
    teste("program")
    teste(ID)
    teste(";")
    block()
    if token != ".":
        erreur(".",token)
    
program()
