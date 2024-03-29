package problems

import utils.Utils.{isPrime, time}

// https://projecteuler.net/problem=27
// Product of the coefficients (a, b) for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with 0
object Problem027 extends App {
  def sequenceLength(a: Int, b: Int): Int =
    LazyList.from(0).map(n => n * n + a * n + b).takeWhile(isPrime(_)).length

  lazy val solution: Int = {
    val values = for (
      a <- -999 to 999;
      b <- -1000 to 1000
    ) yield (a, b, sequenceLength(a, b))
    val max = values.reduce((a, b) => if (a._3 > b._3) a else b)
    max._1 * max._2
  }

  println(time(solution))
}
