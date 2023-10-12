# Stocker les informations
def create_encoded_data(num1, num2, num3, bool1, bool2):
    # Assurez-vous que les nombres et les booléens sont dans la plage appropriée
    num1 = min(max(num1, 0), 500)
    num2 = min(max(num2, 0), 500)
    num3 = min(max(num3, 0), 500)
    
    # Créez l'entier en utilisant des opérations de décalage et de masquage
    encoded_data = (num1 << 20) | (num2 << 10) | num3
    encoded_data |= (bool1 << 1)
    encoded_data |= bool2
    
    return encoded_data

# Lire les informations
def read_encoded_data(encoded_data):
    num1 = (encoded_data >> 20) & 0x3FF  # 0x3FF correspond à 10 bits de 1
    num2 = (encoded_data >> 10) & 0x3FF
    num3 = encoded_data & 0x3FF
    bool1 = (encoded_data >> 1) & 0x01
    bool2 = encoded_data & 0x01
    
    return num1, num2, num3, bool1, bool2

# Exemple d'utilisation
num1 = 300
num2 = 150
num3 = 450
bool1 = 1
bool2 = 0

encoded_data = create_encoded_data(num1, num2, num3, bool1, bool2)
print("Encoded Data:", bin(encoded_data))
decoded_data = read_encoded_data(encoded_data)
print("Decoded Data:", decoded_data)