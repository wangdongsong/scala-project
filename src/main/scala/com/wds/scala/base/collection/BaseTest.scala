package com.wds.scala.base.collection

/**
  * Created by wangdongsong1229@163.com on 2017/6/27.
  */
object BaseTest {

  def main(args: Array[String]): Unit = {
    
  }

  /**
    * 10.5 创建集合时声明一个类型
    */
  def baseUsing: Unit = {
    val x = List(1, 2, 3, 4)
    val x1 = List(1, 2, 3, 4L)
    val x2 = List[Number](1, 2.0, 33D, 400L)
    val x3 = List[AnyVal](1, 2.0, "str", 400L, 33D)
  }

}
