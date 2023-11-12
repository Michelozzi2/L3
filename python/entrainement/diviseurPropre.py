# -*- coding : utf8 -*-
"""Diviseurs propres d'un entier."""

# Programme principal =========================================================
n = int(input("Entrez un entier strictement positif :"))
while n < 1:
    n = int(input("Entrez un entier STRICTEMENT POSITIF, s.v.p. :"))

i = 2 # plus petit diviseur possible de n
cpt = 0 # initialise le compteur de divisions
p = n/2 # calculé une fois dans la boucle

print("Diviseurs propres sans répétition de", n, " :", end=' ')
while i <= p :
    if n%i == 0:
        cpt += 1
        print(i, end=' ')
    i += 1

if not cpt :
    print("aucun ! Il est premier.")
else :
    print("(soit", cpt, "diviseurs propres)")