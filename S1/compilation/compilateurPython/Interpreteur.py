MNEMONIQUES = ["ADD", "SUB", "MUL", "DIV", "EQL", "NEQ", "GTR", "LSS", "GEQ",
               "LEQ", "PRN", "INN", "INT", "LDI", "LDA", "LDV", "STO", "BRN",
               "BZE", "HLT"]


def interpreteur(PCODE):
    """
    La fonction « interpréteur » est un interpréteur pour un langage de programmation personnalisé qui
    exécute une séquence d'instructions stockées dans « PCODE » à l'aide d'un modèle de mémoire basé sur
    une pile.

    :param PCODE: Le paramètre PCODE est une liste d'instructions que l'interpréteur doit exécuter.
    Chaque instruction est représentée sous forme de tuple, où le premier élément est le nom de
    l'instruction (par exemple "ADD", "SUB", etc.) et le deuxième élément est l'opérande de cette
    instruction
    """
    MEM = []
    SP = 0  # pointeur de pile
    PC = 0  # pointeur d'instructions
    PS = "EXECUTION"  # program status
    INST = ""  # instruction en cours
    while PS != "END":
        if isinstance(PCODE[PC], tuple):
            INST, OPERANDE = PCODE[PC]
            # Convertir l'opérande en entier si c'est une chaîne de caractères qui représente un entier
            if isinstance(OPERANDE, str) and OPERANDE.isdigit():
                OPERANDE = int(OPERANDE)
        # print("PC: {},INST: {}".format(PC,INST))
        # print("OPERANDE: ",OPERANDE)
        if PC < (len(PCODE)-1):
            PC += 1
        if INST == "ADD":
            MEM[-2] = MEM[-1]+MEM[-2]
            del MEM[-1]

        elif INST == "SUB":
            MEM[-2] = MEM[-2]-MEM[-1]
            del MEM[-1]

        elif INST == "MUL":
            MEM[-2] = MEM[-1]*MEM[-2]
            del MEM[-1]

        elif INST == "DIV":
            MEM[-2] = MEM[-2]/MEM[-1]
            del MEM[-1]

        # laisse 1 au sommet de pile si sous-sommet = sommet, 0 sinon (idem pour NEQ, GTR, LSS, GEQ, LEQ)
        elif INST == "EQL":
            MEM[-2] = int(MEM[-1] == MEM[-2])
            del MEM[-1]

        elif INST == "NEQ":
            MEM[-2] = int(MEM[-1] != MEM[-2])
            del MEM[-1]

        elif INST == "GTR":
            MEM[-2] = int(MEM[-2] > MEM[-1])
            del MEM[-1]

        elif INST == "LSS":
            MEM[-2] = int(MEM[-2] < MEM[-1])
            del MEM[-1]

        elif INST == "GEQ":
            MEM[-2] = int(MEM[-2] >= MEM[-1])
            del MEM[-1]

        elif INST == "LEQ":
            MEM[-2] = int(MEM[-2] <= MEM[-1])
            del MEM[-1]

        elif INST == "PRN":  # imprime le sommet, dépile
            print("res =", MEM[-1])
            del MEM[-1]

        elif INST == "INN":  # lit un entier, le stocke à l'adresse trouvée au sommet de pile, dépile
            a = int(input("entrez une valeur: "))
            adresse = MEM[-1]
            MEM[adresse] = a
            del MEM[-1]

        # incrémente de la constante c le pointeur de pile (la constante c peut être négative)
        elif INST == "INT":
            MEM += [0]*OPERANDE
            SP += OPERANDE

        elif INST == "LDI":  # empile la valeur v
            MEM += [OPERANDE]

        elif INST == "LDA":  # empile l'adressea
            MEM += [OPERANDE]

        # remplace le sommet par la valeur trouvée à l'adresse indiquée par le sommet (déréférence)
        elif INST == "LDV":
            MEM[-1] = MEM[MEM[-1]]

        elif INST == "STO":  # stocke la valeur au sommet à l'adresse indiquée par le sous-sommet, dépile 2 fois
            MEM[MEM[-2]] = MEM[-1]
            del MEM[-1]
            del MEM[-1]

        elif INST == "BRN":  # branchement inconditionnel à l'instruction i
            PC = OPERANDE

        elif INST == "BZE":  # branchement à l'instruction i si le sommet = 0, dépile
            if (MEM[-1] == 0):
                PC = OPERANDE
            del MEM[-1]

        elif INST == "HLT":  # Arrete le programme
            PS = "END"
        # print("MEM: {}".format(MEM))


# La liste `PCODE` est une représentation d'un programme dans un langage de type assembleur
# personnalisé. Chaque élément de la liste représente une instruction avec son opérande correspondant.
# Le programme est ensuite exécuté par la fonction `interprète`.
# PCODE=[("INT",2),("LDA",0),("INN",False),("LDA",1),("LDA",0),("LDV",False),
#        ("LDA",1),("LDV",False),("ADD",False),("STO",False),("LDA",0),
#        ("LDV",False),("LDI",0),("EQL",False),("BZE",1),("LDA",1),("LDV",False),
#        ("PRN",False),("HLT",False)]
# PCODE = [('INT', 4), ('LDA', 2), ('LDI', '0'), ('STO', None), ('LDA', 3), ('LDI', '0'), ('STO', None), ('LDI', 1), ('LDA', 2), ('LDV', None), ('LDA', 2), ('LDV', None), ('LDI', '0'), ('LDA', 2), ('INN', None), ('LDA', 3), ('LDI', 1), ('LDA', 2), ('LDV', None), ('LDA', 2), ('LDV', None), ('LDI', 1), ('LDA', 3), ('LDV', None), ('LDA', 3), ('LDV', None), ('ADD', None), ('STO', None), ('LDI', 1), ('LDA', 3), ('LDV', None), ('LDA', 3), ('LDV', None), ('PRN', None), ('HLT', None), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

# # [("LDI",3),("LDI",2),("ADD",False),("PRN",False),("HLT",False)]

# interpreteur(PCODE)