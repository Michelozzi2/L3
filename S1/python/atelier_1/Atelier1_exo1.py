# Le dictionnaire `IMC_interpretation` est utilisé pour stocker l'interprétation des différentes
# plages de l'indice de masse corporelle (IMC). Les clés du dictionnaire représentent les limites
# supérieures de chaque plage et les valeurs représentent l'interprétation associée à cette plage. Par
# exemple, un IMC de 16,5 ou moins est interprété comme « dénutrition ou famine », un IMC entre 16,5
# et 18,5 est interprété comme « maigreur », et ainsi de suite.
IMC_interpretation = {
    16.5: "denutrition ou famine",
    18.5: "maigreur",
    25: "corpulence normale",
    30: "surpoids",
    35: "obésité modérée",
    40: "obésité sévere",
    45: "obésité morbide",

}

"""
def test():
    for i in IMC_interpretation :
        interprétation_test = i
        message_imc(interprétation_test)
        interprétation_test = message_imc(interprétation_test)
        print("Interpretation de l IMC : \n", interprétation_test )

"""

def message_imc(IMC):

    """
        Cette fonction parcours le dictionnaire
        et retourne l'interprétation associée a l'IMC
        en fonction de la clée et de interprétation
    """
    
    interpretation = IMC_interpretation
    for IMC_limite, interpretation in sorted(interpretation.items()):
        if IMC <= IMC_limite:
            return interpretation
        
    return "IMC trop élevé"


def main():
    """Demande a l'utilisateur d'entrer l'IMC"""
    IMC = float(input('Entrez l indice de masse corporelle : \n'))

    """Affichage de l'interprétation"""
    interprétation_final = message_imc(IMC)
    print("Interpretation de l IMC : \n", interprétation_final )

main()

#test()