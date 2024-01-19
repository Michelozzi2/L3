def create_encoded_data(num1, num2, num3, bool1, bool2):
    """
    La fonction crée des données codées en combinant trois nombres et deux booléens à l'aide
    d'opérations au niveau du bit.
    
    :param num1: Le premier nombre à encoder. Il doit s'agir d'un entier compris entre 0 et 500
    :param num2: Le paramètre « num2 » représente un nombre qui doit être codé dans la plage de 0 à 500
    :param num3: Le paramètre "num3" représente un nombre qui doit être codé dans la plage de 0 à 500
    :param bool1: Une valeur booléenne indiquant si une certaine condition est vraie ou fausse
    :param bool2: bool2 est une valeur booléenne qui représente un chiffre binaire. Cela peut être Vrai
    ou Faux
    :return: les données codées, qui sont une valeur entière.
    """
    # Assurez-vous que les nombres sont dans la plage appropriée
    num1 = min(max(num1, 0), 500)
    num2 = min(max(num2, 0), 500)
    num3 = min(max(num3, 0), 500)
    
    # Créez l'entier en utilisant des opérations de décalage et de masquage
    encoded_data = (num1 << 23) | (num2 << 14) | (num3 << 5)
    encoded_data |= (bool1 << 4)
    encoded_data |= (bool2 << 3)
    
    return encoded_data

# Lire les informations
def read_encoded_data(encoded_data):
    """
    La fonction `read_encoded_data` prend une donnée codée en entrée et en extrait trois nombres et deux
    valeurs booléennes.
    
    :param encoded_data: Le paramètre « encoded_data » est une valeur entière qui représente les données
    codées
    :return: les valeurs de num1, num2, num3, bool1 et bool2.
    """
    num1 = (encoded_data >> 23) & 0x1FF  # 0x1FF correspond à 9 bits de 1
    num2 = (encoded_data >> 14) & 0x1FF
    num3 = (encoded_data >> 5 ) & 0x1FF
    bool1 = (encoded_data >> 4) & 0x01
    bool2 = (encoded_data >> 3) & 0x01
    
    return num1, num2, num3, bool1, bool2

# Exemple d'utilisation
num1 = 241
num2 = 13
num3 = 411
bool1 = 1
bool2 = 0

encoded_data = create_encoded_data(num1, num2, num3, bool1, bool2)
print("Encoded Data:", bin(encoded_data))
decoded_data = read_encoded_data(encoded_data)
print("Decoded Data:", decoded_data)