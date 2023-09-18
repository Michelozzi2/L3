def full_name(str_arg: str) -> str:
    """
    Prend en paramètre une chaîne de caractères de type 'nom prenom'
    et renvoie la même chaîne avec le nom en majuscules et le prénom
    avec la première lettre seulement en majuscule.

    Args:
        str_arg (str): La chaîne de caractères de type 'nom prenom'.

    Returns:
        str: La chaîne formatée avec le nom en majuscules et le prénom
             avec la première lettre en majuscule.
    """
    
    parts = str_arg.split()
    if len(parts) != 2:
        raise ValueError("La chaîne doit contenir un nom et un prénom séparés par un espace.")
    
    nom = parts[0].upper()
    prenom = parts[1].capitalize()
    
    return f"{nom} {prenom}"

def full_name2(str_arg: str) -> str:
    counter = 0
    nom = ""
    longueur_mot = len(str_arg)
    ascii = 32

    while counter < longueur_mot and str_arg[counter] != " ":
        nom += chr(ord(str_arg[counter]) - ascii)
        counter += 1
    return nom + " " + chr(ord(str_arg[counter:][1]) - ascii) + str_arg[counter+2:]




def is_mail(str_arg:str)->tuple:
    """
    Cette fonction renvoie un tuple qui précise la validité ou non du mail entré 

    Args:
        str_arg (str): Le mail en chaine de caractere

    Returns:
        tuple: Le tuple de validité en entier
    """
    result = (1, "x")
    liste_corps_domaine = str_arg.split(sep="@")
    if len(liste_corps_domaine) != 2:
        result = (0,2)
    else:
        corps = liste_corps_domaine[0]
        domaine = liste_corps_domaine[1]
        #corps
        if  "." in corps[0] or "." in corps[-1] or ".." in corps :
            result = (0,1)
        #domaine
        if "." in domaine[0] or "." in domaine[-1] or ".." in domaine or "_" in domaine  :
            result = (0,3)
        
        elif len(domaine.split(".")) == 1 :
            result = (0,3)
    return result
        
    



def test():

    str_variable2test = "bisgambiglia paul"
    str_variable3test = "bisgambiglia_paul@univ-corse.fr"
    print(full_name(str_variable2test))
    print(full_name2(str_variable2test))
    print(is_mail(str_variable3test))

test()
