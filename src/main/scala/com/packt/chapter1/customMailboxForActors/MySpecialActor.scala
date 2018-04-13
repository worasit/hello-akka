package com.packt.chapter1.customMailboxForActors

import akka.actor.Actor
import com.typesafe.scalalogging.LazyLogging

class MySpecialActor extends Actor with LazyLogging {
  override def receive: Receive = {
    case msg: String =>
      println(s"msg is $msg")
  }
}
