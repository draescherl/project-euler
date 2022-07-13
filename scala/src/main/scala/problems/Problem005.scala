package problems

import utils.Utils.{lcm, time}

import scala.annotation.tailrec

/* -----------------------------------------------------------------------
 Problem 5 : 2520 is the smallest number that can be divided by each of
 the numbers from 1 to 10 without any remainder.

 What is the smallest positive number that is evenly divisible by all of
 the numbers from 1 to 20?
 ----------------------------------------------------------------------- */
object Problem005 {
  // Bruteforce
  val smallestEvenlyDivisibleNumber: Int = {
    @tailrec
    def divisible(n: Int = 1, divider: Int = 2): Int =
      n % divider == 0 match {
        case true if divider == 20 => n
        case true                  => divisible(n, divider + 1)
        case false                 => divisible(n + 1)
      }

    divisible()
  }

  // Using LCM function
  val smallestEvenlyDivisibleNumberBis: Int =
    List.range(1, 20).foldLeft(1)(lcm)

  def main(args: Array[String]): Unit = {
    println(time(smallestEvenlyDivisibleNumber))
    println(time(smallestEvenlyDivisibleNumberBis))
  }
}
