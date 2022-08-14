package problems

import utils.Utils.time

import scala.annotation.tailrec

// https://projecteuler.net/problem=14
// Longest Collatz chain starting with numbers 0..1_000_000
object Problem014 extends App {
  lazy val collatzIndex: Int = {
    @tailrec
    def collatz(init: Long, count: Int = 0): Int =
      if (init == 1) count + 1
      else if (init % 2 == 0) collatz(init / 2, count + 1)
      else collatz(3 * init + 1, count + 1)

    (1 until 1000000).view
      .map(i => (i, collatz(i)))
      .reduce((a, b) => if (a._2 > b._2) a else b)._1
  }

  println(time(collatzIndex))
}
