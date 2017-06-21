package com.wds.scala.base.obj

/**
  * 4.8 将代码块或者函数赋给字段
  *
  *  问题：用代码块或者调用函数给类里面的字段初始化赋值
  *  解决办法：将字段设置为函数或期望的代码块，如果算法运行比较长，可选择性的加lazy
  * Created by wangdongsong1229@163.com on 2017/6/22.
  */
class ObjFieldFunction {

  //在构造方法中，类初始化时执行
  val text = {
    var lines = ""
    try{
      lines = io.Source.fromFile("E:/javaTest/stock.txt").getLines.mkString
    } catch {
      case e: Exception => lines = "Error happened"
    }
    lines
  }

  //lazy加载，初始化过程中不会调用
  lazy val lazyText = {
    var lines = ""
    try{
      lines = io.Source.fromFile("E:/javaTest/test.png").getLines.mkString
    } catch {
      case e: Exception => lines = "Error happened"
    }
    lines
  }

  println(text)
}

object Test{
  def main(args: Array[String]): Unit = {
    val objFF = new ObjFieldFunction
    //println(objFF.text)
    println(objFF.lazyText)
  }
}
