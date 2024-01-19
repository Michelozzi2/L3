import pandas as pd
import numpy as np
import re
import googlemaps
import heapq
import networkx as nx

# Charger toutes les feuilles du fichier Excel
all_sheets = pd.read_excel("Taux_Remplissage_ComCom_Nebbiu.xlsx", header=[0,1], sheet_name=None)

# Parcourir toutes les feuilles
for sheet_name, data in all_sheets.items():
    # Obtenir les noms des colonnes
    cols = data.columns.tolist()

    # Parcourir les colonnes par pas de 3 (Poubelle, Unnamed, Unnamed)
    for i in range(0, len(cols), 3):
        # Concaténer les noms des colonnes
        cols[i] = cols[i][0] + '_' + cols[i][1]
        if i+1 < len(cols):
            cols[i+1] = cols[i+1][0] + '_' + cols[i+1][1]
        if i+2 < len(cols):
            cols[i+2] = cols[i+2][0] + '_' + cols[i+2][1]

    # Renommer les colonnes
    data.columns = cols

    # Afficher les premières lignes
    print(f"Sheet: {sheet_name}")
    print(data.head())
    print("\n---\n")
   
  


import googlemaps
import networkx as nx

def create_distance_graph(api_key, coordinates):
    gmaps = googlemaps.Client(key=api_key)
    starting_point = coordinates[0]
    
    dist_matrix = gmaps.distance_matrix(
        [starting_point] + coordinates + [starting_point],
        [starting_point] + coordinates + [starting_point],
        mode="driving",
        units="metric",
    )
    
    distance_matrix = [
        [element["distance"]["value"] for element in row["elements"]]
        for row in dist_matrix["rows"]
    ]

    graph = nx.Graph()
    num_nodes = len(coordinates) + 1  # +1 for the starting point
    for i in range(num_nodes):
        for j in range(num_nodes):
            graph.add_edge(i, j, weight=distance_matrix[i][j])

    return graph

def dijkstra(graph, start, end):
    path = nx.shortest_path(graph, source=start, target=end, weight='weight')
    total_distance = nx.shortest_path_length(graph, source=start, target=end, weight='weight')
    return path, total_distance

def get_coordinates_from_path(graph, path):
    coordinates_path = [graph.nodes[node]['coord'] for node in path]
    return coordinates_path

# Exemple d'utilisation
api_key = "AIzaSyC-B_BPW3aSceylR0FbfXZirsMdLPf_JOI"
coordinates = [
    (42.61083333333333, 9.35388888888889),
    (42.61222222222222, 9.356666666666666),
    (42.61416666666667, 9.354722222222222),
    (42.61527777777778, 9.351388888888888),
    (42.61694444444444, 9.355555555555556),
    (42.608333333333334, 9.358055555555556),
    (42.60194444444445, 9.359722222222222),
]

# Ajouter les coordonnées aux nœuds du graphe
graph = create_distance_graph(api_key, coordinates)
for i, coord in enumerate(coordinates):
    graph.nodes[i]['coord'] = coord

print("Distance Graph:")
print(graph)

# Point de départ (le dépôt de poubelle)
starting_point = 0
# Point d'arrivée (point le plus éloigné)
farthest_point = max(graph.nodes, key=lambda x: nx.shortest_path_length(graph, source=starting_point, target=x, weight='weight'))

shortest_path, total_distance = dijkstra(graph, starting_point, farthest_point)

print(f"Le plus court chemin entre le dépôt et le point le plus éloigné est : {shortest_path}")
print(f"Distance totale : {total_distance} mètres")

# Coordonnées du chemin le plus court
coordinates_shortest_path = get_coordinates_from_path(graph, shortest_path)
print("Coordonnées du chemin le plus court:")
print(coordinates_shortest_path)

