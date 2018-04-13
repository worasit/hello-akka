package com.packt.chapter1.customMailboxForActors

import akka.actor.{Actor, ActorRef}
import com.typesafe.scalalogging.LazyLogging

class MyActor extends Actor with LazyLogging {
  override def receive: Receive = {
    case (msg: String, actorRef: ActorRef) =>
      actorRef ! msg
    case msg: String =>
      println(msg)
  }
}
