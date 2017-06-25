package com.wds.scala.base.obj

import scala.xml

/**
  * 6 对象
  *
  * Created by wangdongsong1229@163.com on 2017/6/25.
  */
class ObjClass {

}

object Obj{

  def main(args: Array[String]): Unit = {

    //objectCast
    //javaClass
    objClass(1, 2, 3)
  }

  /**
    * 6.1 对象强制转换
    */
  def objectCast={
    //6.1 对象强制转换
    val num1 = 1
    println(num1.getClass)
    val num2 = num1.asInstanceOf[Long]
    println(num2.getClass)
  }

  /**
    * 6.2 等价于JavaClass
    */
  def javaClass = {
    val stringClass = classOf[String]
    println(stringClass)
  }

  /**
    * 6.3 确定对象所属的类
    */
  def objClass(numbers: Int*) = {
    println("class " + numbers.getClass)
    //println(printClass(numbers))

    val hello = <p>Hello, world</p>
    println(hello.getClass)
    hello.child.foreach(e =>printClass(e))
  }

  def printClass(c: Any) = println(c.getClass)

}


