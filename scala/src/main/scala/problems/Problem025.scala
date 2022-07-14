package problems

import utils.Utils.time

/* -----------------------------------------------------------------------
 Problem 25 : What is the index of the first term in the Fibonacci
 sequence to contain 1000 digits?
 ----------------------------------------------------------------------- */
object Problem025 {
  def fibonacciIndex(numOfDigits: Int): Int = {
    lazy val bigFibs: LazyList[BigInt] = 0 #:: bigFibs.scanLeft(BigInt(1))(_ + _)
    bigFibs.indexWhere(_.toString.length == numOfDigits)
  }

  def main(args: Array[String]): Unit =
    println(time(fibonacciIndex(1000)))
}
