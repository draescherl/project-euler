package problems

import utils.Utils.time

// Find the sum of all the multiples of 3 or 5 below 1000.
object Problem001 {
  def main(args: Array[String]): Unit = {
    val result = (1 to 999).filter(x => (x % 3 == 0) || (x % 5 == 0)).sum
    println(time(result))
  }
}
