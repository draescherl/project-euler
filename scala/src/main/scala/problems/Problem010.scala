package problems

import utils.Utils.{isPrime, time}

// https://projecteuler.net/problem=10
// Sum of all the primes below two million
object Problem010 {
  def sumPrimes(x: Long): Long =
    (2L to x filter isPrime).sum

  def main(args: Array[String]): Unit =
    println(time(sumPrimes(2_000_000L)))
}
