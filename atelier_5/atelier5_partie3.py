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
    
    a = b =0
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


def Test():
    
    liste_de_sommet1 = [0, 1 ,2 ,3 ,4]
    liste_de_tuple = [(0,1), (0,2),(1,2),(1,4),(2,3),(3,4),(4,2)]
    Test = matriceAdjacence(liste_de_sommet1, liste_de_tuple)
    print("la matrice d'adjacence est : \n", Test)

    liste_de_sommet2 = [0, 1 ,2 ,3 ,4]
    liste_de_triplet = [(0,1,4), (0,2,6),(1,2,1),(1,4,3),(2,3,7),(3,4,6),(4,2,4)]
    Test = matriceAdjacencePond(liste_de_sommet2, liste_de_triplet)
    print("la matrice d'adjacence est : \n", Test)
    print("------------------")

    nom_fichier = "./atelier_5/graph4.txt"
    matrice_resultante = lireMatriceFichier(nom_fichier)
    print(matrice_resultante)



Test()