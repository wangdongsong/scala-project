package com.wds.scala.base.collection

import scala.collection.mutable.ArrayBuffer

/**
  * Created by wangdongsong1229@163.com on 2017/6/27.
  */
object BaseTest {

  def main(args: Array[String]): Unit = {
    //firstArrayBuffer
    //foreachLoop
    //forLoop
    //zipWithIndexCounter
    //useIterator
    //forYieldConvertCollections
    //mapConvertCollections
    //useFlatten
    //useMapFlattenAndFlatMap
    //filterMap
    //extractCollection
    //seqPartition
    //loopCollectionByReduceAndFold
    //extraceDistinctEleme
    //mergeCollection
    //mergeWithZip
    //collectionLazyView
    //rangeCollection
    //useTuple
    //collectionSort
    convertToString
  }

  /**
    * 10.29 将集合转换为字符串
    */
  def convertToString: Unit = {
    val a = Array("apple", "banana", "cherry")
    val str = a.mkString
    print(str)
    print(a.mkString(","))
    val b = Array("abc", "efg")
    print(Array(a, b).flatten.mkString)
  }

  /**
    * 10.28 集合排序
    */
  def collectionSort: Unit = {
    List(1, 5, 8, 10, 3, 7).sortWith(_ > _).foreach(print)
    List("abc", "efght", "a", "cd").sortWith(_.length > _.length).foreach(print)
  }

  /**
    * 10.27 当需要一堆元素时使用元组
    */
  def useTuple: Unit = {
    val d = ("Debi", 95)
    print(d._1)
  }



  /**
    * 10.26 创建并使用枚举
    */
  object Margin extends Enumeration {
    def createEmum: Unit = {
      type Margin = Value
      val TOP, BOTTOM, LEFT, RIGHT = Value
    }
  }

  /**
    * 10.25 利用Range利用集合
    *
    * 用Range生成List、Array、Vector或其它序列
    *
    */
  def rangeCollection: Unit ={
    val arraysInt = Array.range(1, 5)
    arraysInt.foreach(print)
    println()
    List.range(0, 10).foreach(print)
    println()
    Vector.range(0, 10, 2).foreach(print)
    println()
    val a = (0 until 10).toArray
    val listB: List[Int] = 1 to 10 by 2 toList

  }

  /**
    * 10.24 在集合上创建一个惰性视图
    */
  def collectionLazyView: Unit ={
    val view = (1 to 100).view
    println(view.force)
    view.foreach(print)
    (1 to 10).map(_ * 2)
  }



  /**
    * 10.23 用zip将两个序列集合合并为一对
    *
    * 两个序列集合的数据合并为一个键值对的集合
    */
  def mergeWithZip: Unit = {
    val women = List("Wilma", "Betty")
    val men = List("Fred", "Barney")

    val couples = women zip men
    couples.foreach((t) => println(t._1, t._2))
    for ((wife, husband) <- couples) {
      print(wife, husband)
      println()
    }
    //couples.foreach((wife, husband) =>)

    val couplesMap = couples.toMap
    couplesMap.foreach((t) => {
      print(t._1, t._2)
    })

    for ((key, value) <- couplesMap) {println(key, value)}

    couplesMap.keySet.foreach( (t) => {
      print(t, couplesMap(t))
      println()
    })

    couplesMap.foreach{ case (m, n) => (println(s"$m, $n"))}

    println()
    val products = Array(1, 3, 5)
    val products2 = Array(2)
    val doublePro = products zip products2
    for (elem <- doublePro) {print(elem)}
  }

