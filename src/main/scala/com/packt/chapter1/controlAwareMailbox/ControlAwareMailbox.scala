package com.packt.chapter1.controlAwareMailbox

import akka.actor.Actor
import akka.dispatch.ControlMessage

class ControlAwareMailbox extends Actor {
  override def receive: Receive = {
    case MySpecialMessage(msg) => println(s"This is the first Priority messages: $msg")
    case x => println(x)
  }
}

case class MySpecialMessage(msg: String) extends ControlMessage

