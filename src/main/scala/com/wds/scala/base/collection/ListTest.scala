package com.wds.scala.base.collection

import scala.collection.{SortedMap, mutable}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.util.Sorting

/**
  * 11章 列表、映射、集
  * Created by wangdongsong1229@163.com on 2017/7/2.
  */
object ListTest {

  def main(args: Array[String]): Unit = {
    //fillList
    //mutableList
    //addElemList
    //removeList
    //mergeUnionList
    //listLazyStream
    //createUpdateArray
    //createArrayBuffer
    //removeArray
    //arraySort
    //dimArray
    //createMapping
    //selectMap
    //updateMap
    loopMap
  }

  /**
    * 11.17 遍历映射
    */
  def loopMap: Unit = {
    val ratings = Map("Lady in the Water" -> 3.0, "Snakes on a Plane" -> 4.0, "You, Me and Dupree" -> 3.5)
    for((k, v) <- ratings) println(s"key: $k, value: $v")

    ratings.foreach(x => println(s"key: ${x._1}, value: ${x._2}"))

    ratings.foreach{
      case(k, v) => println(s"key: $k, value: $v")
    }

    ratings.keys.foreach((key) => println(key))

    var r = collection.mutable.Map("Lady in the Water" -> 3.0, "Snakes on a Plane" -> 4.0, "You, Me and Dupree" -> 3.5)
    var y = r.mapValues(_.+(1.0))
    y.foreach(x => println(s"key: ${x._1}, value: ${x._2}"))

  }

  /**
    * 11.16 访问映射的值
    */
  def readMap: Unit ={
    val states = Map("AL" -> "Alabama", "AK" -> "Alaska", "AZ" -> "Arizona")
    val za = states("AZ")
    //访问不存的key会报错
    //val s = states("FOO")
    val states2 = Map("AL" -> "Alabama").withDefaultValue("Not Found")
    val s2 = states2("Foot")
    println(s2)

    val s3 = states.getOrElse("FOO", "Nu Such state")
    println(s3)

    val az = states.get("AZ")
    println(az.get)
  }

  /**
    * 11.14 为可变映射添加、更新或删除元素
    *
    * +=添加元素
    * -=或--=删除元素
    */
  def updateMap: Unit ={
    var states = collection.mutable.Map[String,String]()
    states("AK") = "Alaska"
    states += ("AL" -> "Alabama")
    states += ("AR" -> "Arkansas", "AZ" -> "Arizona")
    states ++= List("CA" -> "California", "CO" -> "Colorado")

    states -= "AR"
    states -= ("AR", "AZ")
    states --= List("AR", "AZ")

    states("AK") = "Alaska, Areally Big State"

    states.put("CO2", "Colorado2")
    states.remove("CO2")
    states.clear()
  }

  /**
    * 11.13 选择一种Map实现
    */
  def selectMap: Unit = {
    //SortedMap
    val grades = SortedMap("Kim" -> 90, "Al" -> 85, "Melissa" -> 95, "Hannah" -> 92)
    for (elem <- grades) {println(s"${elem._1}, ${elem._2}")}
    //记住插入顺序的LinkedHashMap
    var states = mutable.LinkedHashMap("TL" -> "Tllions")
    states += ("Ky" -> "Kentucky")
    states += ("Tx" -> "Texas")
    for (elem <- states) {println(s"${elem._1}, ${elem._2}")}
  }

  /**
    * 11.12 创建映射
    *
    * Map不可变映射
    *
    */
  def createMapping: Unit = {
    val states = Map("AL" -> "Alabama", "Ak" -> "Alaska")
    var mutableMap = collection.mutable.Map("AL" -> "Alabama")
    mutableMap += ("Ak" -> "Alaska")

    for ((k, v) <- states) {
      println(s"$k, $v")
    }
  }

  /**
    * 11.11 创建多维数组
    *
    * (1) Array.ofDim创建多维数据，最多创建五维数组
    * (2) 按需创建数组的数组
    */
  def dimArray: Unit ={
    val rows = 2
    val cols = 3

    val a = Array.ofDim[String](rows, cols)
    println(a(0)(0)) //null

    for {
      i <- 0 until rows
      j <- 0 until cols
    } println(s"($i)($j) == ${a(i)(j)}")

    val x, y, z = 10
    val b = Array.ofDim[Int](x, y, z)


    val c = Array(Array("a", "b", "c"), Array("d", "e", "f"))
    println(c(0))

  }

  /**
    * 11.10 数组排序
    *
    * 可通过String的隐式排序实现，如果Array不是隐式排序，可以通过混入Ordered物质获取隐式排序能力
    *
    */
  def arraySort: Unit = {
    val fruits = Array("cherry", "apple", "banana")
    Sorting.quickSort(fruits)
    fruits.foreach(println)
  }

