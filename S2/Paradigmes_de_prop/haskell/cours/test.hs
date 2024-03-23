import Debug.Trace
import Text.XHtml (base, background)
import Control.Arrow (ArrowApply(app))
import Language.Haskell.TH (listE)
{-# ANN module ("HLint: ignore Use guards" :: String) #-}

factorial :: Integer -> Integer
factorial 0 = 1
factorial n
    | n < 0 = error "Le factoriel n'est pas défini pour les nombres négatifs."
    | otherwise = n * factorial (n - 1)

ackermann :: Integer -> Integer -> Integer
ackermann 0 n = n + 1
ackermann m 0 = ackermann (m-1) 1
ackermann m n
    | m < 0 || n < 0 = error "La fonction d'Ackermann n'est pas définie pour les nombres négatifs."
    | otherwise = ackermann (m-1) (ackermann m (n-1))

sommeRecursif :: Integer -> Integer --fonction somme qui prend un entier en entré et return un entier
sommeRecursif 0 = 0 --condition d'arrêt
sommeRecursif n  --declaration de la fct
    | n < 0 = error "La somme n'est pas définie pour les nombres négatifs."
    | otherwise = trace ("n = " ++ show n) n + sommeRecursif (n-1) -- trace est une fonction de débogage et permet d'afficher la valeur de n à chaque appel


--fonction recursive imperatif

factorialImp :: Integer -> Integer
factorialImp n = if n < 0 
              then error "Le factoriel n'est pas défini pour les nombres négatifs."
              else if n == 0 
                   then 1 
                   else n * factorialImp (n - 1)

ackermannImp :: Integer -> Integer -> Integer
ackermannImp m n = if m < 0 || n < 0 
                then error "La fonction d'Ackermann n'est pas définie pour les nombres négatifs."
                else if m == 0 
                     then n + 1 
                     else if n == 0 
                          then ackermannImp (m-1) 1 
                          else ackermannImp (m-1) (ackermannImp m (n-1))

sommeRecursifImp :: Integer -> Integer
sommeRecursifImp n = if n < 0 
                  then error "La somme n'est pas définie pour les nombres négatifs."
                  else if n == 0 
                       then 0 
                       else traceShow n n + sommeRecursifImp (n-1)


--Récursivité terminale
myfact :: Integer -> Integer
myfact = factAcc 1 

factAcc acc 0 = acc
factAcc acc n
    | n < 0 = error "Le factoriel n'est pas défini pour les nombres négatifs."
    | otherwise = factAcc (acc * n) (n - 1)

fact :: Integer -> Integer
fact n = factAux 1 n
    where --permet de definir une fonction locale
        factAux acc n
            | n == 0 = acc --Si n est égal à 0, alors factAux renvoie l'accumulateur acc, qui contient le résultat du calcul du factoriel.
            | n > 0 = factAux (acc * n) (n - 1)
            | otherwise = error "Le factoriel n'est pas défini pour les nombres négatifs."

factLet :: Integer -> Integer
factLet n = let
    factAux acc n
        | n == 0 = acc
        | n > 0 = factAux (acc * n) (n - 1)
        | otherwise = error "Le factoriel n'est pas défini pour les nombres négatifs."
    in factAux 1 n

sommeAcc :: Integer -> Integer
sommeAcc n = sommeAux 0 n
    where
        sommeAux acc n
            | n == 0 = acc
            | n > 0 = sommeAux (acc + n) (n - 1)
            | otherwise = error "La somme n'est pas définie pour les nombres négatifs."

multiplicationAcc :: Integer -> Integer -> Integer 
multiplicationAcc a n = multiplicationAux 0 a n
    where
        multiplicationAux acc a n
            | n == 0 = acc
            | n > 0 = multiplicationAux (acc + a) a (n - 1)
            | otherwise = error "La multiplication n'est pas définie pour les nombres négatifs."

puissanceAcc :: Integer -> Integer -> Integer
puissanceAcc a n = puissanceAux 1 a n
    where
        puissanceAux acc a n
            | n == 0 = acc
            | n > 0 = puissanceAux (acc * a) a (n - 1)
            | otherwise = error "La puissance n'est pas définie pour les nombres négatifs."

divisionEntiereAcc :: Integer -> Integer -> Integer
divisionEntiereAcc a n = divisionEntiereAux 0 a n
    where
        divisionEntiereAux acc a n
            | a < n= acc
            | n > 0 = divisionEntiereAux (acc + 1) (a - n) n
            | otherwise = error "La division entière n'est pas définie pour les nombres négatifs."
   
curry f x y = f (x, y)
curry ::((x, y) -> z) -> x -> y -> z
const x y = x
const:: a -> b -> a
apply f x = f x
apply::(a->b)->a->b
appl (f, x) = f x
appl::(a->b,a)->b
flip f x y = f y x
flip::(a->b->c)->b->a->c
subst f g x = f x (g x)
subst::(a->b->c)->(a->b)->a->c
map'::(a->b)->[a]->[b]

map' f liste
    | null liste = []
    | otherwise = f (head liste) : map' f (tail liste)
    


--(float,([char],[Int]))
--[[Int]]
--([char],[[Int]])

--equation gardée
tailleListeAcc :: [a] -> Int
tailleListeAcc l = tailleListeAux 0 l
    where
        tailleListeAux acc l
            | null l = acc
            | otherwise = tailleListeAux (acc + 1) (tail l)


length3 :: Num a1 => [a2] -> a1
length3 liste
    | null liste = 0
    | otherwise = 1 + length3 (tail liste)


length4 :: [a] -> Int
length4 liste = lengthAux 0 liste
    where
        lengthAux acc [] = acc
        lengthAux acc (x:xs) = lengthAux (acc + 1) xs

