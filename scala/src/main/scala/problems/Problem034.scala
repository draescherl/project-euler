package problems

import utils.Utils.{factorial, time}

/* -----------------------------------------------------------------------
  Problem 29 : 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

  Find the sum of all numbers which are equal to the sum of the factorial
  of their digits.

  Note: As 1! = 1 and 2! = 2 are not sums they are not included.
 ----------------------------------------------------------------------- */
object Problem034 {
  // Pre-compute factorials for performance reasons.
  lazy val factorials: Array[Int] =
    (for (i <- 0 until 10) yield factorial(i).toInt).toArray

  def isCuriousNumber(x: Int): Boolean =
    x.toString.split("").map(_.toInt).map(factorials(_)).sum == x

  // See https://www.xarg.org/puzzle/project-euler/problem-34/ for
  // calculations about the upper bound.
  lazy val curiousNumbers: Int =
    (3 to 1499999).filter(isCuriousNumber).toList.sum

  def main(args: Array[String]): Unit =
    println(time(curiousNumbers))
}
