nombre = int(input("Entrer un nombre positif\n"))
compteur = 0
while nombre < 1:
    nombre = int(input("Entrer un nombre positif!!!\n"))
save = nombre

while nombre % 2 == 0:
    nombre/=2
    compteur += 1

print(save,"est" ,compteur, "fois divible par 2")
