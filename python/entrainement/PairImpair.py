nombre = int(input("Entrer un nombre :\n"))
while nombre <1:
    nombre = int(input("Entrer un nombre positif!!! :\n"))

if nombre % 2 == 0:
    print("pair")
else:
    print("impair")