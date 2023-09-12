from datetime import date

def est_bissextile(annee):
    """
    Vérifie si une année est bissextile.
    
    Args:
        annee (int): L'année à vérifier.
        
    Returns:
        bool: True si l'année est bissextile, False sinon.
    """
    return (annee % 4 == 0 and annee % 100 != 0) or (annee % 400 == 0)

def date_est_valide(jour, mois, annee):
    """
    Vérifie si une date est valide.
    
    Args:
        jour (int): Le jour.
        mois (int): Le mois.
        annee (int): L'année.
        
    Raises:
        ValueError: Si la date n'est pas valide.
    """
    if mois < 1 or mois > 12:
        raise ValueError("Mois invalide")
    if jour < 1:
        raise ValueError("Jour invalide")
    if mois in [1, 3, 5, 7, 8, 10, 12]:
        if jour > 31:
            raise ValueError("Jour invalide pour ce mois")
    elif mois == 2:
        if est_bissextile(annee):
            if jour > 29:
                raise ValueError("Jour invalide pour ce mois en année bissextile")
        elif jour > 28:
            raise ValueError("Jour invalide pour ce mois en année non bissextile")
    else:
        if jour > 30:
            raise ValueError("Jour invalide pour ce mois")

def saisie_date_naissance():
    """
    Demande à l'utilisateur de saisir sa date de naissance.
    
    Returns:
        date: La date de naissance saisie.
    """
    while True:
        try:
            annee = int(input("Entrez l'année de naissance : "))
            mois = int(input("Entrez le mois de naissance : "))
            jour = int(input("Entrez le jour de naissance : "))
            date_naissance = date(annee, mois, jour)
            date_est_valide(jour, mois, annee)  # Vérifie la validité de la date ici
            return date_naissance
        except ValueError as e:
            print(f"Erreur: {e}. Veuillez réessayer.")

def age(date_naissance):
    """
    Calcule l'âge à partir de la date de naissance.
    
    Args:
        date_naissance (date): La date de naissance.
        
    Returns:
        int: L'âge calculé.
    """
    aujourdhui = date.today()
    age = aujourdhui.year - date_naissance.year - ((aujourdhui.month, aujourdhui.day) < (date_naissance.month, date_naissance.day))
    return age

def est_majeur(date_naissance):
    """
    Vérifie si une personne est majeure à la date du jour.
    
    Args:
        date_naissance (date): La date de naissance de la personne.
        
    Returns:
        bool: True si la personne est majeure, False sinon.
    """
    age_personne = age(date_naissance)
    return age_personne >= 18

def test_acces():
    """
    Procédure qui demande la date de naissance de l'utilisateur et affiche un message en fonction de son âge.
    """
    date_naissance = saisie_date_naissance()
    age_personne = age(date_naissance)
    if est_majeur(date_naissance):
        print(f"Bonjour, vous avez {age_personne} ans, Accès autorisé.")
    else:
        print(f"Désolé, vous avez {age_personne} ans, Accès interdit.")

# Testez vos différentes fonctions et procédures
test_acces()