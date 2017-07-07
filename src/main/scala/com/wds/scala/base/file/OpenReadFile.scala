package com.wds.scala.base.file

import scala.io.Source

/**
  * Created by wangdongsong1229@163.com on 2017/7/7.
  */
object OpenReadFile {

  def main(args: Array[String]): Unit = {
    openFile
  }

  /**
    * 12.1 打开并读取文件
    */
  def openFile: Unit ={
    //文件无法关闭
    val fileName = "E:\\GitHub\\scala-project\\src\\main\\scala\\com\\wds\\scala\\base\\StringTest.scala"
    for(line <- Source.fromFile(fileName).getLines()){
      println(line)
    }

    val lineList = Source.fromFile(fileName).toList
    lineList.foreach(println)

    val bufferedSource = Source.fromFile(fileName)
    for(line <- bufferedSource.getLines()){
      println(line.toUpperCase)
    }
    //确保关闭
    bufferedSource.close()


  }

}
