package problems

import utils.Utils.time

import scala.annotation.tailrec

// https://projecteuler.net/problem=3
// Largest prime factor of 600_851_475_143
object Problem003 {
  def largestPrimeFactor(n: Long): Long = {
    @tailrec
    def factorize(n: Long, prime: Int = 2, list: List[Long] = Nil): List[Long] =
      prime * prime > n match {
        case false if n % prime == 0 => factorize(n / prime, prime,     prime :: list)
        case false                   => factorize(n,         prime + 1, list)
        case true                    => n :: list
      }

    factorize(n).max
  }

  def main(args: Array[String]): Unit =
    println(time(largestPrimeFactor(600_851_475_143L)))
}
