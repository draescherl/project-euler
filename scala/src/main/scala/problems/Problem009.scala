package problems

import utils.Utils.time

/* -----------------------------------------------------------------------
  Problem 9 : A Pythagorean triplet is a set of three natural numbers,
  a < b < c, for which, a² + b² = c²
  For example, 32 + 42 = 9 + 16 = 25 = 52.

  There exists exactly one Pythagorean triplet for which a + b + c = 1000.
  Find the product abc.
 ----------------------------------------------------------------------- */
object Problem009 {
  val uniqueProduct: Long = {
    val limit = (1 to 1000).find(n => n + math.sqrt(n) >= 1000).get
    val products = for (
      a <- 1 until limit;
      b <- a until limit;
      c = 1000 - a - b if a * a + b * b == c * c
    ) yield a * b * c
    products.head
  }

  def main(args: Array[String]): Unit =
    println(time(uniqueProduct))
}
