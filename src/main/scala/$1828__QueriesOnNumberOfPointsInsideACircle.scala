import math.{sqrt, pow}

object $1828__QueriesOnNumberOfPointsInsideACircle extends App {

  def distance(xp: Int, yp: Int, xc: Int, yc: Int) = {
    val partialX = (xp - xc) * (xp - xc)
    val partialY = (yp - yc) * (yp - yc)
    sqrt(partialX + partialY)
  }

  def isWithinCircle(xp: Int, yp: Int, xc: Int, yc: Int, rc: Int) = if (distance(xp, yp, xc, yc) <= rc) 1 else 0

  def countPoints(points: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
    queries.map {
      case Array(xc, yc, rc) => points.map {
        case Array(xp, yp) => isWithinCircle(xp, yp, xc, yc, rc)
      }
    }.map(_.sum)
  }

  val points = Array(Array(1, 3), Array(3, 3), Array(5, 3), Array(2, 2))
  val queries = Array(Array(2, 3, 1), Array(4, 3, 1), Array(1, 1, 2))
  println(countPoints(points, queries).mkString("Array(", ", ", ")"))
}

object $1828__QueriesOnNumberOfPointsInsideACircle_ObjectOriented extends App {
  class Point(val x: Int, val y: Int) {
    def distance(that: Point): Double = {
      val partialX = pow(that.x - this.x, 2)
      val partialY = pow(that.y - this.y, 2)
      sqrt(partialX + partialY)
    }
  }

  class Circle(val center: Point, val radius: Int) {
    def contains(point: Point): Boolean = {
      if (point.distance(center) <= radius) true
      else false
    }
  }

  def countPoints(points: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
    val ps: Array[Point] = points map { case Array(x, y) => new Point(x, y) }
    val qs: Array[Circle] = queries map { case Array(x, y, r) => new Circle(new Point(x, y), r) }

    qs map { circle =>
      ps map { point =>
        circle.contains(point)
      } count {
        _ == true
      }
    }
  }

  val points: Array[Array[Int]] = Array(Array(1, 3), Array(3, 3), Array(5, 3), Array(2, 2))
  val queries = Array(Array(2, 3, 1), Array(4, 3, 1), Array(1, 1, 2))
  println(countPoints(points, queries).mkString("Array(", ", ", ")"))
}