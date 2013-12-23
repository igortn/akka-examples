package itn.akkaexamples.stash

import akka.actor.{Props, ActorSystem}
import akka.event.slf4j.Logger


object Main extends App {
  val log = Logger("MainLogger")

  val system = ActorSystem("StashExample")
  val worker = system.actorOf(Props[PausableWorker], "worker")

  import PausableWorker._

  worker ! 17
  worker ! "qwerty"
  worker ! Pause
  worker ! 101
  worker ! 111

  Thread sleep 3000
  worker ! Resume

  Thread sleep 1000
  system.shutdown()
}
