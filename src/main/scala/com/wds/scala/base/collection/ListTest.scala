package com.wds.scala.base.collection

import scala.collection.mutable.ListBuffer

/**
  * 11章 列表、映射、集
  * Created by wangdongsong1229@163.com on 2017/7/2.
  */
object ListTest {

  def main(args: Array[String]): Unit = {
    //fillList
    mutableList
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
