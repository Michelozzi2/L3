# -*- coding: utf-8 -*-
    
# La liste `MNEMONIQUES` est un ensemble de codes mnémoniques utilisés dans l'interpréteur. Chaque
# code mnémonique représente une instruction spécifique pouvant être exécutée par l'interpréteur. Ces
# codes mnémoniques permettent d'identifier et d'exécuter les instructions correspondantes dans la
# fonction 'interprète'.
MNEMONIQUES=["ADD","SUB","MUL","DIV","EQL","NEQ","GTR","LSS","GEQ",
             "LEQ","PRN","INN","INT","LDI","LDA","LDV","STO","BRN",
             "BZE","HLT"]
    
def interpreteur(PCODE):
    """
    La fonction `interprète` est un interpréteur qui exécute une liste d'instructions représentée par
    une liste bidimensionnelle `PCODE` en utilisant un modèle de mémoire basé sur une pile.
    
    :param PCODE: Le paramètre PCODE est une liste de tuples. Chaque tuple représente une instruction
    dans le programme. Le premier élément du tuple est le code d'instruction (par exemple "ADD", "SUB",
    "MUL", etc.) et le deuxième élément est l'opérande de cette instruction
    """
    MEM=[]
    SP=0 #pointeur de pile
    PC=0 #pointeur d'instructions
    PS="EXECUTION" #program status
    INST=""#instruction en cours
    while PS!="END":
        INST=PCODE[PC][0]     
        OPERANDE=PCODE[PC][1]
        #print("PC: {},INST: {}".format(PC,INST))
        #print("OPERANDE: ",OPERANDE)
        if PC<(len(PCODE)-1):
            PC+=1
        if INST=="ADD":
            MEM[-2]=MEM[-1]+MEM[-2]
            del MEM[-1]
        elif INST=="SUB":
            MEM[-2]=MEM[-2]-MEM[-1]
            del MEM[-1]
        elif INST=="MUL":
            MEM[-2]=MEM[-1]*MEM[-2]
            del MEM[-1]
        elif INST=="DIV":
            MEM[-2]=MEM[-2]//MEM[-1]
            del MEM[-1]
        elif INST=="EQL":
            MEM[-2]=int(MEM[-1]==MEM[-2])
            del MEM[-1]
        elif INST=="NEQ":
            MEM[-2]=int(MEM[-1]!=MEM[-2])
            del MEM[-1]
        elif INST=="GTR":
            MEM[-2]=int(MEM[-2]>MEM[-1])
            del MEM[-1]
        elif INST=="LSS":
            MEM[-2]=int(MEM[-2]<MEM[-1])
            del MEM[-1]
        elif INST=="GEQ":
            MEM[-2]=int(MEM[-2]>=MEM[-1])
            del MEM[-1]
        elif INST=="LEQ":
            MEM[-2]=int(MEM[-2]<=MEM[-1])
            del MEM[-1]
        elif INST=="PRN":
            print("res =",MEM[-1])
            del MEM[-1]
        elif INST=="INN":
            a=int(input("entrez une valeur: "))
            adresse=MEM[-1]
            MEM[adresse]=a
            del MEM[-1]
        elif INST=="INT": 
            MEM+=[0]*OPERANDE
            SP+=OPERANDE
        elif INST=="LDI":
            MEM+=[OPERANDE]
        elif INST=="LDA":
            MEM+=[OPERANDE]
        elif INST=="LDV":
            MEM[-1]=MEM[MEM[-1]]
        elif INST=="STO":
            MEM[MEM[-2]]=MEM[-1]
            del MEM[-1]
            del MEM[-1]
        elif INST=="BRN":
            PC=OPERANDE
        elif INST=="BZE":
            if(MEM[-1]==0):
                PC=OPERANDE
            del MEM[-1]
        elif INST=="HLT":
            PS="END"
        print("MEM: {}".format(MEM))
            
        
# La variable `PCODE` est une liste de tuples qui représentent les instructions d'un programme. Chaque
# tuple se compose de deux éléments : le code d'instruction et l'opérande de cette instruction. Les
# instructions du programme sont exécutées par la fonction `interprète`.
PCODE=[("INT",2),("LDA",0),("INN",False),("LDA",1),("LDA",0),("LDV",False),
       ("LDA",1),("LDV",False),("ADD",False),("STO",False),("LDA",0),
       ("LDV",False),("LDI",0),("EQL",False),("BZE",1),("LDA",1),("LDV",False),
       ("PRN",False),("HLT",False)]


PCODe = [
    ("LDI", 10),     # Charge la valeur 5
    ("LDI", 2),     # Charge la valeur 3
    ("DIV", False), # Multiplie les deux valeurs précédemment chargées
    ("PRN", False), # Affiche le résultat
    ("HLT", False)  # Arrête le programme
]

PCOdE = [
    ("INT", 3),     # Alloue de l'espace pour 3 variables
    ("LDA", 1),     # Charge l'adresse de la première variable
    ("LDI", '0'),   # Charge la valeur '0'
    "STO",          # Stocke la valeur '0' à l'adresse de la première variable
    ("LDA", 2),     # Charge l'adresse de la deuxième variable
    ("LDI", '0'),   # Charge la valeur '0'
    "STO",          # Stocke la valeur '0' à l'adresse de la deuxième variable
    ("LDA", 1),     # Charge l'adresse de la première variable
    "LDV",          # Charge la valeur depuis la première variable
    ("LDA", 1),     # Charge l'adresse de la première variable
    "LDV",          # Charge la valeur depuis la première variable
    ("LDI", '0'),   # Charge la valeur '0'
    ("LDA", 1),     # Charge l'adresse de la première variable
    "INN",          # Demande une entrée utilisateur et stocke la valeur à l'adresse de la première variable
    ("LDA", 2),     # Charge l'adresse de la deuxième variable
    ("LDA", 1),     # Charge l'adresse de la première variable
    "LDV",          # Charge la valeur depuis la première variable
    ("LDA", 1),     # Charge l'adresse de la première variable
    "LDV",          # Charge la valeur depuis la première variable
    ("LDA", 2),     # Charge l'adresse de la deuxième variable
    "LDV",          # Charge la valeur depuis la deuxième variable
    ("LDA", 2),     # Charge l'adresse de la deuxième variable
    "LDV",          # Charge la valeur depuis la deuxième variable
    "ADD",          # Additionne les deux valeurs précédemment chargées
    "STO",          # Stocke le résultat dans la mémoire
    ("LDA", 2),     # Charge l'adresse de la deuxième variable
    "LDV",          # Charge la valeur depuis la deuxième variable
    ("LDA", 2),     # Charge l'adresse de la deuxième variable
    "LDV",          # Charge la valeur depuis la deuxième variable
    "PRN",          # Affiche le résultat
    "HLT",          # Arrête le programme
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
]


interpreteur(PCOdE)