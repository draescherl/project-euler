package problems

import utils.Utils.time

import scala.annotation.tailrec

/* -----------------------------------------------------------------------
 Problem 14 : The following iterative sequence is defined for the set of
 positive integers:
    n → n/2 (n is even)
    n → 3n + 1 (n is odd)
  Using the rule above and starting with 13, we generate the following
  sequence:
    13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
  It can be seen that this sequence (starting at 13 and finishing at 1)
  contains 10 terms. Although it has not been proved yet (Collatz Problem),
  it is thought that all starting numbers finish at 1.

  Which starting number, under one million, produces the longest chain?
  NOTE: Once the chain starts the terms are allowed to go above one million.
 ----------------------------------------------------------------------- */
object Problem014 {
  val collatzIndex: Int = {
    @tailrec
    def collatz(init: Long, count: Int = 0): Int =
      if (init == 1) count + 1
      else if (init % 2 == 0) collatz(init / 2, count + 1)
      else collatz(3 * init + 1, count + 1)

    (1 until 1000000).view
      .map(i => (i, collatz(i)))
      .reduce((a, b) => if (a._2 > b._2) a else b)._1
  }

  def main(args: Array[String]): Unit =
    println(time(collatzIndex))
}
