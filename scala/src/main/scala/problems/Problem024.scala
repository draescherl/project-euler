package problems

import utils.Utils.time

// https://projecteuler.net/problem=24
// Millionth permutation of the digits 0 through 9
object Problem024 extends App {
  lazy val millionthPermutation: Long =
    (0 to 9)
      .permutations
      .map(_.mkString.toLong)
      .toList
      .sorted
      .take(999_999)
      .last

  println(time(millionthPermutation))
}
