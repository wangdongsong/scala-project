package com.wds.scala.base.obj

/**
  * 4.3 定义从个辅助构造函数
  *
  * 1、辅助构造函数必须使用this命名创建
  * 2、辅助构造函数必须从调用之前定义的构造函数开始
  * 3、必须有不同的签名
  * 4、一个构造函数通过this调用另一个不同的构造函数
  * Created by wangdongsong1229@163.com on 2017/6/19.
  */
class Pizza(var crustSize: Int, var crustType: String) {

  def this(crustSize: Int){
    this(crustSize, "DEFAULT_CRUST_TYPE")
  }

  def this(crustType: String){
    this(10, crustType)
  }

  def this(){
    this(10, "DEFAULT_CRUST_TYPE")
  }

  override def toString: String = s"A $crustSize inch pizza with a $crustType crust"

}

object PizzaTest {
  def main(args: Array[String]): Unit = {
    val pizza = new Pizza()
    println(pizza)
  }
}
