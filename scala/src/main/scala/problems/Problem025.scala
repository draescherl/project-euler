package problems

import utils.Utils.{bigFibs, time}

// https://projecteuler.net/problem=25
// Index of the first fibonacci number to contain 1000 digits
object Problem025 extends App {
  def fibonacciIndex(numOfDigits: Int): Int =
    bigFibs.indexWhere(_.toString.length == numOfDigits)

  println(time(fibonacciIndex(1000)))
}
