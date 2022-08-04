package problems

import utils.Utils.time

// https://projecteuler.net/problem=36
// Sum of all numbers under 1_000_000 that are palindromes in decimal and binary
object Problem036 {
  def isPalindrome(n: String): Boolean =
    n.reverse == n

  lazy val solution: Int =
    (0 to 1_000_000).filter(n => isPalindrome(n.toString) && isPalindrome(n.toBinaryString)).sum

  def main(args: Array[String]): Unit =
    println(time(solution))
}
