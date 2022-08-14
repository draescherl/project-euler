package problems

import utils.Utils.{sumOfDivisors, time}

// https://projecteuler.net/problem=23
// Sum of all positive integers that can't be written as the sum of 2 abundant numbers
object Problem023 extends App {
  lazy val solution: Int = {
    val limit = 28123
    val abundantNumbers = (0 to limit).map(sumOfDivisors).zipWithIndex.filter(num => num._1 > num._2).map(_._2)
    val sumsOfAbundantNumbers = abundantNumbers.view.flatMap(number =>
      abundantNumbers.takeWhile(_ <= (limit - number)).map(_ + number)
    ).to(IndexedSeq).distinct
    (1 to 28123 diff sumsOfAbundantNumbers).sum
  }

  println(time(solution))
}
