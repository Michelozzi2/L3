import matplotlib.pyplot as plt


def histo(F: list) -> list:
    """
    Cette fonction renvoie le nombre d'apparition d'un element d'une liste F a l'indice correspondant
    dans une seconde liste H

    Args:
        F (list): Une liste d'entier

    Returns:
        list: Une liste d'entier (nombre d'apparition)
    """
    max_count = max(F)

    H = [0] * (max_count + 1)

    for count in F:
        H[count] += 1
    return H



def est_injective(F:list) -> bool:
    H = histo(F)
    
    if  all(count <= 1 for count in H):
        return True
    else:
        return False
    

    
def est_surjective(F: list) -> bool:
    H = histo(F)
    
    for count in H:
        if count < 1:
            return False

    return True



def est_bijective(F:list)-> bool:
    return est_injective(F) and est_surjective(F)



def AffichageHisto(F:list)->str:
    """Affichage de l'histogramme sur terminal et matplotlib

    Args:
        F (list): liste d'entier

    Returns:
        str: affichage terminal
    """
    H = histo(F)
    MAXOCC = max(H)
    lignes = ""

    for i in range(MAXOCC, 0, -1):
        line =""
        for j in range(len(H)):
            count = H[j]
            if count >= i:
                line += "   #|"
            elif count <= i:
                line += "   -|"
        print(line)

    for num in range(len(H)):
        if num < 10:
            lignes += "  "
            lignes += str(num)
            lignes += "  "
        else:
            lignes += " "
            lignes += str(num)
            lignes += "  "

    print(lignes)        
    """  
    numbers_line = ' '.join([str(num) for num in range(len(H))]) 
    print(numbers_line)

    """



def test():

    list_test = [6,5,6,8,4,2,1,5]
    list_test2 = [3,0,6,7,4,2,1,5]
    list_test3 = [1 ,5 ,5 ,5 ,9 ,11 ,11 ,15 ,15 ,15 ,15]
    print("Test histo: ", histo(list_test2))
    print("Test est_injective: ", est_injective(list_test))
    print("Test est_surjective: ", est_surjective(list_test2))
    print("Test est_bijective: ", est_bijective(list_test2))

    
    plt.hist(list_test3, range = (min(list_test3), max(list_test3)), bins = max(list_test3), color = 'blue',
            edgecolor = 'black')
    plt.xlabel('nombres')
    plt.ylabel('occurence dans la liste')
    plt.show()
    
    print(AffichageHisto(list_test3))

    

test()