  /**
    * 10.22 合并序列集合
    *
    * 将两个序列合并为一个序列，同时保留所有的原始元素，找到共同的元素，或者找到这个序列的不相同的元素
    */
  def mergeCollection: Unit ={
    //++=方法把一个序列合并为一个可变序列
    val a = collection.mutable.ArrayBuffer(1, 2, 3)
    a ++= Seq(4, 5, 6)
    a.foreach(print)

    //++合并两个可变或不可变序列
    val b = Array(1, 2, 3)
    val c = Array(4, 5, 6)
    val d = b ++ c
    d.foreach(print)

    val e = Array(1, 2, 3, 4, 5)
    val f = Array(4, 5, 6, 7, 8)
    //共同元素
    val g = e.intersect(f)
    g.foreach(print)
    //合并
    val h = e.union(f)
    h.foreach(print)
    //去重
    val i = e.union(f).distinct
    i.foreach(print)
    //补集
    val j = e diff f
    j.foreach(print)
    val k = f diff e
    k.foreach(print)
    Array.concat(e, f)

    //:::将一个列表的元素放到另一个列表中
    val l = List(1, 2, 3, 4)
    val m = List(4, 5, 6, 7)
    val n = l ::: m
    n.foreach(print)

    val o = Array(1, 2, 3, 11, 4, 12, 4, 5)
    val p = Array(6, 7, 4, 5)
    val q = o.toSet diff p.toSet
    //等价于
    val s = o.toSet -- p.toSet
    s.foreach(print)
    q.foreach(print)
    val r = p.toSet diff o.toSet
    r.foreach(print)

    val all = o ++ p
    all.foreach(print)


  }

  /**
    * 10.21 从序列中提取不重复的元素
    */
  def extraceDistinctEleme: Unit = {
    val x = Vector(1, 1, 2, 3, 3, 4)
    val y = x.distinct
    println(y)
    val z = x.toSet
    println(z)

    val p1 = new CollPerson("Dale", "Copper")
    val p2 = new CollPerson("Dale", "Copper")
    val p3 = new CollPerson("Ed", "Hurley")

    val list = List(p1, p2, p3)
    list.foreach(println)
    val distinceList = list.distinct
    distinceList.foreach(println)

  }

  /**
    * 10.20 用reduce和fold方法遍历集合
    */
  def loopCollectionByReduceAndFold: Unit = {
    val a = Array(12, 6, 15, 2, 20, 9)
    println(a.reduceLeft(_ + _))

    //reduceLeft的示例
    val findMax = (x: Int, y: Int) => {
      val winner = x max y
      println(s"compared $x to $y, $winner was larger")
      winner
    }
    a.reduceLeft(findMax)

    val peeps = Vector("al", "hannah", "emily", "christina", "aleka")
    peeps.reduceLeft((x, y) => if(x.length > y.length) x else y)

    println(a.foldLeft(10)(_ + _))
  }


  /**
    * 10.19 序列的分隔
    *
    * groupBy partition span splitAt sliding unzip
    */
  def seqPartition: Unit = {
    val x = List(15, 10, 5, 8, 20, 12)
    val y = x.groupBy(_ > 10)
    println(y)
    val ytrues = y(true)
    val yfalse = y(false)
    print(ytrues)

    println()
    val z = x.partition(_ > 10)
    println(z)
    val i = x.span(_ < 20)
    println(i)
    val k = x.splitAt(2)
    println(k)

    val nums = (1 to 5).toArray
    val numsSliding = nums.sliding(2).toList
    println(numsSliding)
    //size=2 step=2
    val numsSliding2 = nums.sliding(2, 2).toList
    //size=2 step=3
    nums.sliding(2, 3).toList

    //unzip
    val listOfTuple2s = List((1, 2), ("a", "b"))
    val listOfTuple3s = listOfTuple2s.unzip
    println(listOfTuple3s)

  }

  /**
    * 10.18 从集合中提取元素
    */
  def extractCollection: Unit = {
    val x = (1 to 10).toArray
    //drop头3个元素
    val y = x.drop(3)
    //dropWhile去掉谓词为真的元素
    val z = x.dropWhile( _ < 6)
  }

