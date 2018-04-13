package com.packt.chapter1.stopping

import akka.actor.{ActorSystem, PoisonPill, Props}

object StoppingApp extends App {
  // There are two ways to stop an actors
  // 1. PoisonPill
  // 2. context.stop(actorRef)

  val actorSystem = ActorSystem("stop-actor")
  val actor1 = actorSystem.actorOf(Props[ShutdownActor], "actor1")
  val actor2 = actorSystem.actorOf(Props[ShutdownActor], "actor2")

  actor1 ! "This is actor1"
  actor1 ! "will be terminated by PoisonPill"
  actor1 ! PoisonPill

  actor2 ! "This is actor2"
  actor2 ! "will be terminated by context.stop(self)"
  actor2 ! Stop
}
