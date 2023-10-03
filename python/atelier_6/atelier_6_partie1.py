
def listeMultiples(binf: int, bsup: int, nb: int)->list:
    
    return [x for x in range(binf, bsup + 1) if x % nb == 0]


def ajouter(lst: list,nb: int)-> list:

    return[nb+x for x in lst ]

def ajouterSiSup(lst: list,val: int,nb: int)->list :
     
     return[nb+x for x in lst if x >= val ]

def bissextiles(adeb: int,afin: int)->list:

    return [x for x in range(adeb, afin + 1) if x % 4 == 0 and x % 100 != 0  or  x % 400 == 0]



def test():

    test = listeMultiples(1, 10, 2)
    print(test)
    print("-----------")

    list_test = [1,2,3,4,5]
    test2 = ajouter(list_test, 10)
    print(test2)
    print("-----------")

    list_test2 = [1,3,5,7,9,12]
    test3 = ajouterSiSup(list_test2, 6, 5)
    print(test3)



test()