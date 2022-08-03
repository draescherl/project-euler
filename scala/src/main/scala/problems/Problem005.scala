package problems

import utils.Utils.{lcm, time}

import scala.annotation.tailrec

// https://projecteuler.net/problem=5
// Smallest number evenly divisible from numbers 1..20
object Problem005 {
  // Bruteforce
  lazy val smallestEvenlyDivisibleNumber: Int = {
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
  lazy val smallestEvenlyDivisibleNumberBis: Int =
    List.range(1, 20).foldLeft(1)(lcm)

  def main(args: Array[String]): Unit = {
    println(time(smallestEvenlyDivisibleNumber))
    println(time(smallestEvenlyDivisibleNumberBis))
  }
}
