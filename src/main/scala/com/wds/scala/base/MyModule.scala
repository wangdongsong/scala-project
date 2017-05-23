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

  /**
    * 在str中查找key的索引值
    * @param str
    * @param key
    * @return
    */
  def findFirst(str: Array[String], key: String) : Int ={
    def loop(n: Int): Int = {
      if(n >= str.length) -1
      else if (str(n) == key) n
      else loop(n + 1)
    }
    loop(0)
  }

  /**
    * 高价函数
    *
    * 泛型化的函数，在数据arrs中查找p
    * @param arrs
    * @param p
    * @tparam A
    * @return
    */
  def findFirstGeneric[A](arrs: Array[A], p: A => Boolean) : Int = {
    def loop(n: Int): Int = {
      if (n >= arrs.length) -1
      else if (p(arrs(n))) n
      else loop(n + 1)
    }
    loop(0)
  }


  def main(args: Array[String]): Unit = {
    println(formatABS(-3))

    println(factorial(3))

    println(fib(8))

    println(formatResult("Abs value", -3, abs))

    println(formatResult("Factorial value", 8, fib))

    println(findFirst(Array("A", "B", "C"), "C"))

    //对高阶函数传入匿名高阶函数
    println(findFirstGeneric(Array("A", "B", "C", "D"), (str: String) => str == "B"))
  }

}
