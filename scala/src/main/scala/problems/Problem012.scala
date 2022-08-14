package problems

import utils.Utils.time

// https://projecteuler.net/problem=12
// First triangular number to have over 500 divisors
object Problem012 extends App {
  // for(i <- 1 to 28 if 28 % i == 0) yield i
  def firstTriangularNumber(numOfDivisors: Int): Int = {
    lazy val triangleNumber: LazyList[Int] =
      0 #:: triangleNumber.zipWithIndex.map(num => num._1 + num._2 + 1)

    def getNumberOfDivisors(x: Int): Int =
      (1 to math.sqrt(x).toInt)
        .foldLeft(0)((result, divisor) => if (x % divisor == 0) result + 2 else result)

    triangleNumber.find(getNumberOfDivisors(_) > numOfDivisors).get
  }

  println(time(firstTriangularNumber(500)))
}
