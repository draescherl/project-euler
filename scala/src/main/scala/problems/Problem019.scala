package problems

import utils.Utils.time

/* -----------------------------------------------------------------------
  Problem 19 : You are given the following information, but you may prefer
  to do some research for yourself.

    1 Jan 1900 was a Monday.
    Thirty days has September,
    April, June and November.
    All the rest have thirty-one,
    Saving February alone,
    Which has twenty-eight, rain or shine.
    And on leap years, twenty-nine.
    A leap year occurs on any year evenly divisible by 4, but not on a
    century unless it is divisible by 400.

  How many Sundays fell on the first of the month during the twentieth
  century (1 Jan 1901 to 31 Dec 2000)?
 ----------------------------------------------------------------------- */
object Problem019 {
  def isLeap(year: Int): Option[Boolean] =
    if (year < 0) None
    else Some((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))

  def numberOfDays(year: Int, month: Int): Option[Int] = {
    def numDays(leap: => Boolean, month: Int): Option[Int] =
      if (month < 1 || month > 12) None
      else month match {
        case 2 => Some(if (leap) 29 else 28)
        case 4 | 6 | 9 | 11 => Some(30)
        case _ => Some(31)
      }

    isLeap(year) flatMap {
      numDays(_, month)
    }
  }

  def gaussFormula(day: Int, month: Int, year: Int): Int = {
    val x = year - (14 - month) / 12
    val y = x + x / 4 - x / 100 + x / 400
    val z = month + 12 * ((14 - month) / 12) - 2
    val dateOfWeek = (day + y + (31 * z) / 12) % 7
    dateOfWeek
  }

  lazy val firstSundays: Int = {
    (for (
      year  <- 1901 to 2000;
      month <-    1 to 12;
      day   <-    1 to numberOfDays(year, month).getOrElse(0)
    ) yield (day, gaussFormula(day, month, year))).count(_ == (1, 0))
  }

  def main(args: Array[String]): Unit =
    println(time(firstSundays))
}
