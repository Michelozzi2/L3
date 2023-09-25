import random

def is_sorted(lst):
    """
    Vérifie si une liste est triée dans l'ordre croissant.

    Args:
        lst (list): La liste à vérifier.

    Returns:
        bool: True si la liste est triée dans l'ordre croissant, False sinon.
    """
    return all(lst[i] <= lst[i+1] for i in range(len(lst) - 1))



def stupid_sort(lst_to_sort):
    """
    Trie une liste en utilisant le tri stupide.

    Args:
        lst_to_sort (list): La liste à trier.

    Returns:
        list: La liste triée dans l'ordre croissant.
    """
    while not is_sorted(lst_to_sort):
        random.shuffle(lst_to_sort)

    return lst_to_sort




def insertion_sort(list_to_sort):
    """
    Trie une liste sans modifier la liste d'origine en utilisant l'algorithme de tri par insertion.

    Args:
        list_to_sort (list): La liste d'entrée à trier.

    Returns:
        list: Une nouvelle liste contenant les mêmes éléments, triés par ordre croissant.
    """
    # Créez une copie de la liste d'origine pour ne pas la modifier
    sorted_list = list_to_sort.copy()

    # Parcourez la liste à partir du deuxième élément (indice 1)
    for i in range(1, len(sorted_list)):
        # Mémorisez l'élément courant dans une variable temporaire
        x = sorted_list[i]
        j = i

        # Décalez vers la droite les éléments qui sont plus grands que x
        while j > 0 and sorted_list[j - 1] > x:
            sorted_list[j] = sorted_list[j - 1]
            j -= 1

        # Placez x dans le "trou" laissé par le décalage
        sorted_list[j] = x

    return sorted_list




def selection_sort(lst_to_sort):
    """
    Trie une liste de nombres en utilisant l'algorithme de tri par sélection.

    Args:
        lst_to_sort (list): La liste de nombres à trier.

    Returns:
        list: Une nouvelle liste contenant les mêmes éléments triés par ordre croissant.
    """

    n = len(lst_to_sort)
    result = lst_to_sort.copy()  # Copie de la liste pour ne pas la modifier directement
    for i in range(n - 1):
        min_index = i
        for j in range(i + 1, n):
            if result[j] < result[min_index]:
                min_index = j
        if min_index != i:
            result[i], result[min_index] = result[min_index], result[i]
    return result




def bubble_sort(lst_to_sort):
    """
    Trie une liste en utilisant l'algorithme de tri à bulles.

    Args:
        lst_to_sort (list): La liste à trier.

    Returns:
        list: Une nouvelle liste contenant les mêmes éléments triés par ordre croissant.

    """
    n = len(lst_to_sort)
    for i in range(n - 1):
        swapped = False
        for j in range(0, n - i - 1):
            if lst_to_sort[j] > lst_to_sort[j + 1]:
                lst_to_sort[j], lst_to_sort[j + 1] = lst_to_sort[j + 1], lst_to_sort[j]
                swapped = True
        if not swapped:
            # Si aucun échange n'a eu lieu pendant une itération, le tableau est trié.
            return lst_to_sort
        



def merge_sort(list_to_sort):
    """
    Trie une liste en utilisant l'algorithme du tri fusion.

    Args:
        list_to_sort (list): La liste d'entiers à trier.

    Returns:
        list: Une nouvelle liste contenant les éléments triés dans l'ordre croissant.
    """
    # Cas de base : si la liste a un élément ou est vide, elle est déjà triée
    if len(list_to_sort) <= 1:
        return list_to_sort
    
    # Divisez la liste en deux parties à peu près égales
    mid = len(list_to_sort) // 2
    left_half = list_to_sort[:mid]
    right_half = list_to_sort[mid:]
    
    # Triez récursivement les deux moitiés
    left_sorted = merge_sort(left_half)
    right_sorted = merge_sort(right_half)
    
    # Fusionnez les deux moitiés triées
    return merge(left_sorted, right_sorted)



def merge(left, right):
    """
    Fusionne deux listes triées en une seule liste triée.

    Args:
        left (list): La première liste triée.
        right (list): La deuxième liste triée.

    Returns:
        list: Une nouvelle liste triée contenant les éléments des deux listes d'entrée.
    """
    
    result = []
    i = j = 0
    
    # Fusionnez les deux listes triées en une seule liste triée
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    
    # Ajoutez les éléments restants de left (s'il y en a)
    result.extend(left[i:])
    
    # Ajoutez les éléments restants de right (s'il y en a)
    result.extend(right[j:])
    
    return result



def Test():
    #Test 1 :
    liste_non_triee = [5, 2, 9, 1, 5, 6]
    liste_triee = stupid_sort(liste_non_triee)
    print(liste_triee)

    #Test 2
    my_lst_to_sort = [170, 45, 75, 90, 2, 24, 802, 66]
    sorted_lst = insertion_sort(my_lst_to_sort)
    print('La liste avant tri :', my_lst_to_sort)
    print('Le tri par insertion donne :', sorted_lst)
    print("\n")

    #Test 3
    my_lst_to_sort2 = [64, 25, 12, 22, 11]
    sorted_lst = selection_sort(my_lst_to_sort2)
    print('La liste avant tri :', my_lst_to_sort2)
    print('Le tri par sélection donne :', sorted_lst)
    print("\n")
    
    #Test 4
    my_lst_to_sort3 = [5, 2, 9, 1, 5, 6,1 ,6 ,8 ,12]
    sorted_lst = bubble_sort(my_lst_to_sort3.copy())  # Copie pour ne pas modifier la liste d'origine
    print('Avant tri :', my_lst_to_sort3)
    print('Résultat du tri :', sorted_lst)
    print('Après le tri la liste d\'origine n\'a pas été modifiée :', my_lst_to_sort3)
    print("\n")

    # Test 5
    my_lst_to_sort4 = [38, 27, 43, 3, 9, 82, 10]
    sorted_lst = merge_sort(my_lst_to_sort4.copy())  # Copiez la liste pour ne pas la modifier
    print('Avant tri :', my_lst_to_sort4)
    print('Résultat du tri :', sorted_lst)
    print('Après le tri la liste d\'origine n\'a pas été modifiée :', my_lst_to_sort4)


Test()




