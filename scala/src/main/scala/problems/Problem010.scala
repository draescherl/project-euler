package problems

import utils.Utils.{isPrime, time}

/* -----------------------------------------------------------------------
 Problem 10 : The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

 Find the sum of all the primes below two million.
 ----------------------------------------------------------------------- */
object Problem010 {
  def sumPrimes(x: Long): Long =
    (2L to x filter isPrime).sum

  def main(args: Array[String]): Unit =
    println(time(sumPrimes(2_000_000L)))
}
