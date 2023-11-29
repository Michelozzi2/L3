
def liste_token(expression):
    def evalue_token(expr_as_list):
        token = expr_as_list.pop()
        if token in ["or", "and", "not"]:
            if token == "not":
                operand = evalue_token(expr_as_list)
                return not operand
            else:
                droite = evalue_token(expr_as_list)
                gauche = evalue_token(expr_as_list)
                if token == "or":
                    return gauche or droite
                elif token == "and":
                    return gauche and droite
        else:
            return token.lower() == "true"
        
    return evalue_token(expression.split())

print(liste_token("false not false or true false or and"))  
