import ai.kien.python.Python
import org.clulab.sbt.BuildUtils

lazy val javaOpts = {
  if (BuildUtils.isWindows())
    // Fill this in manually.
    Seq("-Djna.library.path=" +
      Seq(
        "D:/ProgramFiles/Python39",
        "D:/ProgramFiles/Python39/DLLs"
      ).mkString(";")
    )
  else {
    val result = Python().scalapyProperties.get.map { case (key, value) =>
      s"-D$key=$value"
    }.toSeq
    result.foreach { result => println(s"Result: $result") }
    result
  }
}

ThisBuild / run / javaOptions ++= javaOpts
ThisBuild / Test / javaOptions ++= javaOpts