  /**
    * 10.17 用filter过滤一个集合
    * filter保留条件为true的元素并生成新的集合，原集合会保持不变
    */
  def filterMap: Unit = {
    val x = List.range(1, 10)
    //单一条件，返回true或false
    val even = x.filter(_ % 2 == 0)

    val fruits = Set("orange", "peach", "apple", "banana")
    val f1 = fruits.filter(_.startsWith("a"))
    val f2 = fruits.filter(_.length > 5)

    //复杂条件
    val list2 = "apple" :: "banana" :: 1 :: 2 :: Nil
    //也可以封装成简单算法
    val strings = list2.filter{
      case s: String => true
      case _ => false
    }
    val strings2  = list2.filter(onlyString)
  }

  def onlyString (s: Any) = s match{
    case s: String => true
    case _ => false
  }

  /**
    * 10.16 map、flatten、flatMap组合
    *
    * flatMap的使用场景
    *   1、使用map方法（或yield/for表达式）根据一个已有的集合创建一个新集合
    *   2、结果是一个列表的列表
    *   3、可以在map(或yield/for表达式）后立刻使用flatten
    *  上述情况下可使用flatMap，其等价于map->flatten的组合操作
    */
  def useMapFlattenAndFlatMap: Unit ={

    //计算列表中的数字之和
    val bag = List("1", "4", "3", "three", "one", "one hundred")
    //先定义一个字符串到数字的转换函数
    println(bag.flatMap(strToInt).sum)
    //如何理解上述代码
    bag.map(strToInt) //生成List(Some(1), Some(4), Some(3), None, None, None)
    bag.map(strToInt).flatten //生成List(1, 4, 3)
    bag.map(strToInt).flatten.sum //等价于bag.flatMap(strToInt).sum

    bag.flatMap(strToInt).filter(_ > 1)
    bag.flatMap(strToInt).takeWhile(_ < 4)
    bag.flatMap(strToInt).partition(_ > 3)
  }

  def strToInt(in: String): Option[Int] = {
    try{
      Some(Integer.parseInt(in))
    } catch {
      case e: Exception => None
    }
  }

  /**
    * 10.15 展平列表的列表和扁平化问题
    */
  def useFlatten: Unit = {
    val lol = List(List(1, 2), List(3, 4))
    val result = lol.flatten
    result.foreach(print)

    val a = Array(Array(1, 2), Array(3, 4))
    a.flatten.foreach(print)

    val couples = List(List("kim", "al"), List("julia", "terry"))
    couples.flatten.map(_.capitalize).sorted.foreach(print)

    //转成字符输出
    val hello = List("Hello", "World")
    hello.flatten.distinct.foreach(print)
  }

  /**
    * 10.14 用map实现集合的变换
    */
  def mapConvertCollections: Unit = {
    val helper = Vector("adam", "kim", "melissa")
    val caps = helper.map(e => e.toUpperCase)
    val caps1 = helper.map(_.capitalize)
    val names = Array("Fred", "Joe", "Jonathan")
    val lengths = names.map(_.length)

    //集合转XML
    val elems = names.map(name => <li>{name}</li>)
    elems.foreach(print)

    println("HAL".map(plusOne))

  }

  def plusOne(c: Char) = (c.toByte + 1).toChar


  /**
    * 10.13 用for/yield实现集合间的转换
    */
  def forYieldConvertCollections: Unit = {
    val a = Array(1, 2, 3, 4, 5)
    //创建a的副本
    val copyA = for(e <- a) yield e
    val doubleA = for( e <- a) yield e * 2

    //转大写
    val fruits = Vector("a", "abcdefg" , "c", "d")
    val upperFruit = for(e <- fruits) yield  e.toUpperCase

    //产生Tuple2
    val tuple2 = for(i <- 0 until fruits.size) yield (i, fruits(i))
    println(tuple2(0))

    val x = for(e <- fruits if e.length < 6) yield e.toUpperCase()
    println(x(1))
  }

  /**
    * 10.12 迭代器使用
    */
  def useIterator: Unit = {
    val it = Iterator(1, 2, 3)
    it.foreach(print)
    //迭代器已经结束，下行语句不会有任何输出
    it.foreach(println)

  }

