from collections import Counter


def placer_objets_vitrines(nbEmplacements: int, lObjets: list)->list:
    # Compter le nombre d'occurrences de chaque objet
    objet_counts = Counter(lObjets)

    # Initialiser les deux vitrines vides
    vitrine1 = []
    vitrine2 = []

    # Remplir la première vitrine avec des objets distincts autant que possible
    for objet, count in objet_counts.items():
        if count > 0 and len(vitrine1) < nbEmplacements:
            vitrine1.extend([objet] * min(count, nbEmplacements - len(vitrine1)))

    # Remplir la deuxième vitrine avec les objets restants de la même manière
    for objet, count in objet_counts.items():
        if count > 0 and len(vitrine2) < nbEmplacements:
            vitrine2.extend([objet] * min(count, nbEmplacements - len(vitrine2)))

    return (vitrine1, vitrine2)


    # Exemple d'utilisation
nbEmplacements = 4
lObjets = [1, 2, 2, 3, 4, 5, 5]
resultat = placer_objets_vitrines(nbEmplacements, lObjets)
if resultat:
    print("Configuration des vitrines:")
    print("Vitrine 1:", resultat[0])
    print("Vitrine 2:", resultat[1])
else:
    print("Impossible de placer les objets dans les vitrines.")
