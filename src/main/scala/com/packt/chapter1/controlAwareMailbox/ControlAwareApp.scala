package com.packt.chapter1.controlAwareMailbox

import akka.actor.{ActorSystem, Props}

object ControlAwareApp extends App {
  val actorSystem = ActorSystem("control-aware-mailbox")
  val controlAwareMailboxActor = actorSystem
    .actorOf(Props[ControlAwareMailbox].withDispatcher("control-aware-dispatcher"))

  controlAwareMailboxActor ! "hello"
  controlAwareMailboxActor ! "how are you"
  controlAwareMailboxActor ! MySpecialMessage("Worasit want to go home.")
  controlAwareMailboxActor ! "I am fine"
  controlAwareMailboxActor ! MySpecialMessage("Worasit is arrived home.")

  actorSystem.terminate()
}
