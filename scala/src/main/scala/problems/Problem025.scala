package problems

import utils.Utils.{bigFibs, time}

// https://projecteuler.net/problem=25
// Index of the first fibonacci number to contain 1000 digits
object Problem025 {
  def fibonacciIndex(numOfDigits: Int): Int =
    bigFibs.indexWhere(_.toString.length == numOfDigits)

  def main(args: Array[String]): Unit =
    println(time(fibonacciIndex(1000)))
}
