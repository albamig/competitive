module StringsEndsWith (solution) where

import Data.List

solution :: String -> String -> Bool
solution x y = any (==y) $ tails x
