module Scramblies where

import Data.List

scramble :: String -> String -> Bool
scramble _ [] = True
scramble s1 (s2_h:s2_t) 
    | s2_h `elem` s1 = scramble (delete s2_h s1) s2_t 
    | otherwise = False
