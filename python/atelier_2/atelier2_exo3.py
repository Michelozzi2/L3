def separer(L: list) -> list:
    """
    Réalise un classement dans l'ordre croissant des elements d'une liste dans une autre liste LSEP

    Args:
        L (list): Une liste d'entier positifs , negatifs et valant 0

    Returns:
        list: Une liste ordonnée
    """
    negatif = []
    zero = []
    positif = []

    for nombre in L :
        if nombre < 0:
            negatif.append(nombre)
        elif nombre == 0:
            zero.append(nombre)
        else:
            positif.append(nombre)
        
    LSEP = negatif + zero + positif

    return LSEP

list = [-4 ,3 ,0 ,6 ,-2 ,0]
print("Test separer: ", separer(list))
