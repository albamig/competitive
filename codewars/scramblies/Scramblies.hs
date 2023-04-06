module Scramblies where

import Data.List

scramble :: String -> String -> Bool
scramble s1 s2 = isSubsequenceOf (sort s2) (sort s1)

scrambleSlow :: String -> String -> Bool
scrambleSlow _ [] = True
scrambleSlow s1 (s2_h:s2_t) 
    | s2_h `elem` s1 = scramble (delete s2_h s1) s2_t 
    | otherwise = False
