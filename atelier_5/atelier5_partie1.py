def somme_recursive(liste:list)->int:
    """
    Calcule la somme des éléments d'une liste de manière récursive.

    Args:
        liste (list): La liste d'entiers dont la somme doit être calculée.

    Returns:
        int: La somme des éléments de la liste.

    Raises:
        ValueError: Si la liste est vide, une erreur ValueError est levée.
    """

    if len(liste) == 0:
        return ValueError ("Liste vide")
    
    if len(liste) == 1:
        return liste[0]
    else:
        return liste[0] + somme_recursive(liste[1:])
    
    

def factorielle_recursive(nombre:int)->int:
    """
    Calcule la factorielle d'un nombre de manière récursive.

    Args:
        nombre (int): Le nombre entier dont la factorielle doit être calculée.

    Returns:
        int: La factorielle du nombre.

    Note:
        La factorielle de 0 est définie comme étant 1.
    """

    if nombre == 0:
        return 1
    else:
        return nombre*factorielle_recursive(nombre-1)
    


def longueur(lst: list)->int:
    """
    Calcule la longueur d'une liste de manière récursive.

    Args:
        lst (list): La liste dont la longueur doit être calculée.

    Returns:
        int: La longueur de la liste.
    """
    if not lst:
        return 0
    else:
        return 1 + longueur(lst[1:])
    

    
def findMin(lst: list)->int:
    """
    Trouve le minimum d'une liste de manière récursive.

    Args:
        lst (list): La liste d'entiers dans laquelle chercher le minimum.

    Returns:
        int: Le minimum de la liste.

    Raises:
        ValueError: Si la liste est vide, une erreur ValueError est levée.
    """

    mini = None
    if len(lst) == 0:
        raise ValueError("liste vide")
    elif len(lst) == 1:
        mini = lst[0]
    else :
        mini = findMin(lst[1:]) 
        if mini > lst[0]:
            mini = lst[0]
    return mini



def listpairs(lst: list)->list:
    """
    Retourne une liste contenant uniquement les éléments pairs d'une liste donnée.

    Args:
        lst (list): La liste d'entiers à partir de laquelle extraire les éléments pairs.

    Returns:
        list: Une liste contenant les éléments pairs de la liste initiale, dans le même ordre.

    Note:
        Les éléments pairs sont déterminés par la parité de leur valeur.
    """

    if lst == []:
        return []
    else:
        if lst[0] % 2 == 0:
            return [lst[0]] + listpairs(lst[1:])
        else:
            return listpairs(lst[1:])
        
        

        
def concat_list(llst: list)->list:
    """
    Concatène une liste de listes en une seule liste.

    Args:
        llst (list): La liste de listes à concaténer.

    Returns:
        list: Une liste contenant tous les éléments des listes de llst, dans le même ordre.

    Note:
        Cette fonction concatène les listes de manière récursive.
    """

    if llst == []:
        return []
    else:
        return llst[0] + concat_list(llst[1:])
    

def separe(lst: list)->tuple:
    """
    Sépare une liste en deux listes, une contenant les éléments pairs et l'autre les éléments impairs.

    Args:
        lst (list): La liste d'entiers à séparer.

    Returns:
        tuple: Un tuple contenant deux listes, la première avec les éléments pairs et la deuxième avec les éléments impairs.

    Note:
        Cette fonction effectue la séparation de manière récursive.
    """
    if lst == []:
        return ([],[])
    else:
        pile = separe(lst[1:])
        if lst[0]%2 == 0:
            pile[1].append(lst[0])
        else:
            pile[0].append(lst[0])
        return pile


    

def Test():

    liste1 = [1, 2, 3, 4, 5]
    resultat1 = somme_recursive(liste1)
    print("La somme de la liste est :", resultat1)

    liste2 = []
    resultat2 = somme_recursive(liste2)
    print("La somme de la liste est :", resultat2)

    nombre = 5
    resultat = factorielle_recursive(nombre)
    print("Le factoriel de", nombre, "est :", resultat)

    liste3 = [1, 2, 3, 4, 5]
    resultat3 = longueur(liste3)
    print("La longueur de la liste est : ", resultat3)

    liste4 = [8, 12, 3, 4, 5]
    resultat4 = findMin(liste4)
    print("Le minimum est  : ", resultat4)

    liste5 = [8, 12, 3, 4, 5]
    resultat5 = listpairs(liste5)
    print("La liste d elements paires  : ", resultat5)

    liste6 = [[0,1], [2,3], [4], [6,7]]
    resultat6 = concat_list(liste6)
    print("La liste d elements paires  : ", resultat6)

    liste7 = [1,20,2,4,5]
    resultat7 = separe(liste7)
    print("La liste d elements paires  : ", resultat7)



Test()