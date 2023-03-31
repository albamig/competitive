module CountingDuplicates where

import qualified Data.Map as M
import Data.Char

duplicateCount :: String -> Int
duplicateCount = M.size . M.filter (>1) . countElems
    where countElems = M.fromListWith (+) . flip zip (repeat 1) . map toUpper
