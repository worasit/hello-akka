package com.packt.chapter1.customMailboxForActors

import akka.actor.{ActorRef, ActorSystem}
import akka.dispatch.{MailboxType, ProducesMessageQueue}
import com.typesafe.config.Config

class MyUnboundedMailbox extends MailboxType
  with ProducesMessageQueue[MyMessageQueue] {

  def this(settings: ActorSystem.Settings, config: Config) = {
    this()
  }

  override def create(owner: Option[ActorRef], system: Option[ActorSystem]): MyMessageQueue = {
    new MyMessageQueue
  }


}
