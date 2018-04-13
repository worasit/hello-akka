package com.packt.chapter1.tellPattern

import akka.actor.{Actor, ActorLogging}

class BehaviourAndState extends Actor with ActorLogging {

  // State inside the Actor
  var sum = 0

  // Behaviour which is applied on the state
  override def receive: Receive = {
    case x: Int => sum = sum + x
      log.info(s"my state as sum is $sum")
    case _ =>
      log.info("I don't know what are you talking about")
  }
}
