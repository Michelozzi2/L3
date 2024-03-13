minDe3 :: Ord a => a -> a -> a -> a
minDe3 x y z = min x (min y z)

main :: IO ()
main = print (minDe3 5 3 7)


