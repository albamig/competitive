module Lib (createPhoneNumber) where

createPhoneNumber :: [Int] -> String
createPhoneNumber xs =
  "(" ++ take 3 pNum ++ ") "
    ++ take 3 (drop 3 pNum)
    ++ "-"
    ++ take 4 (drop 6 pNum)
  where
    pNum = concatMap show xs
