package com.wds.scala.base.method

/**
  * 5.1 控制方法作用域 Scala方法缺省是public
  *
  *  最严格到最开放的顺序如下：
  *   对象私有作用域
  *   私有的
  *   包内可见
  *   指定包内可见
  *   公共的
  *
  * Created by wangdongsong1229@163.com on 2017/6/23.
  */
class AccessControl {

  //对子类可见
  protected def breathe{}

  //对象私有作用域，只有当前实例内可见
  private[this] def isFoo = true

  //私有作用域
  private def isTrue = true

  //包内可见
  private[method] def doxX {}

  //公共级别
  def doPublic{}

}
