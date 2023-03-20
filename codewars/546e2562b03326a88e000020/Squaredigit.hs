module SquareDigit where
import Data.Char

squareDigit :: Int -> Int
squareDigit d
  | d < 0 = negate $ squareDigit $ negate d
  | otherwise = read $ foldl1 (++) $ map show $ map (^2) $ map digitToInt $ show d
