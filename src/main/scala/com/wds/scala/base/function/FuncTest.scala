package com.wds.scala.base.function

/**
  * 9 函数式编程
  *
  * 9.1 使用函数字面量
  *
  * 问题：匿名函数，也称函数字面量，作为变量传入把函数作为参数的方法中或赋值给一个变量
  * Created by wangdongsong1229@163.com on 2017/6/26.
  */
object FuncTest {
  def main(args: Array[String]): Unit = {
    //9.1 函数字面量
    //funcAsLetterVariable
    //9.2 函数作为变量
    //funcAsVariable
    //9.3 定义接受简单函数作为参数的方法
    acceptFunc
  }

  def acceptFunc = {
    val sayHello = () => {println("sayHello")}
    executeFunction(sayHello)
    val sayOne = (i: Int) => {println(i * 2)}
    executeFunction(sayOne)
    executeFunction(sayHello, 3)

    //复杂函数
    val sum = (i: Int, k: Int) => {i + k}
    val multiply = (x: Int, y: Int) => x * y
    executeAndPrint(sum , 3, 2)
    executeAndPrint(multiply, 3, 2)
  }

  def executeAndPrint(f:(Int, Int) => Int, i: Int, k: Int): Unit ={
    val result = f(i, k)
    println("result: ", result)
  }

  def executeFunction(callback:() => Unit): Unit ={
    callback()
  }

  def executeFunction(f: Int => Unit): Unit ={
    f(10)
  }

  def executeFunction(callback: () => Unit, index: Int) : Unit ={
    for(i <- 1 until index) callback
  }

  def funcAsLetterVariable = {
    val x = List.range(1, 10)
    x.foreach(print)

    println
    //创建只有偶数的新List
    val evens = x.filter((i: Int) => i % 2 == 0)
    //因编译器可推断i为Int类型，因此可以去掉Int
    x.filter(i => i % 2 == 0)
    //当参数在函数中只出现一次时，Scala允许使用“_”通配符替换变量名
    x.filter(_ % 2 == 0)
    evens.foreach(print)

    //简捷方式如下 ：
    val evens2 = x.filter(_ % 2 == 0)
    evens2.foreach(print)

    evens2.foreach((i: Int) => println(i))
    evens2.foreach((i) => println(i))
    evens2.foreach(i => println(i))
    evens2.foreach(println(_))
    //如果一个函数的字面量只有一条语句，且该语句只接受一个参数，那么参数不需要特别指定，也不需要显式声明
    evens2.foreach(println)
  }

  def funcAsVariable = {
    val double = (i: Int) => (i * 2)
    println(double(2))
    var list = List.range(1, 5)
    list.map(double).foreach(print)

    println()
    val f: Int => Boolean = _ % 2 == 0
    list.filter(f).foreach(print)

    println()
    val c = scala.math.abs _
    val list2 = List.range(-5, -1)
    println()
    list2.map(c).foreach(print)
    println()
    val p = scala.math.pow(_, _)
    println(p(3, 2))
  }
}