"""
from datetime import datetime

from pandas import Timestamp
from datetime import timedelta

def calculate_average_percentage_increase(village, bin_name, date_str, all_sheets):
    # Convert the date to datetime
    date = datetime.strptime(date_str, '%Y-%m-%d %H:%M:%S')
    # Convert datetime to Timestamp
    date = Timestamp(date)
    # Check if the village is in the dictionary
    if village in all_sheets:
        # Get the data for the village
        data = all_sheets[village]
        
        # Check if the bin is in the data columns
        if bin_name in data.columns:
            # Check if the date is in the data index
            if date in data['Unnamed: 1_level_0_date'].values:
                # Get the fill of the bin for this date
                
                fill = data[data['Unnamed: 1_level_0_date'] == date][bin_name].values[0]
                current_CoeffTouriste = data[data['Unnamed: 1_level_0_date'] == date].filter(regex='^poubelle \\d{1,2}_coeff')            
                # Vérifier si le remplissage est de 75% ou plus
                for col in current_CoeffTouriste
                if fill >= 75:
                    return True
                else:
                    if int(current_CoeffTouriste) == 1:
                        # Calculate the percentage increase for each day until the current date
                        percentage_increases = []
                        min_fill = fill  # Initialize min_fill with the current fill value
                        for i in range(1, 6):
                            previous_date = date - timedelta(days=i)
                            if previous_date in data['Unnamed: 1_level_0_date'].values:
                                previous_fill = data[data['Unnamed: 1_level_0_date'] == previous_date][bin_name].values[0]
                                if previous_fill == 0:
                                    percentage_increase = (fill - previous_fill) / previous_fill * 100
                                    percentage_increases.append(percentage_increase)
                                else:
                                    # Update min_fill if the previous_fill is less than the current min_fill
                                    min_fill = min(min_fill, previous_fill)
                        # Calculate the percentage increases from the minimum fill value
                        if min_fill != 0:
                            for i in range(1, 6):
                                previous_date = date - timedelta(days=i)
                                if previous_date in data['Unnamed: 1_level_0_date'].values:
                                    previous_fill = data[data['Unnamed: 1_level_0_date'] == previous_date][bin_name].values[0]
                                    percentage_increase = (previous_fill - min_fill) / min_fill * 100
                                    percentage_increases.append(percentage_increase)
                        # Calculate the average percentage increase
                        if percentage_increases:
                            average_percentage_increase = sum(percentage_increases) / len(percentage_increases)
                            return average_percentage_increase 

    
                        if average_percentage_increase >= 20 and fill < 50:
                            return True
                    elif current_CoeffTouriste == 2.0: 
                        # Calculate the percentage increase for each day until the current date
                        percentage_increases = []
                        min_fill = fill
                        for i in range(1, 3):
                            previous_date = date - timedelta(days=i)
                            if previous_date in data['Unnamed: 1_level_0_date'].values:
                                previous_fill = data[data['Unnamed: 1_level_0_date'] == previous_date][bin_name].values[0]
                                if previous_fill == 0:
                                    percentage_increase = (fill - previous_fill) / previous_fill * 100
                                    percentage_increases.append(percentage_increase)
                                else:
                                    # Update min_fill if the previous_fill is less than the current min_fill
                                    min_fill = min(min_fill, previous_fill)

                        if min_fill != 0:
                            for i in range(1, 3):
                                previous_date = date - timedelta(days=i)
                                if previous_date in data['Unnamed: 1_level_0_date'].values:
                                    previous_fill = data[data['Unnamed: 1_level_0_date'] == previous_date][bin_name].values[0]
                                    percentage_increase = (previous_fill - min_fill) / min_fill * 100
                                    percentage_increases.append(percentage_increase)

                        # Calculate the average percentage increase
                        if percentage_increases:
                            average_percentage_increase = sum(percentage_increases) / len(percentage_increases)
                            return average_percentage_increase
                        

                        if average_percentage_increase >= 30 and fill < 50:
                            return True
                    elif current_CoeffTouriste == 3.0:
                        return True
            else:
                print(f"No data found for date {date} in village {village}")
        else:
            print(f"No data found for bin {bin_name} in village {village}")
    else:
        print(f"No data found for village {village}")

res = calculate_average_percentage_increase('oletta', 'poubelle 1_remplissage', '2023-01-07 00:00:00', all_sheets)
                
                
print(data.columns)
                    
           
"""
"""
def check_bin_fill(village, bin_name, date_str, all_sheets):
    # Convertir la date en datetime
    date = datetime.strptime(date_str, '%Y-%m-%d %H:%M:%S')
    # Convertir datetime en Timestamp
    date = Timestamp(date)
    # Vérifier si le village est dans le dictionnaire
    if village in all_sheets:
        # Obtenir les données du village
        data = all_sheets[village]
        
        # Vérifier si la poubelle est dans les colonnes des données
        if bin_name in data.columns:
            # Vérifier si la date est dans l'index des données
            if date in data['Unnamed: 1_level_0_date'].values:
                # Obtenir le remplissage de la poubelle pour cette date
                fill = data[data['Unnamed: 1_level_0_date'] == date][bin_name].values[0]
                
                # Vérifier si le remplissage est de 75% ou plus
                if fill >= 75:
                    return True
                else:
                    return False
            else:
                print(f"No data found for date {date} in village {village}")
        else:
            print(f"No information found for bin {bin_name} in village {village}")
    else:
        print(f"No information found for village {village}")

# Utilisation de la fonction
res = check_bin_fill('oletta', 'poubelle 1_remplissage', '2023-01-09 00:00:00', all_sheets)

# Afficher les dates uniques
#print(all_sheets['oletta']['Unnamed: 1_level_0_date'].unique())
""" 

"""

# Charger toutes les feuilles du fichier Excel
all_sheets = pd.read_excel("Taux_Remplissage_ComCom_Nebbiu.xlsx", header=[0, 1], sheet_name=None)

# Dictionnaire pour stocker les DataFrames modifiés
villages_data = {}

# Parcourir toutes les feuilles
for sheet_name, data in all_sheets.items():
    # Obtenir le nom du village
    village_name = sheet_name.split("_")[0]  # Assurez-vous que le nom du village est correctement extrait

    # Calculer le pourcentage moyen pour chaque jour de la semaine
    days_of_week = ['Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi', 'Dimanche']
    mean_percentages = []

    for day in days_of_week:
        day_columns = [col for col in data.columns if day in col]
        day_data = data[day_columns]
        mean_percentage = day_data.mean().mean()  # Calculer la moyenne sur toutes les données du jour
        mean_percentages.append(mean_percentage)

    # Créer le DataFrame final
    final_data = pd.DataFrame({'Jour': days_of_week, 'PourcentageMoyen': mean_percentages})

    # Stocker le DataFrame dans le dictionnaire avec le nom du village comme clé
    villages_data[village_name] = final_data

# Afficher le dictionnaire
for village, data in villages_data.items():
    print(f"Village: {village}")
    print(data)
    print("\n---\n")
"""