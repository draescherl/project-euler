package problems

import utils.Utils.time

import scala.annotation.tailrec

// https://projecteuler.net/problem=4
// Largest palindrome made from the product of two 3-digit numbers
object Problem004 extends App {
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

  println(time(largestPalindrome))
}
