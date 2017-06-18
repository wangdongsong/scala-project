package com.wds.scala.base

import java.io.FileNotFoundException
import java.nio.file.AccessDeniedException

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
    //breakAndContinueExpr
    //useIfLikeThreeOperator
    //matchExpr
    //caseMatch
    //varableMatch(5)
    //accessCaseDefaultValue
    //caseIfExpr
    //matchList
    tryCatchExpr
  }

  /**
    * 3.16 try/catcha匹配一个或多个异常
    */
  def tryCatchExpr = {
    try {
      //openReadFile(fileName)
    }catch {
      case e : FileNotFoundException => println("not found")
      case e: AccessDeniedException => println("can not access")
    }

    try {
      //some expr
    } catch {
      case _: Throwable => println("exception ignored")
    }
  }

  /**
    * 3.15 在匹配表达式中使用List
    */
  def matchList = {
    //List数据结构和其它的集合数据结构略有不同，由列表单元开始，Nil元素结尾。
    val list = List("a", "b", "c")
    println(listToString(list))
    println(sum(List(1, 2, 3)))
  }

  def listToString(list: List[String]): String = list match{
    case s::rest => s + " " + listToString(rest)
    case Nil => ""
  }

  def sum(list: List[Int]): Int = list match {
    case Nil => 0
    case n :: rest => n + sum(rest)
  }

  /**
    * 3.13 给case语句增加if语句
    */
  def caseIfExpr = {
    val i = 8
    i match {
      case a if 0 to 9 contains a => println("0 - 9 range:" + a)
      case b if 10 to 19 contains b => println("10 - 19 range:" + b)
    }

    i match {
      case x if x == 1 => println("one")
      case y if y % 2 == 0 => println("odd")
    }
  }

  /**
    * 3.10 访问匹配表达缺省case的值
    */
  def accessCaseDefaultValue = {
    //获取匹配表达式中缺省的、“捕获一切”case的值，但是在用_通配符时，不能访问该值
    //解决是给缺省case指定一个变量名
    //若不给缺省值，会报MatchError
    val i = 10
    i match {
      case 0 => println("1")
      case 1 => println("2")
      case default => println("You gave me:" + default)
    }
  }

  /**
    * 3.9 将匹配表达式的结果赋值给变量
    */
  def varableMatch(someNumber: Int) = {

    val evenOrOdd = someNumber match {
      case 1 | 3 | 5 | 7 | 9 => println("odd")
      case 2 | 4 | 6 | 8 | 10 => println("even")
    }
  }


  def isTrue (a: Any) = a match{
    case 0 | "" => false
    case _ => true
  }

  /**
    * 3.8 case语句匹配多个条件
    */
  def caseMatch = {
    val i = 5
    i match {
      case 1 | 3 | 5 | 7 | 9 => println("odd")
      case 2 | 4 | 6 | 8 | 10 => println("even")
    }
  }

  /**
    * 3.7 switch
    */
  def matchExpr = {
    val i = 5
    i match {
      case 1 => println("January")
      case 2 => println("February")
      case 3 => println("March")
      case 4 => println("April")
      case 5 => println("May")
      case 6 => println("June")
      case 7 => println("July")
      case 8 => println("August")
      case 9 => println("September")
      case 10 => println("October")
    }
  }

  /**
    * 3.6 像三元运算符一样使用if
    */
  def useIfLikeThreeOperator = {
    val a = 1
    val absValue = if (a < 0) -a else a

    println(if (a == 1) "a" else "b")

  }



  /**
    * 3.5 break和continue
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
