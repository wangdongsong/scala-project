package com.wds.scala.base.method

/**
  * 5.2 调用父类的方法
  * Created by wangdongsong1229@163.com on 2017/6/24.
  */
object MethodCall {

  def main(args: Array[String]): Unit = {
    val c = new Child
    println(c.printSuper)

    c.update(crustType = "wds", crustSize = 13)

    //println(c.getChildInfo)

    val (name1: String, name2, name3) = c.getChildInfo
    print(name1, name2)

    val result = c.getChildInfo
    println(result._1)

    //可变参数
    c.printAll()
    c.printAll("1", "2", "3")

    //使用_*适配一个序列(Array，List，Seq等）
    val fruit = List("l1", "l2", "l3")
    c.printAll(fruit:_*)
  }

}

trait Human{
  def hello = "the Human trait"
}

trait Mother extends Human{
  override def hello: String = "Mother"
}

trait Father extends Human{
  override def hello: String = "Father"
}

/**
  * 当类继承多个特质，且有同一个方法时可使用super[traitNam].methodName访问
  *
  * 必须通过extends或with关键字扩展才可以使用此办法
  */
class Child extends Mother with Human with Father{
  def printSuper = super.hello
  def printMother = super[Mother].hello
  def printFather = super[Father].hello
  def printHuman = super[Human].hello

  /**
    * 5.3 方法参数默认值，必须使用带括号的方法调用child.dry()
    * 第1个参数无默认值，第二个参数有，可以编译通过
    * 第1个参数有，第二个没有，编译通过，但无法使用参数默认值
    * @param time
    * @param protocol
    */
  def dry(time: Int = 5000, protocol: String = "HTTP") ={
    println("timeout = %d, protocol = %s", time, protocol)
  }

  /**
    * 5.4 调用时使用参数名
    *
    * @param crustSize
    * @param crustType
    * @return
    */
  def update(crustSize: Int, crustType: String) = {
    "A %d inch %s crust Pizza".format(crustSize, crustType)
  }

  /**
    * 5.5 定义一个返回多个值的方法(tuple)
    *
    * 从方法中返回多个值，而不是这些值组成的一个对象
    *
    */
  def getChildInfo = {
    ("wds01", "wds02", "wds03")
  }

  /**
    * 5.7 创建接受变参的方法
    *   可变参数时，可变参数必须是方法签名的最后一个参数，否则无法编译通过
    */
  def printAll(strings: String*): Unit = {
    strings.foreach(print)
  }

  /**
    * 5.8 方法的异常声明
    */
  @throws(classOf[Exception])
  def play(): Unit ={

  }
}
