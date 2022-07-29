package problems

import utils.Utils.time

import scala.annotation.tailrec

/* -----------------------------------------------------------------------
 Problem 4 : A palindromic number reads the same both ways. The largest
 palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

 Find the largest palindrome made from the product of two 3-digit numbers.
 ----------------------------------------------------------------------- */
object Problem004 {
  lazy val largestPalindrome: Int = {
    @tailrec
    def palindrome(a: Int = 100, b: Int = 100, list: List[Int] = Nil): List[Int] = {
      (a, b) match {
        case (999, 999) => (a * b) :: list
        case (_, 999) => palindrome(a + 1, 100, (a * b) :: list)
        case _ => palindrome(a, b + 1, (a * b) :: list)
      }
    }

    palindrome().filter(x => x.toString == x.toString.reverse).max
  }

  def main(args: Array[String]): Unit =
    println(time(largestPalindrome))
}
