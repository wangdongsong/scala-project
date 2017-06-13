package com.wds.scala.base;

/**
 * Created by wangdongsong1229@163.com on 2017/6/12.
 */
object StringTest {

  def main(args: Array[String]): Unit = {
    baseExercise()
  }

  def baseExercise(): Unit = {
    println("Hello World".getClass.getName)

    val s = "Hello, world"
    println(s.length)

    val s1 = "Hello" + ", world"

    "hello".foreach(println)

    for (c <- "world") println(c)

    s.getBytes().foreach(println)


    val result = "Hello world".filter(_ != 'l')
    println(result)

    println("scala".drop(2).take(2).capitalize)

    //字符串相等
    val s2 = "hello"
    val s3 = "hello"
    val s4 = "h" + "ello"
    println(s2 == s3)
    println(s3 == s4)

    //创建多个字符串
    var foo =
      """This is a
        |multiline String
      """.stripMargin
    println(foo)
    foo =
      """This is a one
        multiline String
      """
    println(foo)

    foo =
      """This is a one
        #multiline String
      """.stripMargin('#')
    println(foo)

    val test =
      """This is a one
        |multiline String
        |three multiline String
      """.stripMargin.replaceAll("\n", " ")
    println(test.length)
    //println(test)
    //println(test.charAt(1))

    //1.4分隔字符串
    val array:Array[String] = "hello world".split(" ")
    println(array(0))
    "hello world".split(" ").foreach(println)

    val str = "egg, milk, butter, Coco Puffs"
    val sArray:Array[String] = str.split(",")
    sArray.foreach(println)
    str.split(",").map(_.trim).foreach(println)

    //字符串的变量代换
    //s和f插入法
    val name = "Fred"
    val age = 33
    val weight = 200.00
    println(s"$name is $age years old, and weights $weight pounds")
    println(s"Aage next year: ${age + 1}")
    println(s"You are 33 years old:${age == 33}")
    //保留两位有效数字
    println(f"$name is $age years old, and weight $weight%.2f pounds")
    //不保留有效数字
    println(f"$name is $age years old, and weight $weight%.0f pounds")
    //raw插入符
    println(s"foo\nbar")
    println(raw"foo\nbar")
    //format方法
    val formatMsg = "%s is %d years old"
    println(formatMsg.format(name, age))

    //1.5挨个处理字符吕中的字符
    //遍历字符串的第一个字符，并对字符做处理
    var upper = "hello, world".map(c => c.toUpper)
    println(upper)
    upper = "hello, java".map(_.toUpper)
    println(upper)
    upper = "hello, world".filter(_ != 'l').map(_.toUpper)
    println(upper)
    val toLower = (c: Char) => (c.toByte + 32).toChar
    println("HELLO".map(toLower))
    println("HELLO".map(toLowerMethod))
  }

  def toLowerMethod(c: Char) : Char ={
    (c.toByte + 32).toChar
  }

}
