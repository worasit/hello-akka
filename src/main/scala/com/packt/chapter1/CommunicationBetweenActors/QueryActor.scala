package com.packt.chapter1.CommunicationBetweenActors

import akka.actor.Actor
import com.typesafe.scalalogging.LazyLogging

class QueryActor extends Actor with LazyLogging {

  import Messages._

  override def receive: Receive = {
    case Start(actorRef) =>
      logger.info("send me the next random number")
      actorRef ! GiveMeRandomNumber
    case Done(randomNumber) =>
      logger.info(s"received a random number $randomNumber")
  }
}
