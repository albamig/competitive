module StringToCamelCase where

import Data.Char

toCamelCase :: String -> String
toCamelCase [] = []
toCamelCase (x:xs)
    | x == '_' = capitalize xs
    | x == '-' = capitalize xs
    | otherwise = x : toCamelCase xs
        where capitalize word = (toUpper $ head word) : (toCamelCase $ tail word)
