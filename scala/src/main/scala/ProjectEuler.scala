import scala.annotation.tailrec
import scala.math.sqrt

object ProjectEuler {

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

  def main(args: Array[String]): Unit = {
    println(largestPrimeFactor(600851475143L))
  }

}
