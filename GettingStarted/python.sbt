import ai.kien.python.Python
import org.clulab.sbt.BuildUtils


// $env:SCALAPY_PYTHON_PROGRAMNAME="D:/ProgramFiles/Pythond39/python.exe"
// $env:SCALAPY_PYTHON_LIBRARY="D:/ProgramFiles/Python39/python39.dll"

lazy val javaOpts = {
  if (BuildUtils.isWindows())
    // Fill this in manually.
    Seq("-Djna.library.path=" + {
      val base = "D:/ProgramFiles/Python39"
      // val base = "E:/python-3.9.11"
      val dirNames = Seq(
        base,
        base + "/python.exe",
        base + "/python3.dll",
        base + "/python3.exe",
        base + "/python39.dll",
        base + "/pythonw.exe",
        base + "/vcruntime140.dll",
        base + "/vcruntime140_1.dll",
        base + "/DLLs"
      )
      dirNames.foreach { dirName =>
        println(dirName)
        val exists = new File(dirName).exists
        println(exists)
      }
      
      val result = dirNames.mkString(";")
      println(result)
      result
      },
      "-Dscalapy.python.library=python39"
    )
  else {
    println("Keith was up here!")
    val python = Python("python.exe")
    println("Keith was down here!")
    val result = python.scalapyProperties.get.map { case (key, value) =>
      println("Keith was here")
      println(key)
      println(value)
      s"-D$key=$value"
    }.toSeq
    result.foreach { result => println(s"Result: $result") }
    result
  }
}

ThisBuild / run / javaOptions ++= javaOpts
ThisBuild / Test / javaOptions ++= javaOpts
