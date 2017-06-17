package com.wds.scala.base

/**
  * 数值对象
  * Created by wangdongsong1229@163.com on 2017/6/17.
  */
object NumberTest {

  def main(args: Array[String]): Unit = {
    strToNum()
  }

  /**
    * 2.1 从字符串到数值
    */
  def strToNum() = {
    println("100".toInt(10))
    println("100".toDouble)
    println("100".toFloat)
    println("1".toShort)
    println("1".toByte)
    println(BigInt(1))
    println(BigDecimal(3.14159))

    //处理基数和根
    //通过parseInt处理十进制以外的数据
    println(Integer.parseInt("10", 2))
    println(Integer.parseInt("10", 8))
    println(Integer.parseInt("15", 16))

    //通过隐式转换的方式
    implicit class StringToInt(s: String){
      def toInt(radix: Int) = Integer.parseInt(s, radix)
    }
    println("15".toInt(16))
  }
}


