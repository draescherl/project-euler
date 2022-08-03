package problems

import utils.Utils.time

import scala.io.Source
import scala.util.Using

// https://projecteuler.net/problem=22
// Sum of name scores
object Problem022 {
  def getCharPosition(c: Char): Int =
    c.toLower.toInt - 'a' + 1

  lazy val data: List[(String, Int)] = Using(Source.fromFile("src/main/scala/data/022-names.txt")) {
    source => source.mkString.split(",").toList
  }.get.sorted.map(_.toLowerCase()).zipWithIndex

  lazy val scores: BigInt =
    data.map(el => el._1.toCharArray.drop(1).dropRight(1).map(getCharPosition).sum * (el._2 + 1)).sum

  def main(args: Array[String]): Unit =
    println(time(scores))
}
