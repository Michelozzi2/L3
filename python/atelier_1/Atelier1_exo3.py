import math

# 1. Définition de la fonction discriminant(a, b, c)
def discriminant(a, b, c):
    delta = b**2 - 4*a*c
    print(f"Discriminant (Δ) = {delta}")
    return delta

# 2. Définition de la fonction racine_unique(a, b)
def racine_unique(a, b):
    x = -b / (2*a)
    print(f"Racine unique : x = {x}")

# 3. Définition de la fonction racine_double(a, b, delta, num)
def racine_double(a, b, delta, num):
    if num == 1:
        x1 = (-b + math.sqrt(delta)) / (2*a)
        print(f"Racine 1 : x1 = {x1}")
    elif num == 2:
        x2 = (-b - math.sqrt(delta)) / (2*a)
        print(f"Racine 2 : x2 = {x2}")

# 4. Définition de la fonction str_equation(a, b, c)
def str_equation(a, b, c):
    equation_str = f"{a}x^2"
    if b >= 0:
        equation_str += f" + {b}x"
    else:
        equation_str += f" - {abs(b)}x"
    if c >= 0:
        equation_str += f" + {c}"
    else:
        equation_str += f" - {abs(c)}"
    equation_str += "=0"
    print(equation_str)

# 5. Définition de la fonction solution_equation(a, b, c)
def solution_equation(a, b, c):
    delta = discriminant(a, b, c)
    if delta > 0:
        racine_double(a, b, delta, 1)
        racine_double(a, b, delta, 2)
    elif delta == 0:
        racine_unique(a, b)
    else:
        print("Pas de racine réelle")

# 6. Définition de la procédure equation(a, b, c)
def equation(a, b, c):
    str_equation(a, b, c)
    solution_equation(a, b, c)

# Fonction main pour entrée utilisateur
def main():
    testvaleur = True
    while testvaleur:
        A = input("Entrez A : \n")
        B = input("Entrez B : \n")
        C = input("Entrez C : \n")
        
        try:
            A = float(A)
            B = float(B)
            C = float(C)

            
            if A == 0:
                print("La valeur de A ne peut pas être égale à zéro. Veuillez réessayer.")
            else:
                testvaleur = False
                 
        except ValueError:
            print('Erreur !!! Veuillez entrer un chiffre')
    

    print("Appel de chaque fonction séparément :")
    #discriminant(A, B, C)
    #racine_unique(A, B)
    #delta = discriminant(A, B, C)
    #racine_double(A, B, delta, 1)
    #racine_double(A, B, delta, 2)
    #str_equation(A, B, C)
    #solution_equation(A, B, C)
    equation(A, B, C)

# Appel de la fonction main pour exécution
if __name__ == "__main__":
    main()

"""
# 7. Fonction de test avec des exemples
def test():
    equations = [(2, 3, 4), (1, 0, 4), (-1, 1, -4), (1, -6, 9)]
    for a, b, c in equations:
        equation(a, b, c)
        print()

# Appel de la fonction de test
test()

"""