package problems

import utils.Utils.time

import scala.annotation.tailrec

/* -----------------------------------------------------------------------
  Problem 31 : In the United Kingdom the currency is made up of pound (£)
  and pence (p). There are eight coins in general circulation:

    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).

  It is possible to make £2 in the following way:

    1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p

  How many different ways can £2 be made using any number of coins?
 ----------------------------------------------------------------------- */
object Problem031 {
  def ways(coins: List[Int], target: Int): Int =
    coins match {
      case head :: tail => if (head > target) 0
                           else if (head == target) 1
                           else ways(coins, target - head) + ways(tail, target)
      case _            => 0
    }

  def main(args: Array[String]): Unit =
    println(time(ways(List(1, 2, 5, 10, 20, 50, 100, 200), 200)))
}
