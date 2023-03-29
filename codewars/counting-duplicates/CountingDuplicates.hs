module CountingDuplicates where

import qualified Data.Map as M

duplicateCount :: String -> Int
duplicateCount str = foldl (+) 0 $ countElems str
    where countElems = M.fromListWith (+) . flip zip (repeat 1) 
