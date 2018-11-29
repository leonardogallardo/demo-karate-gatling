package features

import com.intuit.karate.gatling.PreDef.{pauseFor, _}
import io.gatling.core.Predef._
import mock.MockUtils

import scala.concurrent.duration._

class CatsKarateSimulation extends Simulation {

  MockUtils.startServer();

  val protocol = karateProtocol(
    "/cats/{id}" -> Nil,
    "/cats" -> pauseFor("get" -> 15, "post" -> 25)
  )

  protocol.nameResolver = (req, ctx) => req.getHeader("karate-name")

  val create = scenario("create").exec(karateFeature("classpath:features/cats_create/cats-create.feature"))
  val delete = scenario("delete").exec(karateFeature("classpath:features/cats_delete/cats-delete.feature"))

  setUp(
    create.inject(rampUsers(50) over (10 seconds)).protocols(protocol),
    delete.inject(rampUsers(20) over (10 seconds)).protocols(protocol)
  )

}
