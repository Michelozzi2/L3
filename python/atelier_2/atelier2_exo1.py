def somme_un(L:list) -> int:
    """
    Calcule la somme des éléments d'une liste.

    Args:
        L (list): Une liste d'entiers.

    Returns:
        int: La somme des éléments de la liste.
    """
    resultat = 0
    longueur_list = len(L)
    for i in range(longueur_list):
        resultat += L[i]
    return resultat



 
def somme_deux(L: list) -> int:
    resultat_deux = 0
    for i in L :
        resultat_deux += i
    return resultat_deux



def somme_trois(L:list) -> int:
    i=0
    longueur_list = len(L)
    resultat_trois= 0
    while i != longueur_list:
        resultat_trois += L[i]
        i += 1
    return resultat_trois



def moyenne(L: list)-> float:
    """
    Calcule la moyenne des éléments d'une liste.

    Args:
        L (list): Une liste d'entiers.

    Returns:
        float: La moyenne des éléments de la liste. Si la liste est vide, renvoie 0.
    """
    resultat_quatre = 0
    longueur_list = len(L)
    if longueur_list == 0:
        resultat_quatre = 0
    else:
        resultat_quatre = somme_un(L) / longueur_list
    return resultat_quatre



def nb_sup(L:list,e: int) -> int:
    """
    Compte le nombre d'éléments supérieurs à un certain nombre dans une liste.

    Args:
        L (list): Une liste d'entiers.
        e (int): Le nombre de référence.

    Returns:
        int: Le nombre d'éléments supérieurs à 'e' dans la liste.
    """
    i=0
    nb_sup = 0
    longueur_list =len(L)
    for i in range(longueur_list):
        if e < L[i]:
            nb_sup += 1
    return nb_sup



def nb_sup2(L:list ,e: int) -> int:
    nb_sup2 = 0
    for i in L :
        if e < i :
            nb_sup2 += 1
    return nb_sup2



def moyen_sup(L:list ,e: int) -> float:
    """
    Calcule la moyenne des éléments supérieurs à un certain nombre dans une liste.

    Args:
        L (list): Une liste d'entiers.
        e (int): Le nombre de référence.

    Returns:
        float: La moyenne des éléments supérieurs à 'e' dans la liste.
    """
    list_test2 = []
    resultat = 0
    for i in L:
        if e < i:
            list_test2.append(i)
        resultat = moyenne(list_test2)
    return resultat



def val_max(L:list) -> list:
    """
    Trouve la valeur maximale dans une liste.

    Args:
        L (list): Une liste d'entiers.

    Returns:
        int: La valeur maximale dans la liste.
    """
    nb_max = 0
    longueur_list = len(L)
    for i in range(longueur_list):
        if nb_max < L[i]:
            nb_max = L[i]
    return nb_max

def index_max(L: list) -> int:
    """
    Trouve l'indice de la première occurrence de la valeur maximale dans une liste.

    Args:
        L (list): Une liste d'entiers.

    Returns:
        int: L'indice de la valeur maximale dans la liste.
    """
    max_indice = 0
    longueur_list = len(L)
    for i in range(0, longueur_list):
        if max_indice < i:
            # Si un élément plus grand est trouvé, mettre à jour l'indice et la valeur maximale.
            max_indice = i
            
    return max_indice

def index_max2(L: list) -> int:
    """
    Trouve l'indice de la première occurrence de la valeur maximale dans une liste.

    Args:
        L (list): Une liste d'entiers.

    Returns:
        int: L'indice de la valeur maximale dans la liste.
    """
    max_value = L[0]  # Initialise la valeur maximale avec le premier élément de la liste
    max_index = 0     # Initialise l'indice de la valeur maximale avec 0
    
    for i in range(1, len(L)):
        if L[i] > max_value:
            max_value = L[i]
            max_index = i
            
    return max_index



def test_exercice1 ():
    """
    Effectue des tests sur les fonctions définies ci-dessus.
    
    """
    list_test = []
    print("TEST SOMME")
    print("Test liste vide : ", somme_un(list_test),somme_deux(list_test),somme_trois(list_test))
    print("Test moyenne : ", moyenne(list_test))
    print("Test nombre_sup: ", nb_sup(list_test,10))
    print("Test nombre_sup2: ", nb_sup2(list_test,10))
    print("Test moyen_sup: ", moyen_sup(list_test, 10))
    print("Test valeur_max: ", val_max(list_test))
    print("Test max_index: ", index_max(list_test))


    list_deux_test_un=[1,10,100, 1000,10000]
    print("Test somme 1111 : ", somme_un(list_deux_test_un))
    print("Test moyenne : ", moyenne(list_deux_test_un))
    print("Test nombre_sup: ", nb_sup(list_deux_test_un,100))
    print("Test nombre_sup2: ", nb_sup2(list_deux_test_un,100))
    print("Test moyen_sup: ", moyen_sup(list_deux_test_un, 100))
    print("Test valeur_max: ", val_max(list_deux_test_un))
    print("Test max_index: ", index_max(list_deux_test_un))


liste = [1,2,3] 
#somme_un(liste)  
#somme_deux(liste)
#somme_trois(liste)
test_exercice1()


