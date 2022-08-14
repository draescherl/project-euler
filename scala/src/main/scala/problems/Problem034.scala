package problems

import utils.Utils.{factorial, time}

// https://projecteuler.net/problem=34
// Sum of numbers equal to the sum of the factorial of their digits
object Problem034 extends App {
  // Pre-compute factorials for performance reasons.
  lazy val factorials: Array[Int] =
    (for (i <- 0 until 10) yield factorial(i).toInt).toArray

  def isCuriousNumber(x: Int): Boolean =
    x.toString.split("").map(_.toInt).map(factorials(_)).sum == x

  // See https://www.xarg.org/puzzle/project-euler/problem-34/ for
  // calculations about the upper bound.
  lazy val curiousNumbers: Int =
    (3 to 1499999).filter(isCuriousNumber).toList.sum

  println(time(curiousNumbers))
}
