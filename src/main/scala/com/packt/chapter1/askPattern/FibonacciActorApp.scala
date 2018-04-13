package com.packt.chapter1.askPattern

import akka.actor.{ActorSystem, Props}
import akka.pattern._
import akka.util.Timeout

import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, Future}
import scala.util.{Failure, Success}

object FibonacciActorApp extends App {
  implicit val ec: ExecutionContextExecutor = ExecutionContext.global
  implicit val timeOut: Timeout = Timeout(20 seconds)
  val actorSystem = ActorSystem("fibonacci-actorSystem")
  val fibonacciActor = actorSystem.actorOf(Props[FibonacciActor])

  val resultF: Future[Int] = fibonacciActor.ask(10).mapTo[Int]

  resultF.onComplete({
    case Success(num) => println(s"Got result: $num")
    case Failure(ex) => println(s"Got error: ${ex.getMessage}")
  })

  println(s"Fibonacci main application finish")

}
