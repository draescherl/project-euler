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

    isLeap(year) flatMap { numDays(_, month) }
  }

  val numFirstSundays: Int = {
    val days = (for (
      years  <- 1900 to 2000;
      months <-    1 to   12
    ) yield numberOfDays(years, months)).map(_.get).toList
    println(days)

    val leapYears = (1900 to 2000).count(isLeap(_).getOrElse(false))
    val totalDays = leapYears * 366 + (2000 - 1900 - leapYears) * 365
    val daysOfWeek = for (i <- 0 to totalDays) yield i % 7

//    val test = days.sliding(12).zipWithIndex.map(
//      monthsInYear => monthsInYear.map(
//        daysInMonth => daysOfWeek.take(daysInMonth)
//      )
//    ).toList
//    println(test)

    5
  }

  def main(args: Array[String]): Unit =
    println(time(numFirstSundays))
}
