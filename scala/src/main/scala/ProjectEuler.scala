import scala.annotation.tailrec

object ProjectEuler {

  def time[R](block: => R): R = {
    val t0 = System.currentTimeMillis()
    val result = block    // call-by-name
    val t1 = System.currentTimeMillis()
    println("Elapsed time: " + (t1 - t0) + "ms.")
    result
  }


  def largestPrimeFactor(n: Long): Long = {
    @tailrec
    def factorize(n: Long, prime: Int = 2, list: List[Long] = Nil): List[Long] =
      prime * prime > n match {
        case false if n % prime == 0 => factorize(n / prime, prime,     prime :: list)
        case false                   => factorize(n,         prime + 1, list)
        case true                    => n :: list
      }

    factorize(n).max
  }

  // Try using foldLeft by defining a LCM function (https://rosettacode.org/wiki/Least_common_multiple#Scala)
  def smallestEvenlyDivisibleNumber(init: Int): Int = {
    @tailrec
    def divisible(n: Int, divider: Int): Int =
      n % divider == 0 match {
        case true if divider == 20 => n
        case true                  => divisible(n, divider + 1)
        case false                 => divisible(n + 1, 2)
      }

    divisible(init, 2)
  }

  def main(args: Array[String]): Unit = {
    val result = time(smallestEvenlyDivisibleNumber(100))
    println(result)
  }

}
