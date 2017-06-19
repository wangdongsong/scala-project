package com.wds.scala.base.obj

/**
  * 4.1 为一个类创建一个主构造方法
  *
  * 1、如果一个字段被声明为var，Scala会为该字段生成getter和setter方法
  * 2、如果字段为val，Scala只会生成getter方法
  * 3、如果一个字段无val、var，不会生成getter和setter方法
  * 4、var和val字段可以被private修饰，防止生成getter和setter方法
  *
  * Created by wangdongsong1229@163.com on 2017/6/19.
  */
class Person(var firname: String, var lastName: String) {
  println("the constructor begins")

  //HOME不可变
  private val HOME = System.getProperty("user.home")
  var age = 0

  override def toString: String = s"$firname $lastName is $age years old"

  def printHome {println(s"HOME = $HOME")}

  def printFullName { println(this) }

  printHome
  printFullName
  println("still is the constructor")

}
