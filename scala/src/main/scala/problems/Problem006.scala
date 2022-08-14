package problems

import utils.Utils.time

// https://projecteuler.net/problem=6
// Difference between the sum of the squares of the first one hundred natural numbers and the square of the sum
object Problem006 extends App {
  lazy val sums: Int = {
    val n = 100
    val sumSquares = Array.range(0, n + 1).map(x => x * x).sum
    val squareSum = Math.pow(n * (n + 1) / 2, 2).toInt
    squareSum - sumSquares
  }

  println(time(sums))
}
