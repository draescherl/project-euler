package problems

import utils.Utils.{isPrime, time, primes, ESieve}

import scala.annotation.tailrec

// https://projecteuler.net/problem=37
// Sum of the eleven primes that are truncatable from left and right
object Problem037 {
  def isTruncatable(n: Int): Boolean = {
    val asArray = n.toString.split("")
    val rightToLeft = asArray.scanLeft("")(_ + _).drop(1).map(_.toLong).reverse
    val leftToRight = asArray.scanRight("")(_ + _).dropRight(1).map(_.toLong).reverse
    rightToLeft.forall(isPrime) && leftToRight.forall(isPrime)
  }

  lazy val primesFrom: Int => LazyList[Int] = (start: Int) =>
    start #:: LazyList.from(start + 2, step = 2).filter(n => !primesFrom(start).takeWhile(_ <= math.sqrt(n)).exists(n % _ == 0))

  // Start value MUST be a prime number
  @tailrec
  def compute(elements: List[Long] = Nil, start: Int = 11): List[Long] = {
    if (elements.length == 11) elements
    else {
      val candidate = ESieve(LazyList.from(start)).take(2).last
      if (isTruncatable(candidate)) compute(candidate :: elements, candidate)
      else                          compute(elements,              candidate)
    }
  }

  def main(args: Array[String]): Unit =
    println(time(
      compute()
    ))
}
