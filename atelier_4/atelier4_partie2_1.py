import time
import random
import matplotlib.pyplot as plt
import numpy as np



# La fonction mix_list modifiée

def mix_list(list_to_mix):
    new_list = list_to_mix.copy()
    n = len(new_list)

    for i in range(n - 1, 0, -1):
        j = random.randint(0, i)
        new_list[i], new_list[j] = new_list[j], new_list[i]

    return new_list

def mix_list2(list_to_mix: list) -> list:

    """

    Mélange les éléments d'une liste 'list_to_mix' de manière aléatoire et renvoie la nouvelle liste mélangée.

 
    :param list_to_mix: Liste à mélanger.
    :type list_to_mix: list
    :return: Liste mélangée.

    :rtype: list

    """

    list_indices = list(range(len(list_to_mix)))
    result = []
    longueur_list = len(list_indices)
    while list_indices:
        random_index = list_indices.pop(random.randint(0,  longueur_list - 1))
        result.append(list_to_mix[random_index])
        longueur_list -= 1
    # Utiliser les list_ mélangés pour construire la nouvelle liste
    return result






def choose_element_list(list_in_which_to_choose: list):
    """_summary_
    Cette fonction prend une liste en parametre et renvoi un element de la liste au hasard

    Args:
        list_in_which_to_choose (list): Une liste d'elements

    Returns:
        any: Un element de la liste
    """
    return list_in_which_to_choose[random.randint(0,len(list_in_which_to_choose)-1)]




def extract_elements_list(list_in_which_to_choose: list ,int_nbr_of_element_to_extract: list)->list:
    """_summary_

    Cette fonction prend une liste en parametre et retourne une liste en fonction de la taille d'un entier.

    Args:
        list_in_which_to_choose (list): Une liste d'elements
        int_nbr_of_element_to_extract (list): Un nombre entier

    Returns:
        list: Une liste d'elements de la taille de l'entier
    """
    return[choose_element_list(list_in_which_to_choose)for i in range(int_nbr_of_element_to_extract)]




"""
def perf_mix(func1: callable, func2: callable, list_sizes: list, num_executions: int)->tuple:
    _summary_

    Cette fonction effectue le test de performance entre 2 fonctions a partir d'une liste et d'un nombre d'executions permettant 
    un calcul precis de la moyenne.

    Args:
        func1 (callable): Fonction de test.
        func2 (callable): Fonction native.
        list_sizes (list): Une liste d entiers représentant les tailles de liste pour lesquelles on effectue la comparaison.
        num_executions (int): Un entier representant le nombre d execution

    Returns:
        tuple: liste de 2 float
    
    results_func1 = []
    results_func2 = []

    for size in list_sizes:
        list_to_mix = list(range(size))
        
        total_time_func1 = 0
        total_time_func2 = 0

        for _ in range(num_executions):
            start_time = time.perf_counter()
            func1(list_to_mix.copy())  # Make a copy to ensure fairness in comparison
            end_time = time.perf_counter()
            total_time_func1 += end_time - start_time

            start_time = time.perf_counter()
            func2(list_to_mix.copy())  # Make a copy to ensure fairness in comparison
            end_time = time.perf_counter()
            total_time_func2 += end_time - start_time

        avg_time_func1 = total_time_func1 / num_executions
        avg_time_func2 = total_time_func2 / num_executions

        results_func1.append(avg_time_func1)
        results_func2.append(avg_time_func2)

    return (results_func1, results_func2)

"""
def perf_mix2(func1: callable, func2: callable, list_sizes: list, num_executions: int)->tuple:
    """_summary_

    Cette fonction effectue le test de performance entre 2 fonctions a partir d'une liste et d'un nombre d'executions permettant 
    un calcul precis de la moyenne.

    Args:
        func1 (callable): Fonction de test.
        func2 (callable): Fonction native.
        list_sizes (list): Une liste d entiers représentant les tailles de liste pour lesquelles on effectue la comparaison.
        num_executions (int): Un entier representant le nombre d execution

    Returns:
        tuple: liste de 2 float
    """
    results_func1 = []
    results_func2 = []

    for size in list_sizes:
        list_to_mix = list(range(size))
        
        total_time_func1 = 0
        total_time_func2 = 0

        for _ in range(num_executions):
            start_time = time.perf_counter()
            func1(list_to_mix.copy())  # Make a copy to ensure fairness in comparison
            end_time = time.perf_counter()
            total_time_func1 += end_time - start_time

            start_time = time.perf_counter()
            func2(list_to_mix.copy())  # Make a copy to ensure fairness in comparison
            end_time = time.perf_counter()
            total_time_func2 += end_time - start_time

        avg_time_func1 = total_time_func1 / num_executions
        avg_time_func2 = total_time_func2 / num_executions

        results_func1.append(avg_time_func1)
        results_func2.append(avg_time_func2)

    return (results_func1, results_func2)

def main():
    #Test 1
    """
    list_sizes = [10, 500, 5000, 50000, 100000]
    num_executions = 100

    #results = perf_mix(mix_list, random.shuffle, list_sizes, num_executions)

    x_axis_list = np.array(list_sizes)
    plt.plot(x_axis_list, results[0], label='mix_list')
    plt.plot(x_axis_list, results[1], label='random.shuffle')
    plt.xlabel('List Size')
    plt.ylabel('Average Execution Time (seconds)')
    plt.title('Comparison of mix_list and random.shuffle')
    plt.legend()
    plt.show()
    """

    #Test 2
    """
    list_sizes = [10, 500, 5000, 50000, 100000]
    num_executions = 100

    results = perf_mix2(extract_elements_list, random.sample, list_sizes, num_executions)

    x_axis_list = np.array(list_sizes)
    plt.plot(x_axis_list, results[0], label='mix_list')
    plt.plot(x_axis_list, results[1], label='random.shuffle')
    plt.xlabel('List Size')
    plt.ylabel('Average Execution Time (seconds)')
    plt.title('Comparison of mix_list and random.shuffle')
    plt.legend()
    plt.show()
    """



main()