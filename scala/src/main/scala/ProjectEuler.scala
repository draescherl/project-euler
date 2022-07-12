import scala.annotation.tailrec

object ProjectEuler {

  /* -----------------------------------------------------------------------
   Problem 3 : The prime factors of 13195 are 5, 7, 13 and 29.

   What is the largest prime factor of the number 600851475143 ?
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
   Problem 4 : A palindromic number reads the same both ways. The largest
   palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

   Find the largest palindrome made from the product of two 3-digit numbers.
   ----------------------------------------------------------------------- */
  val largestPalindrome: Int = {
    @tailrec
    def palindrome(a: Int = 100, b: Int = 100, list: List[Int] = Nil): List[Int] = {
      (a, b) match {
        case (999, 999) => (a * b) :: list
        case (_,   999) => palindrome(a + 1, 100,   (a * b) :: list)
        case _          => palindrome(a,     b + 1, (a * b) :: list)
      }
    }

    palindrome().filter(x => x.toString == x.toString.reverse).max
  }


  /* -----------------------------------------------------------------------
   Problem 5 : 2520 is the smallest number that can be divided by each of
   the numbers from 1 to 10 without any remainder.

   What is the smallest positive number that is evenly divisible by all of
   the numbers from 1 to 20?
   ----------------------------------------------------------------------- */
  // Bruteforce.
  val smallestEvenlyDivisibleNumber: Int = {
    @tailrec
    def divisible(n: Int = 1, divider: Int = 2): Int =
      n % divider == 0 match {
        case true if divider == 20 => n
        case true                  => divisible(n, divider + 1)
        case false                 => divisible(n + 1)
      }

    divisible()
  }

  // Using LCM function.
  @tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a.abs else gcd(b, a % b)
  def lcm(a: Int, b: Int): Int = (a * b).abs / gcd(a, b)
  val smallestEvenlyDivisibleNumberBis: Int = List.range(1, 20).foldLeft(1)(lcm)


  /* -----------------------------------------------------------------------
   Problem 6 : Find the difference between the sum of the squares of the
   first one hundred natural numbers and the square of the sum.
   ----------------------------------------------------------------------- */
  val sums: Int = {
    val n = 100
    val sumSquares = Array.range(0, n + 1).map(x => x * x).sum
    val squareSum = Math.pow(n * (n + 1) / 2, 2).toInt
    squareSum - sumSquares
  }


  /* -----------------------------------------------------------------------
   Problem 7 : By listing the first six prime numbers: 2, 3, 5, 7, 11,
   and 13, we can see that the 6th prime is 13.

   What is the 10 001st prime number?
   ----------------------------------------------------------------------- */
  val primes: LazyList[Int] = 2 #:: LazyList.from(3, step = 2)
    .filter(n => !primes.takeWhile(_ <= math.sqrt(n)).exists(n % _ == 0))
  // Call with : primes.take(10001).last

  // ------------------------------------------------------------------------------
  // ------------------------------------------------------------------------------


  def main(args: Array[String]): Unit = {
    def time[R](block: => R): R = {
      val t0 = System.currentTimeMillis()
      val result = block    // call-by-name
      val t1 = System.currentTimeMillis()
      println("Elapsed time: " + (t1 - t0) + "ms.")
      result
    }

    val result = time(primes.take(10001).last)
    println(result)
  }

}
