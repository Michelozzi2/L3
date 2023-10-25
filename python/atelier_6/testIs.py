

# 'is'vérifie l'identité des objets en mémoire or en python les petites valeurs de 0 a 256 sont stockés dans le cache aux memes adresses 
# si elles sont egalent pour economiser de la memoire par consequent a partir de 257 les adresses deviennent differentes et x , y aussi
x = 0
y = 0
 
while True:
    x += 1
    y += 1

    if x is y:
        print(f"{x}: equal!")
        print(id(x))
        print(id(y))
    else:
        print(f"{x}: not equal!")
        print(id(x))
        print(id(y))
        break