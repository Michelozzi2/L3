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
    
def Test():

    n = int(input("n ?"))
    resultat = factorielle_recursive(n)
    print("Le factoriel de", n, "est :", resultat)

    
    exp = 0.0
    for i in range(n) :
        exp = exp + 1.0/factorielle_recursive(i)

    print('Approximation de e : {:.8f}'.format(exp))

Test()