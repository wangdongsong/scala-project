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


