package com.packt.chapter1.becomeAndUnbecome

import akka.actor.{ActorSystem, Props}

object BecomeUnbecomeApp extends App {
  val actorSystem = ActorSystem("become-and-unbecome")
  val actor = actorSystem.actorOf(Props[BecomeAndUnbecomeActor], "become-unbecome")

  // select behaviour first : Allow String
  actor ! true
  actor ! "This is the state true"
  actor ! 222 // this msg will not print

  // select behavior : Allow Int
  actor ! false
  actor ! 123
  actor ! "xxx" // this msg will not print
}
