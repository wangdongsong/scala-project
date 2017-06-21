package com.wds.scala.base.obj

/**
  * 4.6 覆写默认的访问和修改方法
  *
  * 覆写默认的setter和getter方法
  *
  * 变量定义为var时，Scala会自动生成getter和setter方法
  *
  * 要重写getter和setter方法，需要将变量名重新命名并name和name_=的方法生成get和set
  * Created by wangdongsong1229@163.com on 2017/6/21.
  */
class GetterAndSetter(var _name: String) {
  //getter
  def name = _name
  //setter
  def name_= (aName: String){ _name = aName}
}

class Stock {
  var delayPrice: Double = _
  //同一个类的实例可以访问
  private var currentPrice: Double = _

  //该字段私有，只有包含该字段的对方可以访问
  private[this] var price: Double = _

  //无法编译通过
  //def isPriceHiger(that: Stock):Boolean = {this.price > that.price}


  def setCurrentPrice(p: Double) = {
    currentPrice = p
  }

  def isHigher(that: Stock):Boolean = {
    this.currentPrice > that.currentPrice
  }

}

object GetterAndSetterTest{

  def main(args: Array[String]): Unit = {
    val stock = new Stock
    print(stock.delayPrice)
    //编译不通过
    //println(stock.currentPrice)

    val stock2 = new Stock
    stock2.setCurrentPrice(10)
    //可以通过同一个类的实例访问
    println(stock.isHigher(stock2))
  }

}