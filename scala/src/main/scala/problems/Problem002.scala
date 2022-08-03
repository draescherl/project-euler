package problems

import utils.Utils.{fibs, time}

// https://projecteuler.net/problem=2
// Sum of even primes under 4 million
object Problem002 {
  def main(args: Array[String]): Unit = {
    val result = fibs.takeWhile(_ < 4_000_000).filter(_ % 2 == 0).sum
    println(time(result))
  }
}
