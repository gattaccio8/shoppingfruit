import sbt._
import Keys._

object WebappDeploy extends Build {
  import Dependency._
  import Resolvers._
  import BuildSettings._
  import scala.collection._

  lazy val root = Project(id = "shoppingfruit", base = file("."), settings = standardBuildSettings ++ Seq(
    resolvers := Seq(jettyRepo, resolver, Classpaths.typesafeReleases),
    libraryDependencies ++= scalaTest
  ))
}

object BuildSettings {

  val standardBuildSettings: Seq[Def.Setting[_]] = Defaults.coreDefaultSettings ++ Seq[Setting[_]](
      organization := "shoppingfruit",
      version := "1.0",
      scalaVersion := "2.11.1"
  )
}

object Resolvers {
  val jettyRepo = "jetty repo" at "http://siasia.github.com/maven2"
  val resolver = "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
}

object Dependency {
  private val scalaTestVersion = "2.2.4"

  val scalaTest = Seq(
    "org.scalatest" % "scalatest_2.11" % scalaTestVersion  % "test"
  )

}
