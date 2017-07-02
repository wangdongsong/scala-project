package com.wds.scala.base.collection

/**
  * 11章 列表、映射、集
  * Created by wangdongsong1229@163.com on 2017/7/2.
  */
object ListTest {

  def main(args: Array[String]): Unit = {
    fillList
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
