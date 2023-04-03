module Spinning where

import qualified Data.Text as T
import qualified Data.List as L

spinWords :: String -> String
spinWords = L.intercalate " " . spin' . split'

split' :: String -> [String]
split' str = map T.unpack (T.splitOn (T.pack " ") (T.pack str))

spin' :: [String] -> [String]
spin' = map cond_spin
    where cond_spin str = if L.length  str >= 5 then L.reverse str else str
