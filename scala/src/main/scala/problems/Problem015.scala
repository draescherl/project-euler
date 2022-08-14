package problems

import utils.Utils.{factorial, time}

// https://projecteuler.net/problem=15
// Number of routes through a grid
object Problem015 extends App {
  // The problem can be solved by calculating the number of combinations of
  // n elements in 2n possibilities
  def binomial(k: BigInt, n: BigInt): BigInt =
    factorial(n) / (factorial(k) * factorial(n - k))

  val width = 20
  println(time(binomial(width, width * 2))) // Width * 2 = length of the path
}
