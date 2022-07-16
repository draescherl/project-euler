package problems

import utils.Utils.{bigFibs, time}

/* -----------------------------------------------------------------------
 Problem 25 : What is the index of the first term in the Fibonacci
 sequence to contain 1000 digits?
 ----------------------------------------------------------------------- */
object Problem025 {
  def fibonacciIndex(numOfDigits: Int): Int =
    bigFibs.indexWhere(_.toString.length == numOfDigits)

  def main(args: Array[String]): Unit =
    println(time(fibonacciIndex(1000)))
}
