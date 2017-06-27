package com.wds.scala.base.collection

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wangdongsong1229@163.com on 2017/6/27.
  */
object BaseTest {

  def main(args: Array[String]): Unit = {
    //firstArrayBuffer
    //foreachLoop
    forLoop
  }

  /**
    * 10.10 for循环遍历集合
    * 通过for循环遍历集合中元素，通过for/yield组合使用来从一个已有的集合创建出一个新的集合
    */
  def forLoop: Unit = {
    val fruits = Traversable("apple", "banana", "orange")
    for(f <- fruits) print(f)
    println
    for(f <- fruits) print(f.toUpperCase())
    //多行
    for(f <- fruits){
      val s = f.toUpperCase
      println(s)
    }
    val fruits2 = Array("apple", "banana", "orange")
    //计数器
    for(i <- 0 until fruits.size) println(s"element $i is ${fruits2(i)}")
    for((elem, count) <- fruits2.zipWithIndex){
      println(s"element $count is $elem")
    }

  }

  /**
    * 10.9 foreach循环
    */
  def foreachLoop: Unit = {
    val fruits = Vector(1, 2, 3, 4, 5)
    fruits.foreach(i => println(i))
    fruits.foreach(println(_))
    fruits.foreach(println)
    fruits.foreach((i: Int) => print(i))

  }

  /**
    * 10.8 ArrayBuffer
    * 可变集合首选ArrayBuffer
    *
    * ArrayBuffer是一个索引序列集合，如果想用一个可变的线性序列集合，就使用ListBuffer
    */
  def firstArrayBuffer: Unit ={
    var furit = ArrayBuffer[String]()
    var nums = ArrayBuffer(1, 2, 3)
    nums += 4
    nums ++= List(5, 6, 7, 8, 9, 10)
    println(nums)
    nums -= (7, 8)
    println(nums)
    nums --= List(9, 10)
    println(nums)
  }

  /**
    * Vector为不可变序列第1位
    *
    */
  def firstVector: Unit = {
    var sister = Vector("wds01", "wds02", "wds03")
    //会产生一相新的Vector变量
    sister = sister :+ "wds04"
  }



  /**
    * 10.5 创建集合时声明一个类型
    */
  def baseUsing: Unit = {
    val x = List(1, 2, 3, 4)
    val x1 = List(1, 2, 3, 4L)
    val x2 = List[Number](1, 2.0, 33D, 400L)
    val x3 = List[AnyVal](1, 2.0, 400L, 33D)
  }

}
