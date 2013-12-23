package itn.akkaexamples.stash

import akka.actor.{ActorLogging, Stash, Actor}

object PausableWorker {
  case class Pause()
  case class Resume()
}

class PausableWorker extends Actor with Stash with ActorLogging {

  import PausableWorker._

  def receive = processing

  def processing: Receive = {
    case Pause =>
      log.info("pausing")
      context.become(paused)

    case msg => log.info("processed {}", msg)  // message is untyped, so it has to be matched in the end
  }

  def paused: Receive = {
    case Resume =>
      log.info("resuming, unstashing all")
      unstashAll()
      context.become(processing)

    case msg =>                       // message is untyped, so it has to be matched in the end
      log.info("stashing {}", msg)
      stash()
  }
}
