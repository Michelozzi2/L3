# Définition des tarifs pour les différents services
tarifs_verte = {
    20: 1.16,
    100: 2.32,
    250: 4.00,
    500: 6.00,
    1000: 7.50,
    3000: 10.50,
    
}

tarifs_prioritaire = {
    20: 1.43,
    100: 2.86,
    250: 5.26,
    500: 7.89,
    3000: 11.44,
    
}

tarifs_eco_pli = {
    20: 1.14,
    100: 2.28,
    250: 3.92,
    
}

# Fonction pour calculer le montant de l'affranchissement
def calculer_affranchissement(poids, type_lettre):
    if type_lettre == "verte":
        tarifs = tarifs_verte
    elif type_lettre == "prioritaire":
        tarifs = tarifs_prioritaire
    elif type_lettre == "eco-pli":
        tarifs = tarifs_eco_pli
    else:
        return "Type de lettre non valide"

    for poids_limite, tarif in sorted(tarifs.items()):
        if poids <= poids_limite:
            return tarif
        
    return "Poids trop élevé"
            

def main():
    
    # Demande à l'utilisateur de saisir le poids et le type de lettre
    type_lettre = input("Entrez le type de lettre (verte, prioritaire, eco-pli) : ")
    poids = int(input("Entrez le poids en grammes : "))


    # Calcul et affichage du montant de l'affranchissement
    montant = calculer_affranchissement(poids, type_lettre)
    if isinstance(montant, float):
        print(f"Montant de l'affranchissement : {montant}€")
    else:
        print(montant)

main()