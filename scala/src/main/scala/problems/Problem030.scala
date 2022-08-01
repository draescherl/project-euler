package problems

import utils.Utils.time

/* -----------------------------------------------------------------------
  Problem 30 : Surprisingly there are only three numbers that can be
  written as the sum of fourth powers of their digits:

    1634 = 1^4 + 6^4 + 3^4 + 4^4
    8208 = 8^4 + 2^4 + 0^4 + 8^4
    9474 = 9^4 + 4^4 + 7^4 + 4^4

  As 1 = 14 is not a sum it is not included.
  The sum of these numbers is 1634 + 8208 + 9474 = 19316.

  Find the sum of all the numbers that can be written as the sum of fifth
  powers of their digits.
 ----------------------------------------------------------------------- */
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
