package com.packt.chapter1.customMailboxForActors

import akka.actor.{ActorSystem, Props}
import com.typesafe.scalalogging.LazyLogging

object CustomMailbox extends App with LazyLogging {

  val actorSystem = ActorSystem("custom-mailbox")
  val actorWithSpecificDispatcher = actorSystem.actorOf(Props[MySpecialActor].withDispatcher("custom-dispatcher"))
  val actor1 = actorSystem.actorOf(Props[MyActor], "xyz")
  val actor2 = actorSystem.actorOf(Props[MyActor], "MyActor")

  //  actor1 ! ("hello", actorWithSpecificDispatcher)
  actor2 ! ("hello", actorWithSpecificDispatcher)
}
