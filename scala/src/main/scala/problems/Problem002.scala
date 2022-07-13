package problems

import utils.Utils.{fibs, time}

// By considering the terms in the Fibonacci sequence whose values do not
// exceed four million, find the sum of the even-valued terms.
object Problem002 {
  def main(args: Array[String]): Unit = {
    val result = fibs.takeWhile(_ < 4000000).filter(_ % 2 == 0).sum
    println(time(result))
  }
}
