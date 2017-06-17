package com.wds.scala.base

import scala.util.Random

/**
  * 数值对象
  * Created by wangdongsong1229@163.com on 2017/6/17.
  */
object NumberTest {

  def main(args: Array[String]): Unit = {
    //strToNum()
    //typeConvert
    //overrideNum
    //numOperation
    //floatCompare
    //computeBigNum
    //generateRandom
    //numRange
    formatNum
  }

  def formatNum = {
    val pi = scala.math.Pi
    println(pi)
    println(f"$pi%1.5f")
    println(f"$pi%3.2f".format(pi))
  }

  /**
    * 2.8 数值区间、列表或数组
    */
  def numRange = {
    var r = 1 to 10
    r.foreach(println)

    var step = 1 to 10 by 2
    step.foreach(println)

    for (i <- 1 to 5 ) println(i)

    for (i <- 1 until 5) println(i)

    var array = (1 to 10).toArray
    println(array.getClass.getName)
    var list = (1 to 10).toList
    println(list.getClass.getName)
  }

  /**
    * 2.7 生成随机数
    */
  def generateRandom = {
    var r = Random
    println(r.nextInt())
    println(r.nextFloat())
    println(r.nextDouble())

    for (i <- 0 to r.nextInt(10)) yield println(i * 2)

    for (i <- 0 to 5) yield println(r.nextInt(100))
  }

  /**
    * 2.6 处理大数
    */
  def computeBigNum = {
    var b = BigInt("123456789012345");
    b += b;
    b *= b
    print(b)
  }

  /**
    * 2.5 浮点数据比较
    */
  def floatCompare = {
    val a = 0.3
    val b = 0.1 + 0.2
    println(b)
    println(a == b)
    println(~=(a, b, 0.0001))
  }

  /**
    *
    * @param x
    * @param y
    * @param precision
    */
  def ~= (x: Double, y: Double, precision: Double) = {
    if ((x - y).abs < precision) true else false
  }

  /**
    * 2.4 替代++和--
    */
  def numOperation = {
    var a = 1
    a += 1
    a -= 1
    println(a)
  }

  /**
    * 2.3 对数值类型重载
    */
  def overrideNum = {
    val a = 1
    val b = 1d
    val c = 1f
    val d = 1000L

    val e = 1: Byte
    val f = 1: Int

    println(a , b, c, d, e, f)
  }

  /**
    * 2.2 数值类型转换
    */
  def typeConvert ={
    println(19.45.toInt)
    println(19.toFloat)
    println(19.toLong)

    //如果避免类型转换错误，可以先判断
    val a = 1000L
    println(a.isValidByte)
    println(a.isValidShort)
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

    /**
      * 异常处理
      */
    println(toInt("10").getOrElse(0))
    println(toInt("abc").getOrElse(0))
    //方案3 模式匹配
    var result = toInt("10") match {
      case Some(x) => x
      case None => 0
    }
    println(result)
  }

  /**
    * 方案1，异常处理
    * @param s
    * @throws java.lang.NumberFormatException
    * @return
    */
  @throws(classOf[NumberFormatException])
  def toIntException(s: String) = s.toInt

  /**
    * 方案2：异常处理
    * Java中如果将String转数值会出现检查异常NumberFormatException。Scala中没有，
    */
  def toInt(s: String): Option[Int] = {
    try{
      Some(s.toInt)
    }catch{
      case e: NumberFormatException => None
    }
  }

}


