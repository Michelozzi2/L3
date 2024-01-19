from collections import Counter


def vitrines(nbEmplacements: int, lObjet: list)->list:
    """
    Cette fonction renvoie deux listes correspondants a deux vitrines avec des objets different 
    pour chaque vitrines.

    Args:
        nbEmplacements (int): Un nombre entier
        lObjet (list): Une liste d'entier

    Returns:
        list: Deux listes d'entiers 
    """

    nbr_occurrence = Counter(lObjet)
    print(nbr_occurrence)

    # Initialiser les deux vitrines vides
    vitrineUn = []
    vitrineDeux = []
    repetition = list(nbr_occurrence.values())
    
    if all(j <= 2 for j in repetition):
        Test = True
    else:
        Test = False

    if Test == True:
        if len(lObjet) < nbEmplacements * 2:
            # Remplir la première vitrine avec des objets distincts autant que possible
            for i in range(len(lObjet)):
                if len(vitrineUn) <= len(vitrineDeux) and len(vitrineUn) < nbEmplacements and lObjet[i] not in vitrineUn :
                    vitrineUn.append(lObjet[i])
                elif lObjet[i] not in vitrineDeux:
                    vitrineDeux.append(lObjet[i])

            print(vitrineUn, vitrineDeux)
        else:
            print("La liste comporte trop d'élements par rapport au nombre d'emplacement")
    else:
        print("Erreur seulement 2 objets identiques")
            


lObjets = [1, 2, 2, 3, 4, 5, 6, 5, 6 ,7]
print(vitrines(7, lObjets))



