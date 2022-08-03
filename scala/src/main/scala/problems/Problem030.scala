package problems

import utils.Utils.time

// https://projecteuler.net/problem=30
// Sum of all numbers that can be written as the sum of fifth powers of their digits
object Problem030 {
  def sumFifthPowers(n: Int): Double =
    n.toString.split("").map(_.toInt).map(math.pow(_, 5)).sum

  // See https://www.mathblog.dk/project-euler-30-sum-numbers-that-can-be-written-as-the-sum-fifth-powers-digits/
  // for details about upper bound
  lazy val solution: Int =
    (for (i <- 2 to 355000 if sumFifthPowers(i) == i.toDouble) yield i).sum

  def main(args: Array[String]): Unit =
    println(time(solution))
}
