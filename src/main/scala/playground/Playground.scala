package playground

object Playground extends App {
  val actorSystem = ActorSystem("Hello Akka")
  println(actorSystem.name)
}
