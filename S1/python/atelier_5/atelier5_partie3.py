import numpy as np

def matriceAdjacence(S: list,A: list)->object:
    """_summary_
    Cette fonction genere une matrice a partir d'un graphe 

    Args:
        S (list): liste de sommet
        A (list): liste de tuple representant les relations entre les sommets

    Returns:
        object: matrice representant le graphe
    """

    taille_S = (len(S),len(S))
    matrice = np.zeros(taille_S)
    
    a = b = 0
    for L in range(len(A)):
        a, b = A[L]
        matrice[a][b] = 1
    return matrice

def matriceAdjacencePond(S: list,A: list)->object:
    """_summary_
    Cette fonction genere une matrice a partir d'un graphe 

    Args:
        S (list): liste de sommet
        A (list): liste de triplets representant les relations entre les sommets

    Returns:
        object: matrice representant le graphe
    """

    taille_S = (len(S),len(S))
    matrice = np.zeros(taille_S)
    
    a = b = c =0
    for L in range(len(A)):
        a, b, c = A[L]
        matrice[a][b] = c
    return matrice

def lireMatriceFichier(nomfichier: str)->object:
    """
    Lit une matrice carrée à partir d'un fichier texte et la renvoie sous forme d'un tableau NumPy.

    Args:
        nom_fichier (str): Le chemin du fichier à partir duquel la matrice doit être lue.

    Returns:
        numpy.ndarray: La matrice lue à partir du fichier.

    Raises:
        FileNotFoundError: Si le fichier spécifié n'existe pas.
        ValueError: Si la matrice lue n'est pas carrée.
    """

    try:
        # Lire le contenu du fichier dans une variable
        with open(nomfichier, 'r') as fichier:
            lignes = fichier.readlines()
        
        # Créer une liste pour stocker les lignes de la matrice
        lignes_matrice = [ligne.strip().split() for ligne in lignes]
        
        # Convertir la liste de lignes en un tableau NumPy
        matrice_np = np.array([list(map(float, ligne)) for ligne in lignes_matrice])
        
        # Vérifier si la matrice est carrée
        if matrice_np.shape[0] == matrice_np.shape[1]:
            return matrice_np
        else:
            raise ValueError("La matrice n'est pas carrée.")
    
    except FileNotFoundError:
        raise FileNotFoundError("Le fichier spécifié n'existe pas.")
    except Exception as e:
        raise e
    


def tousLesSommets(mat: object)->list: 
    """_summary_
    Cette fonction parcourt la matrice et retourne les sommets(indices) de cette meme matrice


    Args:
        mat (object): La matrice mat 

    Returns:
        list: La liste des sommets
    """
    indice_list = []
    i = 0
    while i < len(mat):
        indice_list.append(i)
        i += 1
    return indice_list



def listeArcs(mat: object)->list:
    """_summary_
    Cette fonction parcourt la matrice et renvoie le tuple correspondant a la valeur 1
    correspondant a l'arc lorsqu il le recontre

    Args:
        mat (object): La matrice mat

    Returns:
        list: La liste de tuple 
    """
    res = []
    longueur_mat = len(mat)
    for L in range(longueur_mat):
        for col in range(longueur_mat):
            if  mat[L][col]== (1.0):
                res.append((L,col))
    return res




def matriceIncidence(mat:object)->object: 
    """
    Cette fonction calcul la amtrice incidente

    :param matrice: La matrice adjacente

    :return: La matrice incidente

    """
    lst_arc= listeArcs(mat)
    taille_mat = ((len(mat),len(lst_arc)))
    matrice =np.zeros(taille_mat)
    taille_mat_incidence = len(matrice)
    taille_list_arc = len(lst_arc)

    """
    
    for L in range(taille_mat_incidence):
        for col in range(taille_mat_incidence):
            if  mat[L][col] == (1.0) :
                matrice[L][col] = matrice[col][L] = 1
    return matrice
    """

    a = b = 0
    for L in range(taille_list_arc):
        a, b = lst_arc[L]
        matrice[a][b] = matrice[b][a] = 1
    return matrice



def  est_voisin(matrice: object, S:int , V:int)->bool:
    """_summary_
    Cette fonction return True ou False en fonction de la presence ou non d'un arc entre de sommets(voisin)

    Args:
        matrice (object): La matrice adjacente
        S (int): sommet 1
        V (int): sommet 2

    Returns:
        bool: True ou False
    """

    
    """
    lst_arc= listeArcs(matrice)
    taille_list_arc = len(lst_arc)
    res = False
    for L in range(taille_list_arc):
        if lst_arc[L] == (S,V) or lst_arc[L] == (V,S):
            res = True
    return res
    """

    lst_arc= listeArcs(matrice)
    taille_list_arc = len(lst_arc)
    res = False
    L = 0
    while L < taille_list_arc  and res == False:
        if lst_arc[L] == (S,V) or lst_arc[L] == (V,S):
            res = True
        L += 1
    return res






def Test():
    
    liste_de_sommet1 = [0, 1 ,2 ,3 ,4]
    liste_de_tuple = [(0,1), (0,2),(1,2),(1,4),(2,3),(3,4),(4,2)]
    Test = matriceAdjacence(liste_de_sommet1, liste_de_tuple)
    print("la matrice d'adjacence est : \n", Test)

    liste_de_sommet2 = [0, 1 ,2 ,3 ,4]
    liste_de_triplet = [(0,1,4), (0,2,6),(1,2,1),(1,4,3),(2,3,7),(3,4,6),(4,2,4)]
    Test2 = matriceAdjacencePond(liste_de_sommet2, liste_de_triplet)
    print("la matrice d'adjacence est : \n", Test2)
    print("------------------")

    nom_fichier = "./atelier_5/graph4.txt"
    matrice_resultante = lireMatriceFichier(nom_fichier)
    print(matrice_resultante)

    print("--------------------")
    print("La liste des sommets : ",tousLesSommets(Test) )
    print("La liste des arcs : ",listeArcs(Test) )

    print("----------------------")
    print(matriceIncidence(Test))
    print("-------------------")

    if est_voisin(Test, 2,3):
        print("Les deux sommets sont voisins")

    else:
        print("Les deux sommets ne sont pas voisins")




Test()