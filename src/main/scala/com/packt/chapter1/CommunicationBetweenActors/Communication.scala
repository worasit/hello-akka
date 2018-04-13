package com.packt.chapter1.CommunicationBetweenActors

import akka.actor.{ActorSystem, Props}
import com.packt.chapter1.CommunicationBetweenActors.Messages.Start
import com.typesafe.scalalogging.LazyLogging

object Communication extends App with LazyLogging {
  val actorSystem = ActorSystem("communication-actors")
  val randomNumberActor = actorSystem.actorOf(Props[RandomNumberGeneratorActor], "randomNumber-actor")
  val queryActor = actorSystem.actorOf(Props[QueryActor], "query-actor")

  while (true) {
    queryActor ! Start(randomNumberActor)
    Thread.sleep(2000)
  }

  logger.info("Main application exited")
}




