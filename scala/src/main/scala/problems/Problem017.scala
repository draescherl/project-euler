package problems

import utils.Utils.time

// https://projecteuler.net/problem=17
// Number of letters in numbers from 1 to 1000
object Problem017 extends App {
  def numOfCharacters(x: Int): Int = {
    val units: Array[Int] = 0 +: Array(
      "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
      "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    ).map(_.length)
    val tens: Array[Int] = 0 +: 0 +: Array(
      "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    ).map(_.length)

    if      (x < 20)   units(x)
    else if (x < 100)  tens(x / 10) + (if (x % 10 > 0) numOfCharacters(x % 10) else 0)
    else if (x < 1000) units(x / 100) + "hundred".length + (if (x % 100 > 0) "and".length + numOfCharacters(x % 100) else 0)
    else 11
  }

  println(time((1 to 1000).map(numOfCharacters).sum))
}
