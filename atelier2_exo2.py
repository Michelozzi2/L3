def position(lst: list ,elt: int)-> int:
    """
    Détermine la position d'un élement dans une liste

    Args:
        lst (list): Une liste d'entier
        elt (int): Un element de la liste

    Returns:
        int: L'indice de l'élement recherché dans la liste
    """
    elt_indice = -1
    longueur_list = len(lst)

    for i in range(longueur_list):
        if lst[i] == elt:
            elt_indice = i
            break

    return elt_indice

def position2(lst: list ,elt: int)-> int:
    i=0
    elt_indice = -1
    longueur_list = len(lst)

    while i  != longueur_list:
        if lst[i] == elt:
            elt_indice = i
            break
        i += 1

    return elt_indice

def nb_occurrences(lst: list ,e: int) -> int:
    """
    Compte le nombre d'occurrences d'un élement dans une liste

    Args:
        lst (list): Une liste d'entier
        e (int): L'élement recherché

    Returns:
        int: Le nombre d'occurrences du nombre recherché
    """
    occurrences = 0

    for i in lst:
        if i == e:
            occurrences += 1

    return occurrences

def est_triee(lst: list) -> bool:
    """
    Vérifie si une liste d'entiers est triée par ordre croissant.

    Args:
        lst (list): Une liste d'entiers à vérifier.

    Returns:
        bool: True si la liste est triée par ordre croissant, False sinon.
    """
    for i in range(len(lst) - 1):
        if lst[i] > lst[i + 1]:
            return False
    return True

def est_triee2(lst: list) -> bool:
    i = 0
    while i < len(lst) - 1:
        if lst[i] > lst[i + 1]:
            return False
        i += 1
    return True

def position_tri(lst: list, e: int) -> int:
    """
    Recherche la position d'un element d'une liste triée par l'intermediaire d'un algo de tri dichotomique

    Args:
        lst (list): Une liste d'entier triée dans l'ordre croissant
        e (int): élement recherché

    Returns:
        int: L'indice ou la position de l'indice recherché
    """
    left, right = 0, len(lst) - 1
    
    while left <= right:
        mid = (left + right) // 2
        if lst[mid] == e:
            return mid
        elif lst[mid] < e:
            left = mid + 1
        else:
            right = mid - 1
    
    return -1  # Retourne -1 si l'élément n'est pas trouvé dans la liste triée

def a_repetitions(lst: list) -> bool:
    """
    Determine si une liste possede une repetition d'elements

    Args:
        lst (list): Une liste d'entiers

    Returns:
        bool: un booleen True ou False
    """
    T = []
    i=0
    longueur_list = len(lst)
    while i != longueur_list:
        if lst[i] not in T:
            T.append(lst[i])
        else:
            return True
        i += 1

    return False



def test_exercice2():
    """
    Effectue des tests sur les fonctions définies ci-dessus.
    
    """
    list_test = [5 ,4 ,9 ,7 ,3 ,22, 41, 12]
    print("Test position: ", position(list_test ,41))
    print("Test position2: ", position2(list_test ,41))

    list_test2 =[5 ,6 ,6 ,8 , 5, 12, 5] 
    print("Test occurrences: ", nb_occurrences(list_test2 ,5))

    list_test3 = [1 ,2 ,3 ,4 ,8]
    print("Test est_triee: ", est_triee(list_test3))
    print("Test est_triee2: ", est_triee2(list_test3))

    # Créez une liste non triée
    list_test4 = [10, 2, 8, 3, 7, 1, 9, 5, 4, 6]

    # Triez la liste en utilisant la fonction sorted pour obtenir une nouvelle liste triée
    lst_triee = sorted(list_test4)

    # Ou utilisez la méthode sort pour trier la liste elle-même
    # list_test4.sort()

    # Affichez la liste triée
    print("Liste triée :", lst_triee)
    element_recherche = 7
    position3 = position_tri(lst_triee, element_recherche)
    if position != -1:
        print(f"L'élément {element_recherche} se trouve à la position {position3} dans la liste triée.")
    else:
        print(f"L'élément {element_recherche} n'est pas présent dans la liste triée.")


    list_test5 = [1, 2, 3, 4, 5, 6, 1] 
    print("Test répetition: ", a_repetitions(list_test5))



test_exercice2()


