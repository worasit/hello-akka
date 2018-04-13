package com.packt.chapter1.prioritizing

import akka.actor.Actor

class PriorityMailboxActor extends Actor {
  override def receive: Receive = {
    case args: Int => println(args)
    case args: String => println(args)
    case args: Long => println(args)
    case args => println(args)
  }
}
