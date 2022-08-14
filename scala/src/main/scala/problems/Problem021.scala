package problems

import utils.Utils.{sumOfDivisors, time}

// https://projecteuler.net/problem=21
// Sum of amicable numbers under 10_000
object Problem021 extends App {
  def amicableNumbersUnder(x: Int): List[Int] =
    (1 to x).filter(num => num != sumOfDivisors(num) && num == sumOfDivisors(sumOfDivisors(num))).toList

  println(time(amicableNumbersUnder(10000).sum))
}
