monConcatAMoiLC :: [[a]] -> [a]
monConcatAMoiLC lst = [e | slst <- lst , e <- slst]


listeDiviseurs :: Int -> [Int]
listeDiviseurs lst = [e | e <- [1..lst], lst `mod` e == 0 ]

estPremier :: Int -> Bool
estPremier premier = listeDiviseurs premier == [1,premier]

tripletsPythagoriciens :: Int -> [(Int, Int, Int)]
tripletsPythagoriciens res = [(a,b,c) | a <- [1..res], b <- [1..res], c <- [1..res], a^2 + b^2 == c^2, a < b, b < c]


lesParfaits :: Int -> [Int]
lesParfaits e = [res | res <- [1..e], sum (listeDiviseurs res) - res == res]

--TD

monLast :: [Int] -> Int
monLast [] = error "Liste vide"
monLast (x : xs)
    | not (null xs) = monLast xs
    | otherwise = x

appartient :: Int -> [Int] -> Bool
appartient _ [] = False
appartient e (x : xs)
    | e == x = True
    | otherwise = appartient e xs

longueur [Int] -> Int
longueur [] = 0
longueur 
    



