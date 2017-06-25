package com.wds.scala.base

/**
  * 8 特质
  * train物质大多数情况下类似于Java的接口，Scala中可以继承多个特质，使用extends和with关键字
  * Created by wangdongsong1229@163.com on 2017/6/25.
  */
object TraitTest {
  def main(args: Array[String]): Unit = {

  }
}

/**
  * 8.1 特质作为接口使用
  */
trait Computer{
  var size = 14
  val maxNumToppings = 10
  var outputSize: Int //abstract
  val maxNumToppins2: Int

  def play
  def input
}

class MyComputer extends Computer{

  //8.2 使用特质中的抽象字段和实际字段
  size = 13
  var outputSize = 5
  override val maxNumToppins2: Int = 15

  override def play: Unit = println("play")

  override def input: Unit = println("input")
}
