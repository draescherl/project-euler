package problems

import utils.Utils.time

// https://projecteuler.net/problem=31
// Number of ways to make £2 using any number of coins
object Problem031 extends App {
  def ways(coins: List[Int], target: Int): Int =
    coins match {
      case head :: tail => if (head > target) 0
                           else if (head == target) 1
                           else ways(coins, target - head) + ways(tail, target)
      case _            => 0
    }

  println(time(ways(List(1, 2, 5, 10, 20, 50, 100, 200), 200)))
}
