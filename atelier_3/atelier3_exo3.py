import random

def choisir_mot():
    return random.choice(lst)


def places_lettre(lettre_a_deviner : str, mot : str) -> list:
    """
    Recherche les positions d'une lettre donnée dans un mot.

    Args:
        lettre_a_deviner (str): La lettre à rechercher.
        mot (str): Le mot dans lequel rechercher la lettre.

    Returns:
        list: Une liste d'entiers représentant les indices des occurrences de la lettre dans le mot.
    """
    longueur_liste = len(mot)
    resultat = []
    for i in range(longueur_liste):
        if mot[i] == lettre_a_deviner:
            resultat.append(i)
    return resultat


def outputStr(mot, lpos):
    """
    Renvoie une chaîne de caractères avec certains caractères d'un mot remplacés par des tirets.

    Args:
        mot (str): Le mot d'origine.
        lpos (list): Une liste d'entiers représentant les indices des caractères à afficher.

    Returns:
        str: Une chaîne de caractères avec les caractères aux indices spécifiés et des tirets pour les autres.

    """

    longueur = len(mot)
    resultat = ""
    
    if not lpos:
        resultat = "_ " * longueur
    else:
        for i in range(longueur):
            if i in lpos:
                resultat += mot[i]
            else:
                resultat += "_"
    
    return resultat

# Liste de mots
lst =  ["Paris", "Londres", "Berlin", "Rome", "Madrid", "Amsterdam", "Bruxelles", "Lisbonne", "Vienne", "Athènes"
        , "Copenhague", "Oslo", "Stockholm", "Helsinki", "Varsovie", "Budapest"
        , "Prague", "Bratislava", "Sofia", "Bucarest", "Budapest", "Vilnius", "Riga", "Tallinn", "Dublin", "Luxembourg"
        , "La Valette", "Nicosie", "Riga", "Tallinn", "Sarajevo", "Skopje", "Tirana", "Podgorica", "Chisinau", "Tbilissi"
        , "Erevan", "Bakou", "Astana", "Douchanbé", "Bichkek", "Tachkent", "Achgabat", "Achgabat", "Bichkek", "Douchanbé", "Astana"
        , "Bakou", "Erevan", "Tbilissi", "Chisinau", "Podgorica", "Tirana", "Skopje", "Sarajevo", "Nicosie", "La Valette"
        , "Luxembourg", "Dublin", "Helsinki", "Stockholm", "Oslo", "Copenhague", "Athènes", "Vienne", "Lisbonne", "Bruxelles"
        , "Zagreb", "Budapest", "Varsovie", "Prague", "Budapest", "Sofia", "Bratislava", "Bucarest", "Vilnius", "Riga", "Tallinn"
        , "Zagreb"]




def runGame():

    lst_len = len(lst)
    iRand = random.randint(0, lst_len - 1)
    mot_a_deviner = lst[iRand].lower()

    tentatives = 7
    lettres_trouvees = []

    print(">> Bienvenue dans le pendu <<")

    while tentatives > 0:
        affichage = outputStr(mot_a_deviner, lettres_trouvees)
        print("\nMot à deviner :", affichage)
        proposition = input("Proposez une lettre : ")[0].lower()

        if proposition in mot_a_deviner:
            lettres_trouvees += places_lettre(proposition, mot_a_deviner)
            print("-> Bien vu!")
        else:
            tentatives -= 1
            print("-> Nope\n")
            if tentatives == 0:
                print(" ==========Y= ")
            if tentatives <= 1:
                print(" ||/       |  ")
            if tentatives <= 2:
                print(" ||        0  ")
            if tentatives <= 3:
                print(" ||       /|\\")
            if tentatives <= 4:
                print(" ||       /|  ")
            if tentatives <= 5:
                print("/||           ")
            if tentatives <= 6:
                print("==============\n")

        if "_" not in affichage:
            print("\n>>> Gagné! Le mot était:", mot_a_deviner, "<<<")
            break

    if tentatives == 0:
        print("\n>>> Perdu! Le mot était:", mot_a_deviner, "<<<")

    print("\n    * Fin de la partie *    ")

runGame()



def test_exercice():
    
    """
    #Test 1
    lettre_a_deviner = input("Entrez un caractère : ")
    mot = input("Entrez un mot : ")
    indices = places_lettre(lettre_a_deviner, mot)
    if indices:
        print(f"Le caractère '{lettre_a_deviner}' se trouve à l'indice(s) {indices} dans le mot '{mot}'.")
    else:
        print(f"Le caractère '{lettre_a_deviner}' n'est pas présent dans le mot '{mot}'.")
    

    #Test 2
    print(outputStr('bonjour', []))        # '_ _ _ _ _ _ _'
    print(outputStr('bonjour', [0]))       # 'b _ _ _ _ _ _'
    print(outputStr('bonjour', [0, 1, 4])) # 'b o _ _ o _ _'
    print(outputStr('bon', [0, 1, 2]))     # 'b o n'
    print(outputStr('maman', [1, 3]))      # '_ a _ a _'
    """
   

test_exercice()
zfezf