  /**
    * 10.11 使用zipWithIndex或zip创建循环计数器
    *
    * 循环一个有序集合，并且能够访问循环计数器
    */
  def zipWithIndexCounter: Unit = {
    val days = Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Staturday")

    //从0开始计数
    days.zipWithIndex.foreach{
      case(day, count) => println(s"$count is $day")
    }

    for((day, count) <- days.zipWithIndex) {
      println(s"$count is $day")
    }

    //zip方式可以控制超始值
    for((day, count) <- days.zip(Stream from 1)) {
      println(s"$count is $day")
    }
  }

  /**
    * 10.10 for循环遍历集合
    * 通过for循环遍历集合中元素，通过for/yield组合使用来从一个已有的集合创建出一个新的集合
    */
  def forLoop: Unit = {
    val fruits = Traversable("apple", "banana", "orange")
    for(f <- fruits) print(f)
    println
    for(f <- fruits) print(f.toUpperCase())
    //多行
    for(f <- fruits){
      val s = f.toUpperCase
      println(s)
    }
    val fruits2 = Array("apple", "banana", "orange")
    //计数器
    for(i <- 0 until fruits.size) println(s"element $i is ${fruits2(i)}")
    for((elem, count) <- fruits2.zipWithIndex){
      println(s"element $count is $elem")
    }

    //for/yield表达式
    val newFruits2 = for(e <- fruits2) yield e.toUpperCase()
    println(newFruits2(0))

    val newFrutis3 = for(e <- fruits2) yield {
      val upper = e.toUpperCase
      upper
    }
    println(newFrutis3(1))

    //Map中使用for
    val names = Map("fname" -> "wds", "age" -> "21")
    for((k, v) <- names) println(s"key = $k, value = $v")
  }

  /**
    * 10.9 foreach循环
    */
  def foreachLoop: Unit = {
    val fruits = Vector(1, 2, 3, 4, 5)
    fruits.foreach(i => println(i))
    fruits.foreach(println(_))
    fruits.foreach(println)
    fruits.foreach((i: Int) => print(i))

  }

  /**
    * 10.8 ArrayBuffer
    * 可变集合首选ArrayBuffer
    *
    * ArrayBuffer是一个索引序列集合，如果想用一个可变的线性序列集合，就使用ListBuffer
    */
  def firstArrayBuffer: Unit ={
    var furit = ArrayBuffer[String]()
    var nums = ArrayBuffer(1, 2, 3)
    nums += 4
    nums ++= List(5, 6, 7, 8, 9, 10)
    println(nums)
    nums -= (7, 8)
    println(nums)
    nums --= List(9, 10)
    println(nums)
  }

  /**
    * Vector为不可变序列第1位
    *
    */
  def firstVector: Unit = {
    var sister = Vector("wds01", "wds02", "wds03")
    //会产生一相新的Vector变量
    sister = sister :+ "wds04"
  }



  /**
    * 10.5 创建集合时声明一个类型
    */
  def baseUsing: Unit = {
    val x = List(1, 2, 3, 4)
    val x1 = List(1, 2, 3, 4L)
    val x2 = List[Number](1, 2.0, 33D, 400L)
    val x3 = List[AnyVal](1, 2.0, 400L, 33D)
  }

}

/**
  * 自定义 的distinct
  * @param firstName
  * @param lastName
  */
class CollPerson(firstName: String, lastName: String){

  override def toString: String = s"$firstName $lastName"

  def canEqual(a: Any) = a.isInstanceOf[CollPerson]

  override def equals(that: scala.Any): Boolean = that match{
    case that: CollPerson => that.canEqual(this) && this.hashCode() == that.hashCode()
    case _ => false
  }

  override def hashCode(): Int = {
    val prime = 31
    var result = 31
    result = prime * result + lastName.hashCode
    result = prime * result + (if (firstName == null) 0 else firstName.hashCode)

    result
  }
}

object CollPerson {
  def apply(firstName: String, lastName: String): CollPerson = new CollPerson(firstName, lastName)
}
