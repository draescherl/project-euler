package problems

import utils.Utils.{fibs, time}

/* -----------------------------------------------------------------------
 Problem 25 : What is the index of the first term in the Fibonacci
 sequence to contain 1000 digits?
 ----------------------------------------------------------------------- */
object Problem025 {
  // https://youtu.be/kWVPOpuAtzE
  def fibonacciIndex(numOfDigits: Int): Int = {
    fibs.takeWhile(_.toString.length < numOfDigits).length
  }

  def main(args: Array[String]): Unit =
    println(time(fibonacciIndex(1000)))
}
