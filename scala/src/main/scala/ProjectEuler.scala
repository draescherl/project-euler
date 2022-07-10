import scala.annotation.tailrec

object ProjectEuler {

  /* -----------------------------------------------------------------------
   Problem 3 : What is the largest prime factor of the number 600851475143 ?
   ----------------------------------------------------------------------- */
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

  /* -----------------------------------------------------------------------
   Problem 5 : What is the smallest positive number that is evenly divisible
   by all of the numbers from 1 to 20?
   ----------------------------------------------------------------------- */
  // Bruteforce.
  def smallestEvenlyDivisibleNumber(init: Int = 1): Int = {
    @tailrec
    def divisible(n: Int, divider: Int): Int =
      n % divider == 0 match {
        case true if divider == 20 => n
        case true                  => divisible(n, divider + 1)
        case false                 => divisible(n + 1, 2)
      }

    divisible(init, 2)
  }

  // Using LCM function.
  @tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a.abs else gcd(b, a % b)
  def lcm(a: Int, b: Int): Int = (a * b).abs / gcd(a, b)
  val smallestEvenlyDivisibleNumberBis: Int = List.range(1, 20).foldLeft(1)(lcm)


  def main(args: Array[String]): Unit = {
    def time[R](block: => R): R = {
      val t0 = System.currentTimeMillis()
      val result = block    // call-by-name
      val t1 = System.currentTimeMillis()
      println("Elapsed time: " + (t1 - t0) + "ms.")
      result
    }

    val result = time(smallestEvenlyDivisibleNumberBis)
    println(result)
  }

}
