package com.packt.chapter1.becomeAndUnbecome

import akka.actor.Actor

class BecomeAndUnbecomeActor extends Actor {
  override def receive: Receive = {
    case true => context.become(isStateTrue)
    case false => context.become(isStateFalse)
  }
  def isStateTrue: Receive = {
    case msg: String => println(s"$msg")
    case false => context.become(isStateFalse)
  }
  def isStateFalse: Receive = {
    case msg: Int => println(s"$msg")
    case true => context.become(isStateTrue)
  }
}
