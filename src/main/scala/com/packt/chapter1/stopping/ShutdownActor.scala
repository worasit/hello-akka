package com.packt.chapter1.stopping

import akka.actor.Actor

class ShutdownActor extends Actor {
  override def receive: Receive = {
    case msg: String => println(msg)
    case Stop => context.stop(self)
  }

  override def postStop(): Unit = {
    println(s"${self.path.name} has been terminated")
    super.postStop()
  }
}

case object Stop
