package com.packt.chapter1.CommunicationBetweenActors

import akka.actor.Actor
import com.typesafe.scalalogging.LazyLogging

import scala.util.Random._

class RandomNumberGeneratorActor extends Actor with LazyLogging {
  import Messages._

  override def receive: Receive = {
    case GiveMeRandomNumber =>
      logger.info("received a message to generate a random integer.")
      val randomNumber = nextInt
      sender ! Done(randomNumber)
  }
}
