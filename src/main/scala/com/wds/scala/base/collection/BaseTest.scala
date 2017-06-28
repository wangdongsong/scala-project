package com.wds.scala.base.collection

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wangdongsong1229@163.com on 2017/6/27.
  */
object BaseTest {

  def main(args: Array[String]): Unit = {
    //firstArrayBuffer
    //foreachLoop
    //forLoop
    //zipWithIndexCounter
    //useIterator
    //forYieldConvertCollections
    //mapConvertCollections
    useFlatten
  }

  /**
    * 10.15 展平列表的列表和扁平化问题
    */
  def useFlatten: Unit = {
    val lol = List(List(1, 2), List(3, 4))
    val result = lol.flatten
    result.foreach(print)

    val a = Array(Array(1, 2), Array(3, 4))
    a.flatten.foreach(print)

    val couples = List(List("kim", "al"), List("julia", "terry"))
    couples.flatten.map(_.capitalize).sorted.foreach(print)

    //转成字符输出
    val hello = List("Hello", "World")
    hello.flatten.distinct.foreach(print)
  }

  /**
    * 10.14 用map实现集合的变换
    */
  def mapConvertCollections: Unit = {
    val helper = Vector("adam", "kim", "melissa")
    val caps = helper.map(e => e.toUpperCase)
    val caps1 = helper.map(_.capitalize)
    val names = Array("Fred", "Joe", "Jonathan")
    val lengths = names.map(_.length)

    //集合转XML
    val elems = names.map(name => <li>{name}</li>)
    elems.foreach(print)

    println("HAL".map(plusOne))

  }

  def plusOne(c: Char) = (c.toByte + 1).toChar


  /**
    * 10.13 用for/yield实现集合间的转换
    */
  def forYieldConvertCollections: Unit = {
    val a = Array(1, 2, 3, 4, 5)
    //创建a的副本
    val copyA = for(e <- a) yield e
    val doubleA = for( e <- a) yield e * 2

    //转大写
    val fruits = Vector("a", "abcdefg" , "c", "d")
    val upperFruit = for(e <- fruits) yield  e.toUpperCase

    //产生Tuple2
    val tuple2 = for(i <- 0 until fruits.size) yield (i, fruits(i))
    println(tuple2(0))

    val x = for(e <- fruits if e.length < 6) yield e.toUpperCase()
    println(x(1))
  }

  /**
    * 10.12 迭代器使用
    */
  def useIterator: Unit = {
    val it = Iterator(1, 2, 3)
    it.foreach(print)
    //迭代器已经结束，下行语句不会有任何输出
    it.foreach(println)

  }

  /**
    * 10.11 使用zipWithIndex或zip创建循环计数器
    *
    * 循环一个有序集合，并且能够访问循环计数器
    */
  def zipWithIndexCounter: Unit = {
    val days = Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Staturday")

    //从0开始计数
    days.zipWithIndex.foreach{
      case(day, count) => println(s"$count is $day")
    }

    for((day, count) <- days.zipWithIndex) {
      println(s"$count is $day")
    }

    //zip方式可以控制超始值
    for((day, count) <- days.zip(Stream from 1)) {
      println(s"$count is $day")
    }
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

    //for/yield表达式
    val newFruits2 = for(e <- fruits2) yield e.toUpperCase()
    println(newFruits2(0))

    val newFrutis3 = for(e <- fruits2) yield {
      val upper = e.toUpperCase
      upper
    }
    println(newFrutis3(1))

    //Map中使用for
    val names = Map("fname" -> "wds", "age" -> "21")
    for((k, v) <- names) println(s"key = $k, value = $v")
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
