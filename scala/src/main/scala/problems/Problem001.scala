package problems

import utils.Utils.time

// https://projecteuler.net/problem=1
// Sum of multiples of 3 or 5 under 1000
object Problem001 extends App {
  val result = (1 to 999).filter(x => (x % 3 == 0) || (x % 5 == 0)).sum
  println(time(result))
}
