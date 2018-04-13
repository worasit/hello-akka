package com.packt.chapter1.tellPattern

import akka.actor.{ActorRef, ActorSystem, Props}

object HelloAkkaActorSystem extends App {
  val actorSystem = ActorSystem("HelloAkka")

  // creating an actor inside the actor system
  val actor: ActorRef = actorSystem.actorOf(Props(classOf[SummingActor], 0), "summing-actor")


  print(actor.path)

  while (true) {
    Thread.sleep(2000)
    val message = 1
    actor ! message
    println(s"send $message to summing-actor")
  }
}
