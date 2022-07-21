package problems

import utils.Utils.{factorial, time}

/* -----------------------------------------------------------------------
  Problem 15 : Starting in the top left corner of a 2×2 grid, and only
  being able to move to the right and down, there are exactly 6 routes
  to the bottom right corner.

  How many such routes are there through a 20×20 grid?
 ----------------------------------------------------------------------- */
object Problem015 {
  // The problem can be solved by calculating the number of combinations of
  // n elements in 2n possibilities
  def binomial(k: BigInt, n: BigInt): BigInt =
    factorial(n) / (factorial(k) * factorial(n - k))

  def main(args: Array[String]): Unit =
    println(time(binomial(20, 40))) // 20 = dimensions of the grid
                                    // 40 = length of the path
}
