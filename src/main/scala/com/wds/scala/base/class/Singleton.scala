package com.wds.scala.base.obj

/**
  * 4.4 定义私有的主构造函数
  * Created by wangdongsong1229@163.com on 2017/6/21.
  */
class Singleton private {

  override def toString: String = "This is Singleton"

}

//带有参数的私有构造方法
class Order private (name: String)

/**
  * 通过类的派生对象获取实例
  */
object Singleton {
  private val singleton = new Singleton
  def getInstance = singleton
}

/**
  * 4.5 构造参数的默认值
  * @param timeout
  */
class SocketT(var timeout: Int = 100)

object SingleTonText {

  def main(args: Array[String]): Unit = {
    val singleton = Singleton.getInstance
    println(singleton.toString)

    //有默认值情况下，可以不指定
    val socketT = new SocketT
    println(socketT.timeout)
    val socketT1 = new SocketT(500)
    println(socketT1.timeout)
  }
}

