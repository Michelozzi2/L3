filter' :: (a -> Bool) -> [a] -> [a] -- Si la liste est vide, retourne une liste vide
filter' _ [] = []  -- Si la liste est vide, retourne une liste vide
filter' f (list:liste)  -- Si la liste n'est pas vide, prend le premier élément et le reste de la liste]
    | f list = list : filter' f liste  -- Si 'f' retourne 'True' pour le premier élément, ajoute cet élément à la liste de sortie et continue avec le reste de la liste
    | otherwise = filter' f liste  -- Si 'f' retourne 'False' pour le premier élément, ignore cet élément et continue avec le reste de la liste

partage' :: [a] -> ([a], [a]) 
partage' [] = ([], [])  -- Si la liste est vide, retourne une paire de listes vides
partage' [x] = ([x], [])  -- Si la liste contient un seul élément, retourne une paire de listes contenant cet élément et une liste vide
partage' (x:y:liste) = (x:premier, y:deuxieme)  -- Si la liste contient au moins deux éléments, ajoute le premier élément à la première liste et le deuxième élément à la deuxième liste
    where (premier, deuxieme) = partage' liste  -- Continue avec le reste de la liste
        

partageEG' :: [a] -> ([a], [a])
partageEG' liste
    | null liste = ([], [])  -- Si la liste est vide, retourne une paire de listes vides
    | null (tail liste) = (liste, [])  -- Si la liste contient un seul élément, retourne une paire de listes contenant cet élément et une liste vide
    | otherwise = (head liste : premier, head (tail liste) : deuxieme)  -- Si la liste contient au moins deux éléments, ajoute le premier élément à la première liste et le deuxième élément à la deuxième liste
    where (premier, deuxieme) = partageEG' (tail (tail liste))  -- Continue avec le reste de la liste        

foldr' :: (a -> b -> b) -> b -> [a] -> b
foldr' f elmNeutre list -- Si la liste est vide, retourne l'élément neutre
    | null list = elmNeutre  -- Si la liste est vide, retourne l'élément neutre
    | otherwise = f (head list) (foldr' f elmNeutre (tail list))  -- Si la liste n'est pas vide, applique la fonction 'f' à la tête de la liste et le résultat de l'appel récursif avec le reste de la liste

concat' :: [[a]] -> [a]
concat' (liste:liste')
    | null liste' = liste
    | otherwise = foldr' (++) liste liste'  -- Utilise 'foldr' pour concaténer les listes

mLength' :: [a] -> Int
mLength' = foldr' (\x acc -> acc + 1) 0  -- Utilise 'foldr' pour compter le nombre d'éléments dans la liste