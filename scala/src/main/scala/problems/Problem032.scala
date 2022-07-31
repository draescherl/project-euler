package problems

import utils.Utils.time

/* -----------------------------------------------------------------------
  Problem 32 : We shall say that an n-digit number is pandigital if it
  makes use of all the digits 1 to n exactly once; for example, the 5-digit
  number, 15234, is 1 through 5 pandigital.

  The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing
  multiplicand, multiplier, and product is 1 through 9 pandigital.

  Find the sum of all products whose multiplicand/multiplier/product
  identity can be written as a 1 through 9 pandigital.

  HINT: Some products can be obtained in more than one way so be sure to
  only include it once in your sum.
 ----------------------------------------------------------------------- */
object Problem032 {
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

  def main(args: Array[String]): Unit =
    println(time(solution))
}
