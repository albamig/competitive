object $1476__SubrectangleQueries extends App {
  class SubrectangleQueries(_rectangle: Array[Array[Int]]) {

    def updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
      for (i <- row1 to row2;
           j <- col1 to col2)
        _rectangle(i)(j) = newValue
    }

    def getValue(row: Int, col: Int): Int = {
      _rectangle(row)(col)
    }
  }

  val rectangle = Array(Array(1, 2, 1), Array(4, 3, 4), Array(3, 2, 1), Array(1, 1, 1))
  var obj = new SubrectangleQueries(rectangle)
  println(obj.getValue(0, 2))
  obj.updateSubrectangle(0,0,3,2,5)
  println(obj.getValue(0, 2))
  println(obj.getValue(3, 1))
  obj.updateSubrectangle(3, 0, 3, 2, 10)
  println(obj.getValue(3, 1))
  println(obj.getValue(0, 2))
}
