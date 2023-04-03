module Spinning where

spinWords :: String -> String
spinWords = unwords . spin . words

spin :: [String] -> [String]
spin = map cond_spin
    where cond_spin str
            | length str >= 5 = reverse str
            | otherwise = str
