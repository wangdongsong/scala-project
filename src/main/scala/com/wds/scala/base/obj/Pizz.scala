package com.wds.scala.base.obj

/**
  * 6.6 用伴生对象创建静态成员
  * Created by wangdongsong1229@163.com on 2017/6/25.
  */
class Pizz(var crustType: String) {
  override def toString: String = "Crust type is " + crustType
}

object Pizz {
  val CRUST_TYPE_THIN = "thin"
  var CRUST_TYPE_THICK = "thick"
  def getFoo = "Foo"
}

object pizzTest {
  def main(args: Array[String]): Unit = {
    println(Pizz.CRUST_TYPE_THICK)
  }
}
