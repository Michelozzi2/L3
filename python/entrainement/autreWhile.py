
somme, nombreTotal, nbrSupCents = 0, 0, 0
nombre = float(input("Entrer un nombre positif ou nulle : (0 ou nombre negatif pour terminer)\n"))

while nombre > 0:
    somme += nombre
    nombreTotal += 1
    if nombre > 100:
        nbrSupCents +=1
    nombre = float(input("Entrer un nombre positif ou nulle : (0 ou nombre negatif pour terminer)\n"))
    
print("\nSomme :", somme)
print(nombreTotal, "valeur(s) en tout, dont", nbrSupCents, "supérieure(s) à 100")
