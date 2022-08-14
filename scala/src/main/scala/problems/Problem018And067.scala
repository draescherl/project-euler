package problems

import utils.Utils.time

import scala.io.Source
import scala.util.Using

// https://projecteuler.net/problem=18
// https://projecteuler.net/problem=67
// Max path through a triangle
object Problem018And067 extends App {
  lazy val data: List[List[Int]] = Using(Source.fromFile("src/main/scala/data/067-triangle.txt")) {
    source => source.mkString
  }.get.split("\n").map(_.split("\\s+").map(_.toInt).toList).toList

  lazy val maxTotal: Int = {
    // TODO: Figure out a way to do this using only immutable data types.
    val memory = collection.mutable.Map[(Int, Int), Int]()

    def compute(row: Int = 0, col: Int = 0): Int = {
      if (row == data.length) 0
      else memory.getOrElseUpdate((row, col), data(row)(col) + (compute(row + 1, col) max compute(row + 1, col + 1)))
    }

    compute()
  }

  println(time(maxTotal))
}
