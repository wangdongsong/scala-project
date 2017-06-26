package com.wds.scala.base.function

import scala.collection.mutable.ArrayBuffer

/**
  * 9.5 使用闭包
  * Created by wangdongsong1229@163.com on 2017/6/26.
  */
object ClosureTest {

  def main(args: Array[String]): Unit = {
    var hello = "hello"
    def sayHello(name: String) {println(s"$hello, $name")}

    val foo = new Foo
    foo.exec(sayHello, "AI")

    hello = "Hola"
    foo.exec(sayHello, "Lorenzo")

    //第二个闭包
    voting

    //第三个闭包
    //fruits变量跟着addToBasket走
    val fruits = ArrayBuffer("apple")
    val addToBasket = (s: String) => {
      fruits += s
      println(fruits.mkString(","))
    }
    buyBuffer(addToBasket, "banana")

  }

  def buyBuffer(f: String => Unit, s: String): Unit ={
    f(s)
  }

  /**
    * 第二个闭包
    */
  def voting = {
    var votingAge = 18
    val isOfVotingAge = (age: Int) => age >= votingAge

    printResult(isOfVotingAge, 20)
    printResult(isOfVotingAge, 17)
  }

  def printResult(f: Int => Boolean, x: Int): Unit ={
    println(f(x))
  }

}

class Foo{
  def exec(f:(String) => Unit, name: String): Unit ={
    f(name)
  }
}
