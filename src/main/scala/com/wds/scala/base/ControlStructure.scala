package com.wds.scala.base

import util.control.Breaks._
import scala.annotation.tailrec

/**
  * 3 控制结构
  * Created by wangdongsong1229@163.com on 2017/6/18.
  */
object ControlStructure {

  def main(args: Array[String]) : Unit = {
    //forAndForEach
    //forUseCounter
    //guardFor
    //forExpress
    breakAndContinueExpr
  }

  /**
    * 3.6 break和continue
    */
  def breakAndContinueExpr = {

    //break
    breakable {
      for (i <- 0 to 10){
        println(i)
        if (i > 4) break
      }
    }


    //continue
    val search = "peter piper picked a peck of pickled peppers"
    var numPs = 0;
    for (i <- 0 until search.length){
      breakable{
        if (search.charAt(i) != 'p'){
          break
        }else{
          numPs += 1
        }
      }
    }
    println(numPs)

    println(factorial(3))

    println(factorialTail(3))
  }

  def factorialTail(n: Int): Int = {
    @tailrec def factorialAcc(acc: Int, n: Int): Int = {
      if (n <= 1) acc
      else factorialAcc(n * acc, n - 1)
    }
    factorialAcc(1 , n)
  }

  /**
    * 递归
    * @param n
    * @return
    */
  def factorial(n: Int): Int = {
    if (n == 1) 1
    else n * factorial(n - 1)
  }

  /**
    * 3.4 创建for表达式
    * 对一个已有的集合中的每个元素应用一个算法（可能包含一个或多个语句），从而生成一个新的集合
    */
  def forExpress = {
    val names = Array("chris", "ed", "maurice")
    //不带卫语句的for循环，等同于map
    val capNames = for ( e <- names) yield  e.capitalize
    capNames.foreach(println)
    //等同于map
    capNames.map(_.toUpperCase).foreach(println)

    val lengths = for (e <- names) yield {
      e.length
    }
    lengths.foreach(println)
  }

  /**
    * 3.3 在for语句中嵌入if语句（卫语句）
    */
  def guardFor = {
    for(i <- 1 to 10 if i % 2 == 0) println(i)

    for {
      i <- 1 to 10
      if i % 2 == 0
    }println(i)
  }

  /**
    * for循环中使用多个计数器
    */
  def forUseCounter = {
    for (i <- 1 to 2; j <- 1 to 2) println(s"i = $i, j = $j")

    //多行
    for {
      i <- 1 to 2
      j <- 1 to 2
    } println(s"i = $i, j = $j")

    //多维数组
    val array = Array.ofDim[Int](2, 2)
    println(array)
    for{
      i <- 0 to 1
      j <- 0 to 1
    }println(s"($i)($j) = ${array(i)(j)}")

  }

  /**
    * 3.1 遍历集合中的所有元素，对集合中的每个元素进行操作
    * 或利用现有集合创建新的集合
    */
  def forAndForEach = {
    val a = Array("apple", "banana", "orange")
    a.foreach(print)
    println()
    for (e <- a) print(e + "_")

    for (e <- a) {
      val s = e.toUpperCase
      print(s + "_")
    }
    println()

    //for循环返回值
    val newArray = for (e <- a) yield e.toUpperCase.foreach(print)
    println()
    val newArray2 = for (e <-a) yield {
      val s = e.toLowerCase
      s
    }.foreach(print)

    //for循环计数器
    for (i <- 0 until a.length){
      println(s"$i is ${a(i)}")
    }

    //zipWithIndex
    for ((e, count) <- a.zipWithIndex){
      println(s"$count is $e")
    }

    //Range生成器
    for (i <- 0 to 3) print(i + "_")
    println()
    for (i <- 0 to 3 if i < 4) print(i + "_")
    println()

    //遍历一个Map
    val names = Map("fname" -> "Robert", "lname" -> "Goren")
    for ((k, v) <- names) println(s"key: $k, value: $v")

    //foreach
    //匿名函数
    a.foreach( e => println(e.toUpperCase()))
    a.foreach{e =>
      val s = e.toUpperCase()
      print(s + "_")
    }
    println()
  }
}
