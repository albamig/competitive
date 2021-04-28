object $1829__MaximumXorForEachQuery extends App {
  def getMaximumXor(nums: Array[Int], maximumBit: Int): Array[Int] = {
    val xorAcc: Array[Int] = nums.scanLeft(0)(_ ^ _).tail.reverse
    val maxNum: Int = math.pow(2, maximumBit).toInt - 1

    xorAcc.map(_ ^ maxNum)
  }
}
