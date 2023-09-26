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
    longueur_mot = len(mot)
    resultat = []
    for i in range(longueur_mot):
        if mot[i] == lettre_a_deviner:
            resultat.append(i)
    return resultat


def outputStr(mot:str, lpos:list)->str:
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




def build_list(fileName: str) -> list:
    """_summary_

    Fonction pour construire la liste de mots à partir d'un fichier

    Args:
        fileName (str): Le fichier.txt

    Returns:
        list: La liste des capitales
    """
    words = []
    try:
        with open(fileName, "r") as file:
            lines = file.readlines()
            for line in lines:
                # Supprimer les espaces et les sauts de ligne
                word = line.strip()
                if word:
                    words.append(word.lower())
    except FileNotFoundError:
        print(f"Le fichier '{fileName}' n'a pas été trouvé.")
    return words





def build_dict(lst: list) -> dict:
    """_summary_

    Fonction pour construire un dictionnaire de mots en fonction de leur longueur(a partir des clées)

    Args:
        lst (list): La liste des capitales issue de la fonction build_list

    Returns:
        dict: Un dictionnaire avec des mots organisées en fonction des clées qui representent la longueur
        de ces memes mots
    """
    word_dict = {}
    for word in lst:
        length = len(word)
        if length not in word_dict:
            word_dict[length] = []
        word_dict[length].append(word)
    return word_dict





def select_word(sorted_words: dict, word_len: int) -> str:
    """_summary_
    Cette fonction selectionne un mot aleatoire en fonction de la cle(qui represente la longueur du mot) 
    dans le dictionnaire envoyé

    Args:
        sorted_words (dict): Le dictionnaire le capitales en fonctions des longueurs des mots(clés)
        word_len (int): Un entier qui represente la longueur du mot

    Returns:
        str: un string (le mot choisi aleatoirement en fonction de la clée)
    """
    
    if word_len in sorted_words:
        return random.choice(sorted_words[word_len])
    else:
        return ""
    




def runGame():
    fileName = "./atelier_3/capitales.txt"
    words = build_list(fileName)
    
    if not words:
        print("Aucun mot trouvé dans le fichier.")
        return 1
    
    word_dict = build_dict(words)
    
    # Proposez à l'utilisateur de choisir un niveau de difficulté
    print("Choisissez un niveau de difficulté :")
    print("1. Facile (taille du mot < 7)")
    print("2. Normal (6 < taille du mot < 9)")
    print("3. Difficile (taille du mot > 8)")
    
    choice = input("Entrez le numéro du niveau : ")
    
    if choice == '1':
        word_len = random.randint(min(word_dict.keys()), 6)
    elif choice == '2':
        word_len = random.randint(7, 8)
    elif choice == '3':
        word_len = random.randint(9, max(word_dict.keys()))
    else:
        print("Choix invalide. Sélection automatique d'un niveau.")
        word_len = random.randint(min(word_dict.keys()), max(word_dict.keys()))
    
    mot_a_deviner = select_word(word_dict, word_len)
    
    if not mot_a_deviner:
        print(f"Aucun mot trouvé pour le niveau {choice}. Sélection automatique d'un mot.")
        word_len = random.choice(list(word_dict.keys()))
        mot_a_deviner = select_word(word_dict, word_len)

    tentatives = 7
    lettres_trouvees = []

    print(">> Bienvenue dans le pendu <<")

    while tentatives > 0:
        affichage = outputStr(mot_a_deviner, lettres_trouvees)
        print("\nMot à deviner :", affichage)
        proposition = input("Proposez une lettre : ").lower()

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
            return -1

    if tentatives == 0:
        print("\n>>> Perdu! Le mot était:", mot_a_deviner, "<<<")

    print("\n    * Fin de la partie *    ")

def main():

    runGame()

main()