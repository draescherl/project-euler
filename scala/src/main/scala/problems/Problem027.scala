package problems

import utils.Utils.{isPrime, time}

/* -----------------------------------------------------------------------
  Problem 27 :
 ----------------------------------------------------------------------- */
object Problem027 {
  def sequenceLength(a: Int, b: Int): Int =
    LazyList.from(0).map(n => n * n + a * n + b).takeWhile(isPrime(_)).length

  lazy val solution: Int = {
    val values = for (
      a <- -999 to 999;
      b <- -1000 to 1000
    ) yield (a, b, sequenceLength(a, b))
    val max = values.reduce((a, b) => if (a._3 > b._3) a else b)
    max._1 * max._2
  }

  def main(args: Array[String]): Unit =
    println(time(solution))
}
