package com.wds.scala.base.actor

import java.util.concurrent.TimeUnit

import akka.actor.{Actor, ActorSystem, Props, Terminated}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

/**
  * 13.1 HelloWorld Actor
  * Created by wangdongsong1229@163.com on 2017/7/8.
  */
class HelloActor extends Actor{
  def receive: Receive = {
    case "hello" => println("hello back to you")
    case _ => println("Huh?")
  }
}

class ParamHelloActor(name: String) extends Actor{
  override def receive: Receive = {
    case "hello" => println(s"hello back to you, $name")
    case _ => println(s"Huh? $name")
  }
}

object Main extends App{
  val system = ActorSystem("HelloSystem")

  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")

  helloActor ! "hello"
  helloActor ! "buenos dias"

  val paramHelloActor = system.actorOf(Props(new ParamHelloActor("Fred")), name = "paramHelloActor")
  paramHelloActor ! "hello"

  Await.ready(system.whenTerminated, Duration(1, TimeUnit.MINUTES))
}
