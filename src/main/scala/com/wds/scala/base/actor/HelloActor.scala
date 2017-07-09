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

object Main extends App{
  val system = ActorSystem("HelloSystem")

  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")

  helloActor ! "hello"
  helloActor ! "buenos dias"

  val future: Future[Terminated] = system.terminate()

  Await.ready(system.whenTerminated, Duration(1, TimeUnit.MINUTES))
}
