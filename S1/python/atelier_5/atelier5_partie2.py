import numpy 
import numpy as np
import random

# Crée un tableau numpy avec les valeurs 1 à 5
arr = numpy.array([1, 2, 3, 4, 5]) 
print(arr)


# exemple 1 : Crée un tableau numpy bidimensionnel et parcourt ses éléments
arr = np.array([[1, 2, 3], [4, 5, 6]])
for x in arr:
 print(x)


# Parcourt les éléments individuels du tableau bidimensionnel
arr = np.array([[1, 2, 3], [4, 5, 6]])
for x in arr:
    for y in x:
        print(y)


# Exemple d'utilisation de la fonction np.searchsorted
arr = np.array([6, 7, 8, 9])
x = np.searchsorted(arr, 7)
print(x)

print("\n")


def my_searchsorted(table : object, elt : int)-> int:
    """
    Recherche un indice dans un tableau numpy.

    :param table: Le tableau numpy dans lequel effectuer la recherche.

    :param indice: L'element à rechercher dans le tableau.

    :return: L'indice de l'élément recherché dans le tableau ou -1 s'il n'est pas trouvé.

    """
    col_indice = -1
    longueur_list = len(table)

    for L in range(longueur_list):
        if table[L] == elt:
            col_indice = L
            break

    return col_indice



#Exemple d’usage de la fct np.where
arr = np.array([1, 2, 3, 4, 5, 6, 14])
x = np.where(arr == 5)
print(x)


def my_where(table : object, elt : int )-> list:
    """
    Recherche un indice dans un tableau numpy et renvoie une liste des indices correspondants.

    :param table: Le tableau numpy dans lequel effectuer la recherche.

    :param indice: L'element à rechercher dans le tableau.

    :return: Une liste des indices de l'élément recherché dans le tableau.

    """
    res =[]
    for L in range(len(table)):
        if table[L] == elt:
            res.append(L)
    return res
   

arr = np.array([1, 2, 3, 4, 5, 6, 7, 8])
x = np.where(arr%2 == 0)
print("---------------")
print(x)




A = np.array(([3,1],[6,4]))
B = np.array(([1,8],[4,2]))
A.shape == B.shape 
# true (vérification de la dimension)
R = A + B 
print(R)

print("-------------")



def my_add(tableA : object, tableB : object)-> object:
    """
    Effectue une addition élément par élément de deux tableaux numpy de même forme.

    :param tableA: Le premier tableau numpy.

    :param tableB: Le deuxième tableau numpy.

    :return: Le résultat de l'addition.

    """
    if tableA.shape == tableB.shape :
        for L in range(len(tableA)):
             for col in range(len(tableA[L])):
                tableA[L, col] += tableB[L, col]
    return tableA


        
def matrice3X3()->object:
    """
    Crée une matrice 3x3 remplie de nombres aléatoires entre 1 et 9.

    :return: La matrice 3x3 générée.
    """
    matrice = np.array(([0]*3,[0]*3,[0]*3))
    for L in range(len(matrice)):
        for col in range(len(matrice[L])):
            matrice[L, col] = random.randint(1, 9)
    return matrice


def operation_elementaire(matrice: object) -> object:
    """
    Effectue des opérations élémentaires (ajout de 10 et multiplication par 2) sur une matrice numpy.

    :param matrice: La matrice numpy sur laquelle effectuer les opérations.

    :return: La matrice résultante après les opérations.

    """
    for L in range(len(matrice)):
        for col in range(len(matrice[L])):
            matrice[L, col] += 10
    print(matrice)
    print("----_----------")

    for L in range(len(matrice)):
        for col in range(len(matrice[L])):
            matrice[L, col] *= 2
    return matrice 



def slicing_etindexation(matrice: object)->object:
    """
    Exemple d'opérations de découpage et d'indexation sur une matrice numpy.

    :param matrice: La matrice numpy à découper et indexer.

    :return: Rien, les résultats sont affichés à l'écran.

    """
    print(matrice[1])
    for L in range(len(matrice)):
        colonne = []
        colonne.append(matrice[L,2])
        print(colonne)
    matrice2X2 = np.array(([0]*2,[0]*2))
    for L in range(len(matrice2X2)):
        for col in range(len(matrice2X2[L])):
            matrice2X2[L,col] = matrice[L, col]
    print(matrice2X2)



def matrice_A_4X4()->object:
    """
    Crée une matrice 4x4 remplie de nombres aléatoires entre 1 et 10.

    :return: La matrice 4x4 générée.
    """
    matrice = np.array(([0]*4,[0]*4,[0]*4,[0]*4))
    for L in range(len(matrice)):
        for col in range(len(matrice[L])):
            matrice[L, col] = random.randint(1, 10)
    return matrice


