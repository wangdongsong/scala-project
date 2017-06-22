package com.wds.scala.base.obj

import scala.collection.mutable.ArrayBuffer

/**
  * 4.10 继承类时处理构造函数参数
  *
  * 问题：继承一个基类，并且需要处理定义在基类中的构造函数的参数及子类中的新参数
  *
  * 4.12 以下两种场景使用抽象类
  *   1、需要创建一个有构造函数参数的基类
  *   2、需要被Java调用
  *
  * Created by wangdongsong1229@163.com on 2017/6/22.
  */
object ExtendsClass {

  def main(args: Array[String]): Unit = {
    val employee = new Employee("wds", "sz", 21)
    println(employee.age)

    employee.things.foreach(println)
  }

}

/**
  * 基类
  * @param name
  * @param address
  */
class  ParentPerson(var name:String, var address:String){

  def this(name: String){
    this(name, "sz")
  }

  def canEquals(that: ParentPerson) = {that.isInstanceOf[ParentPerson]}

  override def equals(that: Any): Boolean = that match {
    case that: ParentPerson => that.canEquals(this) && this.hashCode == that.hashCode
    case _ => false
  }

  override def hashCode(): Int = 0

  override def toString: String = if (address == null) name else s"$name @ $address"
}

class Employee (name: String, address: String, var age: Int) extends ParentPerson(name, address){

  /**
    * 4.16 内部类，不能被外部访问，若要访问就定义API
    *
    */
  case class InnerScalaClass(name: String)

  var things = new ArrayBuffer[InnerScalaClass]()
  things += InnerScalaClass("1")
  things += InnerScalaClass("2")

  def this(name: String){
    this(name, "sz", 23)
  }

}

/**
  * 4.13 在抽象类或特质里定义属性
  * @param name
  */
abstract class Pet(name: String){
  val greeting: String
  var age: Int
  def sayHello {
    println(greeting)
  }

  override def toString: String = s"I say $greeting, and I'm $age"
}

class Dog(name: String) extends Pet(name){
  val greeting = "Woof"
  var age = 2
}

class Cat(name: String) extends Pet(name){
  val greeting = "Meow"
  var age = 5
}
