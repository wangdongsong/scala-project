package com.wds.scala.base.actor

import java.util.concurrent.TimeUnit

import akka.actor.{Actor, ActorRef, ActorSystem, Props, Terminated}

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

/**
  * 13.2 带有参数的Actor
  * @param name
  */
class ParamHelloActor(name: String) extends Actor{
  override def receive: Receive = {
    case "hello" => println(s"hello back to you, $name")
    case _ => println(s"Huh? $name")
  }
}

class Ping(pong: ActorRef) extends Actor{
  var count = 0
  def incrementAndPrint: Unit ={
    count += 1
    println("ping")
  }

  override def receive: Receive = {
    case "start" => {
      incrementAndPrint
      pong ! "pong"
    }
    case "ping" => {
      incrementAndPrint
      if (count > 99) {
        sender ! "stop"
        println("ping stoped")
        context.stop(self)
      }else{
        sender ! "pong"
      }
    }
    case _ => println("Ping got something unexpected")
  }
}

class Pong extends Actor{
  override def receive: Receive = {
    case "pong" => {
      println("pong")
      sender ! "ping"
    }
    case "stop" => {
      println("pong stoped")
      context.stop(self)
    }
    case _ => println("Pong got something unexpected.")
  }
}

object Main {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("HelloSystem")

    helloActor(system)

    system.terminate()
  }


  private def helloActor(system: ActorSystem) = {
    val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")

    helloActor ! "hello"
    helloActor ! "buenos dias"

    val paramHelloActor = system.actorOf(Props(new ParamHelloActor("Fred")), name = "paramHelloActor")
    paramHelloActor ! "hello"
  }
}
