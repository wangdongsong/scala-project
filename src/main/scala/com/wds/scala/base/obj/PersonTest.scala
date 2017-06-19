package com.wds.scala.base.obj

/**
  * Created by wangdongsong1229@163.com on 2017/6/19.
  */
object PersonTest {

  def main(args: Array[String]): Unit = {
    val p = new Person("Adam", "Meyer")
    println(p)

    println("------")
    p.firname = "wds"
    p.lastName = "wang"
    println(p, p.firname)

    val caseP = CasePerson("Lance")
    println(caseP)
  }
}
