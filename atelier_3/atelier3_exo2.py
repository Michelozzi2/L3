# Fonction 1: mots_Nlettres(lst_mot, n)
def mots_Nlettres(lst_mot: list, n: int) ->list:
    """
    Renvoie la liste des mots contenant exactement n lettres.

    Args:
    lst_mot (list): La liste de mots à filtrer.
    n (int): Le nombre de lettres recherché.

    Returns:
    list: Une liste des mots de la liste d'origine ayant n lettres.

    """
    #return [mot for mot in lst_mot if len(mot) == n]
    list_mot = []
    for mot in lst_mot:
        if len(mot) == n:
            list_mot.append(mot)
    return list_mot

        
# Fonction 2: commence_par(mot, prefixe)
def commence_par(mot: str, prefixe: str)->bool:
    """
    Vérifie si un mot commence par un préfixe donné.

    Args:
    mot (str): Le mot à vérifier.
    prefixe (str): Le préfixe à rechercher.

    Returns:
    Aucun. La fonction imprime True si le mot commence par le préfixe, False sinon.
    """
    if len(prefixe) > len(mot):
        return False
    for i in range(len(prefixe)):
        if mot[i] != prefixe[i]:
            return False
    return True



# Fonction 3: finit_par(mot, suffixe)
def finit_par(mot:str, suffixe:str)->bool:
    """
    Vérifie si un mot se termine par un suffixe donné.

    Args:
    mot (str): Le mot à vérifier.
    suffixe (str): Le suffixe à rechercher.

    Returns:
    Aucun. La fonction imprime True si le mot se termine par le suffixe, False sinon.
    """
    if len(suffixe) > len(mot):
        return False
    for i in range(1, len(suffixe) + 1):
        if mot[-i] != suffixe[-i]:
            return False
    return True



# Fonction 4: finissent_par(lst_mot, suffixe)
def finissent_par(lst_mot: list, suffixe: str)->list:
    """
    Renvoie la liste des mots présents dans la liste lst_mot qui se terminent par un suffixe donné.

    Args:
    lst_mot (list): La liste de mots à filtrer.
    suffixe (str): Le suffixe à rechercher.

    Returns:
    list: Une liste des mots de la liste d'origine se terminant par le suffixe.

    """

    for mot in lst_mot :
        if finit_par(mot,suffixe):
            return [mot]
        

    #return [mot for mot in lst_mot if finit_par(mot, suffixe)]



# Fonction 5: commencent_par(lst_mot, prefixe)
def commencent_par(lst_mot: list, prefixe:str)->list:
    """
    Renvoie la liste des mots présents dans la liste lst_mot qui commencent par un préfixe donné.

    Args:
    lst_mot (list): La liste de mots à filtrer.
    prefixe (str): Le préfixe à rechercher.

    Returns:
    list: Une liste des mots de la liste d'origine commençant par le préfixe.

    """

    for mot in lst_mot:
        if commence_par(mot, prefixe):
            return [mot]
    
    #return [mot for mot in lst_mot if commence_par(mot, prefixe)]



# Fonction 6: liste_mots(lst_mot, prefixe, suffixe, n)
def liste_mots(lst_mot: list, prefixe:str, suffixe:str, n:int)->list:
    """
    Renvoie la liste des mots présents dans lst_mot qui commencent par un prefixe,
    se terminent par un suffixe et ont une longueur de n lettres.

    Args:
    lst_mot (list): La liste de mots à filtrer.
    prefixe (str): Le préfixe à rechercher.
    suffixe (str): Le suffixe à rechercher.
    n (int): Le nombre de lettres recherché.

    Returns:
    list: Une liste des mots de la liste d'origine satisfaisant les critères.

    """

    mots_filtres = list(filter(lambda mot: commence_par(mot, prefixe) and finit_par(mot, suffixe) and len(mot) == n, lst_mot))
    return mots_filtres



# Fonction 7: dictionnaire(fichier)
def dictionnaire(fichier: str)->list:
    """
    Renvoie la liste des mots présents dans un fichier texte.

    Args:
    fichier (str): Le nom du fichier texte.

    Returns:
    list: Une liste des mots lus à partir du fichier (un mot par ligne).

    """

    fichier=open("./atelier_3/littreUTF8.txt","r")
    list = []
    print("** Contenu du fichier **")
    for ligne in fichier :
        list.append(ligne.rstrip())
    return list




#Procédure de test pour la fonction 7
def test_dictionnaire():
    print("________________________________")
    fichier = "littre.txt"
    mots = dictionnaire(fichier)
    print(mots)

    

test_dictionnaire()

def test_exercice1():
    # Procédure de test pour la fonction 1

    lst_mot = ["jouer", "bonjour", "punir", "jour", "aurevoir", "revoir", "pouvoir", "cour", "abajour", "finir", "aimer"]
    n = 5
    result = mots_Nlettres(lst_mot, n)
    print(f"Les mots de {n} lettres sont: {result}")

    # Test de toutes les fonctions

    # Test de la fonction commence_par
    mot = "bonjour"
    prefixe = "bon"
    resultat = commence_par(mot, prefixe)
    print(f"Le mot '{mot}' commence par '{prefixe}' : {resultat}")
    
    # Test de la fonction finit_par
    mot = "revoir"
    suffixe = "voir"
    resultat = finit_par(mot, suffixe)
    print(f"Le mot '{mot}' se termine par '{suffixe}' : {resultat}")

    print(finissent_par(["abc", "abcd", "abce"], "cd"))
    print(commencent_par(["adc", "abc", "adce"], "ab"))
    print(liste_mots(["abc", "abcd", "abce", "ade"], "ab", "e", 4))
    

test_exercice1()