square :: Num a => a -> a
square x = x * x

smaller :: (Integer, Integer) -> Integer
smaller (x, y) = if x < y then x else y

greater :: (Integer, Integer) -> Integer
greater (x, y) = if x > y then x else y

area :: Floating a => a -> a
area x = square x * pi

main :: IO ()

main = do
    print (square 5)
    print (smaller (3, 4))
    print (greater (3, 4))
    print (area 5)

