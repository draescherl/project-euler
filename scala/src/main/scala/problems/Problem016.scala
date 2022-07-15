package problems

import utils.Utils.time

/* -----------------------------------------------------------------------
  Problem 16 : 2^15 = 32768 and the sum of its digits is
    3 + 2 + 7 + 6 + 8 = 26.

  What is the sum of the digits of the number 2^1000?
 ----------------------------------------------------------------------- */
object Problem016 {
  def sumDigits(input: BigInt): BigInt =
    input.toString().split("").map(_.toInt).sum

  def main(args: Array[String]): Unit =
    println(time(sumDigits(BigInt(2).pow(1000))))
}
