package com.wds.scala.base.obj

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
    javaClass
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

}


