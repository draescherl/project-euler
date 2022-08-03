package problems

import utils.Utils.{isPrime, primes, time}

import scala.annotation.tailrec

// https://projecteuler.net/problem=35
// Number of circular primes below 1_000_000
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
