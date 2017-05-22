package com.wds.scala.base

/**
  * 绝对值
  * Created by wangdongsong1229@163.com on 2017/5/22.
  */
object MyModule {

  def abs(n : Int) : Int = {
    if (n < 0) -n
    else n
  }

  private def formatABS(x : Int)  = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  /**
    * 通过函数实现递归
    * @param n
    * @return
    */
  private def factorial(n : Int): Int = {
    def go(n : Int, acc: Int) : Int = {
      if (n <= 0) acc
      else go(n -1, n * acc)
    }

    go(n, 1)
  }

  private def fib(index : Int) ={

    def go(index : Int): Int = {
      if (index <= 0) return 0
      if (index == 1) return 1
      go(index - 1) + go( index - 2)
    }

    go(index)
  }

  /**
    * 高阶函数
    * @param name 描述
    * @param n 数字
    * @param func 函数
    * @return
    */
  def formatResult(name: String, n: Int, func: Int => Int) = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, func(n))
  }


  def main(args: Array[String]): Unit = {
    println(formatABS(-3))

    println(factorial(3))

    println(fib(8))

    println(formatResult("Abs value", -3, abs))

    println(formatResult("Factorial value", 8, fib))

  }

}
