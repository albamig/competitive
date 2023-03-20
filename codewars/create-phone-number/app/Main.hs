module Main (main) where

import Lib

main :: IO ()
main = putStrLn $ createPhoneNumber [1,2,3]
