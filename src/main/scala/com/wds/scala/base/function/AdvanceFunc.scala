package com.wds.scala.base.function

/**
  * 9.6 部分应用函数
  * Created by wangdongsong1229@163.com on 2017/6/26.
  */
object AdvanceFunc {

  def main(args: Array[String]): Unit = {
    val nums = Array("one", "two", "three", "four")
    //9.6 使用部分应用函数
    //partialFunc

    //9.7 创建返回函数的函数
    //从函数或者方法返回一个函数
    val sayHello = saySomething("Hello")
    println(sayHello("Hi"))
    val hello = greeting("english")
    hello("AI")
    val hello2 = greeting2("english")
    hello2("AI")

    //9.8 创建部分应用函数
    basePartialFunc
  }

  def basePartialFunc: Unit = {
    //当x为0时，该函数抛出异常
    val divide = (x: Int) => 42 / x

    println("---------PartialFunction---------")
    val divide2 = new PartialFunction[Int, Int] {
      def apply(x: Int) = 42 / x
      override def isDefinedAt(x: Int): Boolean = x != 0
    }
    println(if(divide2.isDefinedAt(1)) divide2(1))

    //等同于divide2
    val divide3: PartialFunction[Int, Int] = {
      case x: Int  if x != 0 => 42 / x
    }
    println(if(divide3.isDefinedAt(2)) divide3(2))

    val convert1to5 = new PartialFunction[Int, String] {
      val nums = Array("one", "two", "three", "four", "five")

      def apply(x: Int): String = nums(x - 1)

      def isDefinedAt(x: Int): Boolean = x > 0 && x < 6
    }
    val convert6to10 = new PartialFunction[Int, String] {
      val nums = Array("six", "seven", "eight", "nine", "ten")

      def apply(x: Int): String = nums(x - 6)

      def isDefinedAt(x: Int): Boolean = x > 5 && x < 11
    }

    val handle1to10 = convert1to5 orElse convert6to10
    println(handle1to10(3))
    println(handle1to10(7))


    println("-----------------")
    //偏函数定义
    val isEven: PartialFunction[Int, String] = {
      case x if x % 2 == 0 => x + " is even"
    }
    //collect方法使用偏函数的例子
    (1 to 5).collect(isEven).foreach(print)
  }

  /**
    * 方法一
    * @param lang
    * @return
    */
  def greeting(lang: String) = (name: String) =>{
    val english = () => println("Hello, " + name)
    val spanish = () => "Buenos dias, " + name

    lang match {
      case "english" => println("returning 'englist' function")
        english()
      case "spanish" => println("returning 'spanish' function")
        spanish

    }
  }

  /**
    * 方法二
    * @param lang
    * @return
    */
  def greeting2(lang: String) = (name: String) =>{

    lang match {
      case "english" => println("Hello, " + name)
      case "spanish" => println("Buenos dias, " + name)

    }
  }

  def saySomething(prefix: String) = (s: String) => {
    prefix + " " + s
  }

  def partialFunc = {
    val sum = (a: Int, b: Int, c: Int) => a + b + c
    val p_sum = sum(1, 2, _: Int)
    println(p_sum(3))
  }
}
