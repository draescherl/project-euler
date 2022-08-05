package problems

import utils.Utils.{isPrime, time}

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

  lazy val primes: LazyList[Int] =
    11 #:: LazyList.from(13, step = 2).filter(n => !primes.takeWhile(_ <= math.sqrt(n)).exists(n % _ == 0))

//  @tailrec
//  def compute(tmp: LazyList[Int], elements: List[Long] = Nil, count: Int = 11): List[Long] = {
//    if (count == 0) elements
//    else {
//      val tmp2 = tmp.takeWhile(!isTruncatable(_))
//    }
//  }

  def main(args: Array[String]): Unit =
    println(time({
      val number = primes.takeWhile(!isTruncatable(_)).length
      primes.take(number+1).toList
    }
//      primes.take(len).toList
    ))
}
