# -*- coding : utf8 -*-
"""Calcul d'un prix TTC."""

# Programme principal =========================================================
prixHT = float(input("Prix HT (0 pour terminer) ?"))
while prixHT > 0:
    print('Prix TTC : {:.2f}\n'.format(prixHT * 1.196))
    prixHT = float(input("Prix HT (0 pour terminer) ?"))

print("Au revoir !")