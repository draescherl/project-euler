# Scala version

This file contains writeups of challenges solved using the Scala language.



## Challenge 1

> Find the sum of all the multiples of 3 or 5 below 1000.

```scala
Array.range(0, 1000).filter(x => (x % 3 == 0) || (x % 5 == 0)).sum
```

## Challenge 2

> By considering the terms in the Fibonacci sequence whose values do not 
> exceed four million, find the sum of the even-valued terms.

```scala
val fibs: Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)
fibs.takeWhile(_ < 1000000).filter(_ % 2 == 0).sum
```


