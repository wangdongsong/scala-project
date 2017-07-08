package com.wds.scala.base.file

import java.io._

import scala.io.Source

/**
  * Created by wangdongsong1229@163.com on 2017/7/7.
  */
object OpenReadFile {

  def main(args: Array[String]): Unit = {
    //openFile
    //writeFile
    //rwBinaryFile
    processChar
  }

  /**
    * 12.4 如何处理文本文件中的每个字符
    */
  def processChar: Unit ={

    val fileName = "E:\\javaTest\\scala.txt"

    //不考虑性能
    val source = Source.fromFile(fileName)
    for(char <- source){
      println(char.toUpper)
    }
    source.close()

    //统计行数，不考虑性能
    val NEWLine = 10
    var newLineCount = 0L
    for{
      char <- source
      if char.toByte == NEWLine
    } newLineCount += 1
    println(newLineCount)

    //性能好的
    var performaceCount = 0L
    for{
      line <- source.getLines()
      c <- line
      if c.toByte == NEWLine
    } performaceCount += 1
    println(performaceCount)
  }

  /**
    * 12.3 读写二制文件
    */
  def rwBinaryFile: Unit = {
    var in = None: Option[FileInputStream]
    var out = None: Option[FileOutputStream]

    try {
      in = Some(new FileInputStream("E:\\javaTest\\scala.txt"))
      out = Some(new FileOutputStream("E:\\javaTest\\scalaBinary.txt"))
      var c = 0
      while ( {
        c = in.get.read; c != -1
      }) {
        out.get.write(c)
      }
    } catch {
      case e: IOException => e.printStackTrace
    }finally {
      println("finish")
      if(in.isDefined) in.get.close()
      if(out.isDefined) out.get.close()
    }

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

  /**
    * 12.2 写入文件
    * Scala不提供写文件能力，使用Java的
    */
  def writeFile: Unit = {
    val pw = new PrintWriter(new File("E:\\javaTest\\scala.txt"))
    pw.write("HelloWorld")
    pw.close()
  }

}
