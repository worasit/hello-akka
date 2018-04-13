package com.packt.chapter1.prioritizing

import akka.actor.{ActorSystem, Props}

object PriorityMailboxApp extends App {
  val actorSystem = ActorSystem("priority-mailbox")
  val myPriorityActor =
    actorSystem.actorOf(Props[PriorityMailboxActor].withDispatcher
    ("prior-dispatcher"))

  myPriorityActor ! 6.0
  myPriorityActor ! 1
  myPriorityActor ! "Hello"
  myPriorityActor ! false
}
