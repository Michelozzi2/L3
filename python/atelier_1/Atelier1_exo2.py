import random

"""
def test():
    i= 0
    while i != 10:
        test = random.randint(1000,3000)
        est_bissextile(test)
        i+=1
        print(test,anneebool)

"""


def est_bissextile(anneeTest):
    """
        Cette fonction renvoie true ou false selon 
        le resultat de la division d'une année par 4
        ou 400 (true si divisible par 4 ou 400 et
        false si pas divisible par 100)
    
    """
    global anneebool

    if anneeTest % 4 == 0 and anneeTest % 100 != 0  or  anneeTest % 400 == 0:
        anneebool = True
    else:
        anneebool = False
    
    return (anneebool)



def main():
    """
        Demande à l'utilisateur d'entrée une année 
        et convertit et verifie si celle-ci est un entier 
    
    """

    testvaleur = True
    while testvaleur == True:
        annee = input('Entrez une année: \n')
        try:
            annee = int(annee)
            annee == int()
            testvaleur = False
        except ValueError:
            print('Vous n avez pas entré un entier')
            
    """Affiche si l'année est biss selon si True ou False"""
    est_bissextile(annee)
    if anneebool == True:
        print(annee,"est bis")
    elif anneebool== False:
        print(annee,"pas bis")

main()


#test()