package problems

import utils.Utils.time

// https://projecteuler.net/problem=32
// Sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital
object Problem032 extends App {
  def isPandigital(n: Long): Boolean = {
    val asList = n.toString.split("").map(_.toInt).toList
    val max = asList.max
    asList.sorted == (1 to max).toList
  }

  lazy val solution: Int = {
    (for (
      a <- 2 to 10000;
      b <- 2 to 10000 / a;
      n = (a * b).toString + a.toString + b.toString
      if n.length == 9 && isPandigital(n.toLong)
    ) yield a * b).distinct.sum
  }

  println(time(solution))
}
