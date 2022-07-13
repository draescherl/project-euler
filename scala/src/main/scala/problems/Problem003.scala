package problems

import utils.Utils.time

import scala.annotation.tailrec

/* -----------------------------------------------------------------------
 Problem 3 : The prime factors of 13195 are 5, 7, 13 and 29.

 What is the largest prime factor of the number 600851475143 ?
 ----------------------------------------------------------------------- */
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
    println(time(largestPrimeFactor(600851475143L)))
}
