package com.wds.scala.base.method

/**
  * 1.9 支持链式编码风格
  *  1、如果类支持扩展，则把this.type作为链式风格方法的返回值类型
  *  2、如果不支持扩展，则把this从链式调用方法中返回
  * Created by wangdongsong1229@163.com on 2017/6/24.
  */
object MethodChain {

  def main(args: Array[String]): Unit = {
    val p = new Person
    val p2 = p.setFirstName("wdsF").setLastName("wdsL").setRole("role").setMiddle("middle")
    println(p2.getClass.getName)
    println(p.getClass.getName)
    println(p)
  }
}

class Humain2 {
  protected var fname = ""
  protected var lname = ""
  protected var middle = ""

  def setFirstName(firstName: String): this.type = {
    this.fname = firstName;
    this
  }

  def setLastName(lastName: String): this.type = {
    this.lname = lastName
    this
  }

  def setMiddle(middle: String) = {
    this.middle = middle
    this
  }
}

class Person extends Humain2{
  protected var role = ""

  def setRole(role: String): this.type = {
    this.role = role
    this
  }

  override def toString: String = "%s %s %s %s".format(fname, lname, role, middle)
}
