package com.packt.chapter1.tellPattern

import akka.actor.Actor

class SummingActor(initial: Int) extends Actor {

  // State
  var sum: Int = 0

  // Behaviour
  override def receive: Receive = {
    case number: Int =>
      sum = initial + number + sum
      println(s"my state as sum is $sum")
    case _ =>
      println("I don't know what are you talking about")
  }
}
