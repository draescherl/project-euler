package problems

import utils.Utils.{factorial, time}

import scala.annotation.tailrec

// https://projecteuler.net/problem=20
// Sum of digits in 100!
object Problem020 {
  def sumDigits(x: BigInt): BigInt =
    factorial(x).toString().split("").map(_.toInt).sum

  def main(args: Array[String]): Unit =
    println(time(sumDigits(100)))
}
