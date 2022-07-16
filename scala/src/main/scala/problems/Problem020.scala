package problems

import utils.Utils.{factorial, time}

import scala.annotation.tailrec

/* -----------------------------------------------------------------------
  Problem 20 : n! means n × (n − 1) × ... × 3 × 2 × 1
  For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
  and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

  Find the sum of the digits in the number 100!
 ----------------------------------------------------------------------- */
object Problem020 {
  def sumDigits(x: BigInt): BigInt =
    factorial(x).toString().split("").map(_.toInt).sum

  def main(args: Array[String]): Unit =
    println(time(sumDigits(100)))
}
