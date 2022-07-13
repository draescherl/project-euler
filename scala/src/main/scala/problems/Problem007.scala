package problems

import utils.Utils.{primes, time}

/* -----------------------------------------------------------------------
 Problem 7 : By listing the first six prime numbers: 2, 3, 5, 7, 11,
 and 13, we can see that the 6th prime is 13.

 What is the 10 001st prime number?
 ----------------------------------------------------------------------- */
object Problem007 {
  def nthPrimeNumber(n: Int): Int =
    primes.take(n).last

  def main(args: Array[String]): Unit =
    println(time(nthPrimeNumber(10001)))
}
