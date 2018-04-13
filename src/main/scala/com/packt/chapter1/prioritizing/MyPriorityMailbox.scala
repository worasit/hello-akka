package com.packt.chapter1.prioritizing

import akka.actor.ActorSystem
import akka.dispatch.{PriorityGenerator, UnboundedPriorityMailbox}
import com.typesafe.config.Config

class MyPriorityMailbox(settings: ActorSystem.Settings,
                        config: Config)
  extends UnboundedPriorityMailbox(
    PriorityGenerator {
      case _: String => 0
      case _: Int => 1
      case _: Long => 2
      case _ => 3
    }
  )
