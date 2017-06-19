package com.wds.scala.base.obj

/**
  * case类中的构造函数参数默认是val
  * Created by wangdongsong1229@163.com on 2017/6/19.
  */
case class CasePerson(name: String) {

  override def toString: String = s"name is $name"

  println("still in caseperson contructor")
}
