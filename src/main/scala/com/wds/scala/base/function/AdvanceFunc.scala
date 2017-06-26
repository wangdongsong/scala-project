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
