package problems

import utils.Utils.{primes, time}

// https://projecteuler.net/problem=7
// 10_001st prime number
object Problem007 extends App {
  def nthPrimeNumber(n: Int): Int =
    primes.take(n).last

  println(time(nthPrimeNumber(10001)))
}
