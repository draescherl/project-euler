package problems

import utils.Utils.time

import scala.io.Source
import scala.util.Using

/* -----------------------------------------------------------------------
  Problem 22 : Using names.txt (right click and 'Save Link/Target As...'),
  a 46K text file containing over five-thousand first names, begin by
  sorting it into alphabetical order. Then working out the alphabetical
  value for each name, multiply this value by its alphabetical position
  in the list to obtain a name score.

  For example, when the list is sorted into alphabetical order, COLIN,
  which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
  So, COLIN would obtain a score of 938 × 53 = 49714.

  What is the total of all the name scores in the file?
 ----------------------------------------------------------------------- */
object Problem022 {
  def getCharPosition(c: Char): Int =
    c.toLower.toInt - 'a' + 1

  lazy val data: List[(String, Int)] = Using(Source.fromFile("src/main/scala/data/names.txt")) {
    source => source.mkString.split(",").toList
  }.get.sorted.map(_.toLowerCase()).zipWithIndex

  lazy val scores: BigInt =
    data.map(el => el._1.toCharArray.drop(1).dropRight(1).map(getCharPosition).sum * (el._2 + 1)).sum

  def main(args: Array[String]): Unit =
    println(time(scores))
}