# Créer une matrice identité 4x4
I = np.identity(4)




def matrice_trace(matrice: object)-> int:
    """_summary
    Cette fonction parcours les elements diagonales de la matrice et les ajoutes un a un

    Args:
        matrice (object): Une matrice carrée quelconque

    Returns:
        int: La trace de la matrice
    """
    
    if len(matrice) != len(matrice[0]):
        raise ValueError("La matrice n'est pas carrée.")
    
    # Initialiser la trace à zéro
    trace = 0

    # Parcourir les éléments diagonaux de la matrice
    for i in range(len(matrice)):
        trace += matrice[i][i]

    return trace




def est_symetrique(matrice: object)->bool:
    """_summary_
    Cette fonction compare les element opposé par rapport a la diagonale de la matrice pour
    vérifier si la matrice est symetrique ou non

    Args:
        matrice (object): Une matrice de taille n*n

    Returns:
        bool: True ou False
    """
    # Vérifier si la matrice est vide
    if not matrice:
        return False

    # Vérifier si le nombre de lignes est égal au nombre de colonnes
    if len(matrice) != len(matrice[0]):
        return False

    n = len(matrice)

    # Parcourir la matrice et vérifier si elle est symétrique
    for L in range(n):
        for col in range(L + 1, n):
            if matrice[L][col] != matrice[col][L]:
                return False

    return True



def produit_diagonal(matrice: object)-> int:
    """_summary
    Cette fonction parcours les elements diagonales de la matrice et les multiplies un a un

    Args:
        matrice (object): Une matrice carrée quelconque

    Returns:
        int: Le produit des elements de la diagonale de la matrice
    """
    
    if len(matrice) != len(matrice[0]):
        raise ValueError("La matrice n'est pas carrée.")
    
    # Initialiser la trace à zéro
    produit = 1

    # Parcourir les éléments diagonaux de la matrice
    for i in range(len(matrice)):
        produit *= matrice[i][i]

    return produit


def manipulation_supplémentaire(matrice: object)->object:
    """
    Cette fonction calcul l'inverse de A et le multiplie par A.

    :param matrice: La matrice A

    :return: La matrice proche de la matrice identitée

    """
   

    # Générer la matrice A
    matrice = matrice_A_4X4()

    # Calculer l'inverse de A
    A_inverse = np.linalg.inv(matrice)

    # Multiplier A par son inverse
    result = np.dot(matrice, A_inverse)

    print(result)

    # Matrice identité 4x4
    I = np.identity(4)

    # Comparer la matrice résultante avec la matrice identité
    epsilon = 1e-6  # Tolérance pour la comparaison des valeurs (due aux erreurs de précision)

    if np.allclose(result, I, atol=epsilon):
        print("La multiplication de A par son inverse est proche de la matrice identité.")
    else:
        print("La multiplication de A par son inverse n'est pas proche de la matrice identité.")




def Test():
   
    arr = np.array([1, 2, 3, 4, 5, 6, 14])
    print(my_searchsorted(arr, 4))

    arr = np.array([1, 2, 3, 4, 5, 4, 14])
    print("my_where",my_where(arr, 4))

    A = np.array(([3,1],[6,4]))
    B = np.array(([1,8],[4,2]))
    print(my_add(A, B))
    print("------------------------------------------")

    #print(matrice3X3())
    test1 = matrice3X3()
    print(test1)
    print(operation_elementaire(test1))

    print(slicing_etindexation(test1))

    #exo 2
    test2 = matrice_A_4X4()
    print(test2)

    # Afficher la matrice identité
    print("La matrice identité : \n",I)


    print("--------------")
    print(test2)
    test3 = matrice_trace(test2)
    print("La trace est: ",test3)

    print("-------------")

    matrice_symetrique = [[1, 2, 3],
                          [2, 4, 5],
                          [3, 5, 6]]

    matrice_non_symetrique = [[1, 2, 3],
                              [2, 4, 5],
                              [6, 7, 8]]

    print(est_symetrique(matrice_symetrique))  # Devrait afficher True
    print(est_symetrique(matrice_non_symetrique))  # Devrait afficher False


    test4 = produit_diagonal(test2)
    print("Le produit est: ",test4)
    print("-----------")

    #3. Application des fonctions
    print(test2)
    test5 = matrice_trace(test2)
    print("La trace est: ",test5)

    #4)
    print(test2)
    test6 = manipulation_supplémentaire(test2)
    print(test6)



   
Test()