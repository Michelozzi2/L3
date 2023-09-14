def places_lettre(ch : str, mot : str) -> list:
    longueur_liste = len(mot)
    resultat = []
    for i in range(longueur_liste):
        if mot[i] == ch:
            resultat.append(i)
    return resultat


def outputStr(mot:str, lpos:list)-> str:
    longueur = len(mot)
    resultat = 0
    if lpos == []:
        resultat = longueur* '_'
    elif lpos != []:
        for longueur in mot:
            if lpos[longueur] == 

    return resultat
    



def test_exercice():
    print(places_lettre('b', 'bonbour'))
    print(outputStr('bonjour', []))

test_exercice()