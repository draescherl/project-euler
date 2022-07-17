package problems

import utils.Utils.{isPrime, primes, time}

import scala.annotation.tailrec

/* -----------------------------------------------------------------------
  Problem 35 : The number, 197, is called a circular prime because all
  rotations of the digits: 197, 971, and 719, are themselves prime.

  There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31,
  37, 71, 73, 79, and 97.

  How many circular primes are there below one million?
 ----------------------------------------------------------------------- */
object Problem035 {
  @tailrec
  def shiftArray(input: List[Int], amount: Int = 1): List[Int] =
    if (amount <= 0) input
    else shiftArray(input.last +: input.take(input.length - 1), amount - 1)

  def isCircularPrime(x: Int): Boolean = {
    val asList: List[Int] = x.toString.map(_.asDigit).toList
    asList.indices.map(shiftArray(asList, _)).map(_.mkString.toLong).forall(isPrime)
  }

  def circularPrimesBelow(n: Int): Int =
    primes.takeWhile(_ < n).count(isCircularPrime)

  def main(args: Array[String]): Unit =
    println(time(circularPrimesBelow(1_000_000)))
}
