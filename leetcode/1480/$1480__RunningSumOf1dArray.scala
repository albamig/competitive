object $1480__RunningSumOf1dArray extends App {
  def runningSum(nums: Array[Int]): Array[Int] = nums.scanLeft(0){_ + _}.tail

  println(runningSum(Array(1, 2, 3, 4)).mkString("Array(", ", ", ")"))
}

object $1480__RunningSumOf1dArray_Loop extends App {
  def runningSum(nums: Array[Int]): Array[Int] = {
    var i, sum = 0
    val res = new Array[Int](nums.length)

    while (i < nums.length) {
      sum += nums(i)
      res(i) = sum
      i += 1
    }

    res
  }

  println(runningSum(Array(1, 2, 3, 4)).mkString("Array(", ", ", ")"))
}

object $1480__RunningSumOf1dArray_WrongSol extends App {
  def runningSum(nums: Array[Int]): Array[Int] = {
    for ((_, i) <- nums.zipWithIndex)
      yield nums.take(i+1).sum
  }

  println(runningSum(Array(1, 2, 3, 4)).mkString("Array(", ", ", ")"))
}


