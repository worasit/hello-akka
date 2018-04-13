package com.packt.chapter1.askPattern

import akka.actor.Actor

class FibonacciActor extends Actor {
  override def receive: Receive = {
    case num: Int =>
      println(s"Recieve number: $num")
      sender() ! fib(num)
  }


  def fib(n: Int): Int = n match {
    case 0 | 1 => n
    case _ => fib(n - 1) + fib(n - 2)
  }
}
