import time
import matplotlib.pyplot as plt
import numpy as np



"""
def sort_list(lst2):
    if len(lst2) == 1:
        return lst2
    else:
        return fusion( sort_list(lst2[:len(lst2)//2]) , sort_list(lst2[len(lst2)//2:]) )
    
def fusion(lst1,lst2):
    if len(lst1) == 0:
        return lst2
    elif len(lst2) == 0:
        return lst1
    elif lst1[0] <= lst2[0]:
        return [lst1[0]] + fusion( lst1[1:] , lst2 )
    else:
        return [lst2[0]] + fusion( lst1 , lst2[1:] )
"""

def sort_list(liste: list)->list:
    lst2 = liste.copy()
    while liste:
        mini=liste[0]
        for i in liste:
            if i < mini:
                mini=i
        liste.remove(mini)
        lst2.append(mini)
    return lst2

def perf_mix(func1: callable, func2: callable, list_sizes: list, num_executions: int)->tuple:
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

def Test():
    #list_test = [41,17,3,4,17,51,4,-1,65]
    #print(sort_list(list_test))

    list_sizes = [10, 500, 5000, 50000, 100000]
    num_executions = 10

    results = perf_mix(sort_list,sorted, list_sizes, num_executions)

    x_axis_list = np.array(list_sizes)
    plt.plot(x_axis_list, results[0], label='mix_list')
    plt.plot(x_axis_list, results[1], label='random.shuffle')
    plt.xlabel('List Size')
    plt.ylabel('Average Execution Time (seconds)')
    plt.title('Comparison of mix_list and random.shuffle')
    plt.legend()
    plt.show()

Test()

