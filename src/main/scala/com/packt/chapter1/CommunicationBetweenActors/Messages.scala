package com.packt.chapter1.CommunicationBetweenActors

import akka.actor.ActorRef

object Messages {

  case class Done(randomNumber: Int)

  case object GiveMeRandomNumber

  case class Start(actorRef: ActorRef)

}