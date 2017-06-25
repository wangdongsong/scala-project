package com.wds.scala.base.obj

/**
  * Created by wangdongsong1229@163.com on 2017/6/19.
  */
case class CasePizza(var name: String, var age: Int){

  override def toString: String = s"name = $name age = $age"

}

object  CasePizza {
  def apply() = new CasePizza("no-name", 0)
  def apply(name: String) = new CasePizza(name, 0)
}

object CasePizzaTest extends App{

  override def main(args: Array[String]): Unit = {
    val cp = CasePizza() //apply
    val cp2 = CasePizza("Pam") // apply(name:String)
    cp.name = "wds"
    println(cp)
    println(cp2)
    println(cp2.name)

    val cp1 = CasePizza("wds", 30) //case class
    println(cp1)
  }
}