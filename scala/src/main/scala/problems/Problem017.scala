package problems

import utils.Utils.time


/* -----------------------------------------------------------------------
  Problem 17 : If the numbers 1 to 5 are written out in words: one, two,
  three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in
  total.

  If all the numbers from 1 to 1000 (one thousand) inclusive were written
  out in words, how many letters would be used?

  NOTE: Do not count spaces or hyphens. For example, 342 (three hundred
  and forty-two) contains 23 letters and 115 (one hundred and fifteen)
  contains 20 letters. The use of "and" when writing out numbers is in
  compliance with British usage.
 ----------------------------------------------------------------------- */
object Problem017 {
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

  def main(args: Array[String]): Unit =
    println(time((1 to 1000).map(numOfCharacters).sum))
}
