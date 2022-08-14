package problems

import utils.Utils.time

// https://projecteuler.net/problem=9
// (a, b, c) such that a²+b²=c² and a+b+c=1000
object Problem009 extends App {
  lazy val uniqueProduct: Long = {
    val limit = (1 to 1000).find(n => n + math.sqrt(n) >= 1000).get
    val products = for (
      a <- 1 until limit;
      b <- a until limit;
      c = 1000 - a - b if a * a + b * b == c * c
    ) yield a * b * c
    products.head
  }

  println(time(uniqueProduct))
}
