package com.wds.scala.base.obj

/**
  * 6.9 使用apply方法实现工作方法
  * Created by wangdongsong1229@163.com on 2017/6/25.
  */
object FatoryMethod {
  def main(args: Array[String]): Unit = {
    val cat = Animal("dog")
    cat.speak
  }
}

trait Animal{
  def speak
}

object Animal{

  def apply(s: String): Animal = {
    if (s == "dog") new Dog
    else new Cat
  }

  private class Dog extends Animal{
    override def speak: Unit = println("woof")
  }

  private class Cat extends Animal{
    override def speak: Unit = println("meow")
  }

}
