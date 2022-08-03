package problems

import utils.Utils.time

// https://projecteuler.net/problem=16
// Sum of digits of 2^1000
object Problem016 {
  def sumDigits(input: BigInt): BigInt =
    input.toString().split("").map(_.toInt).sum

  def main(args: Array[String]): Unit =
    println(time(sumDigits(BigInt(2).pow(1000))))
}
