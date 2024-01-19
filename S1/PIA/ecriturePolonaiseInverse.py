def liste_token(expression):
    def evalue_token(expr_as_list):
        token = expr_as_list.pop()
        if token in ["+", "-", "*", "/"]:
            gauche = evalue_token(expr_as_list)
            droite = evalue_token(expr_as_list)
            if token == "+":
                return gauche + droite
            elif token == "-":
                return gauche - droite
            elif token == "*":
                return gauche * droite
            elif token == "/":
                return gauche / droite
        else:
            return int(token)
        
    return evalue_token(expression.split())

print(liste_token("7 2 + 5 3 - *"))


            
            
        
    