  /**
    * 10.9 删除Array和ArrayBuffer的元素
    *
    * 使用-=、--=、remove和clear删除元素
    *
    */
  def removeArray: Unit = {
    val x = ArrayBuffer("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n")
    x -= "a"
    x -= ("a", "c")
    x --= Seq("b", "d")
    x --= Array("d", "e")
    x --= Set("e", "f")
    x.remove(0)
    x.remove(0, 2)
    x.foreach(print)

    //Array不可变，需要重新赋值给新变量
    val y = Array("a", "b", "c", "d")
    val z = y.filter(_.contains("c"))
    z.foreach(print)

  }

  /**
    * 11.8 创建大小可变的数组
    *
    * Array是可变的，因为它内容可变，但其大小不能改变。创建一个内容、大小都可变的索引序列，可以使用ArrayBuffer类
    */
  def createArrayBuffer: Unit = {
    var characters = ArrayBuffer[String]()
    characters += "Ben"
    characters += "Jerry"
    characters += "Dale"

    val a = ArrayBuffer("Ben", "Jerry")
    a += "Dale"
    a += ("Gordon", "Harry")
    a ++= Seq("Andy", "Big Ed")
    a.append("Laura", "Lucy")

  }

  /**
    * 11.7 创建或更新数组的不同方式
    */
  def createUpdateArray: Unit ={
    val a = Array(1, 2, 3)
    val fruits = Array("apple", "banana", "Orange")
    val x = Array(1, 20D, 2.0, 400L)
    val y = Array[Number](1, 2.0, 33D, 400L)

    val z = new Array[String](3)
    fruits(0) = "apple"
    fruits(1) = "banana"
    fruits(2) = "orange"

    val b = Array.range(1, 10)
    val c = Array(0, 10, 2)
    val d = Array.fill(3)("foo")
    val e = Array.tabulate(5)(n => n * n)
    e.foreach(print)
    println
    val f = List(1, 2, 3).toArray
    "Hello".toArray.foreach(print)


  }

  /**
    * 11.6 List的惰性版本Stream
    *
    * Stream通过#::构造，以Stream.empty结尾
    */
  def listLazyStream: Unit = {
    val stream = 1 #:: 2 #:: 3 #:: Stream.empty
    //如果是List，创建很大列表，内在溢出
    val stream1 = (1 to 100000000).toStream
    println(stream1.head)
    //输出?表示惰性集合的结尾尚未执行的方式
    println(stream1.tail)

    //延迟计算
    stream1.take(3)
    stream1.filter(_ < 200)
    stream1.map(_ * 2)
    stream1.filter( _ > 200)

  }

  /**
    * 11.5 合并或连接列表
    *
    * 合并或连接两个列表的内容
    */
  def mergeUnionList: Unit = {
    val a = List(1, 2, 3)
    val b = List(4, 5, 6)

    val c = a ++ b
    val d = a ::: b
    val e = List.concat(a, b)

  }

  /**
    * 11.4 从List（或ListBuffer）中删除元素
    *
    * List为不可变元素，不能从中删除元素，但是可以过滤掉不想要的元素，然后将结果给新变量
    */
  def removeList: Unit = {
    //List
    val originalList = List(1, 2, 3, 4, 5)
    val newList = originalList.filter(_ > 2)
    newList.foreach(print)

    println

    //ListBuffer
    val x = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8)
    x -= 5
    x -= (2, 3)
    x.remove(1)
    x.remove(1, 2)
    x.foreach(print)
  }

  /**
    * 11.3 为List添加元素
    *
    * 因为List是不可变的，不能添加新的元素，如果经常变化建议使用ListBuffer。
    *
    * 使用List时，通常的做法是用::方法在列表前面添加元素，然后将结果赋给一个新的List
    *
    */
  def addElemList: Unit = {
    var x = List(1, 2)
    val y = 0 :: x
    val z = y :+ 3
    z.foreach(print)
  }

  /**
    * 11.2 创建可变List
    *
    * List是不可变的，如果创建要经常改变的列表，推荐使用ListBuffer，需要使用List时，转为List
    */
  def mutableList: Unit ={
    var fruits = new ListBuffer[String]()

    fruits += "apple"
    fruits += "banana"
    fruits += "Orange"
    fruits += ("Strawberry", "Kiwi", "Pineapple")

    fruits.foreach(print)

    fruits -= "apple"
    fruits -= ("banana", "Kiwi")

    fruits.foreach(print)
  }

  /**
    * 11.1 创建和填充列表的不同中方式
    */
  def fillList: Unit = {
    val list = 1 :: 2 :: 3 :: Nil
    val list1 = List(1, 2, 3)
    val list2 = List(1, 2.0, 33D, 4000L)
    val list3 = List[Number](1, 2.0, 33D, 4000L)
    val x = List.range(1,  20)
    val y = List.range(0, 10, 2)
    val z = List.fill(3)("foo")
    val a = List.tabulate(5)(n => n * n)
    val b = collection.mutable.ListBuffer(1, 2, 3).toList
    val c = "foo".toList
  }

}
