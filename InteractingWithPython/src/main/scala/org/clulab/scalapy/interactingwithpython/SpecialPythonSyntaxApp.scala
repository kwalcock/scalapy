package org.clulab.scalapy.interactingwithpython

import me.shadaj.scalapy.interpreter.CPythonInterpreter
import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.SeqConverters

object SpecialPythonSyntaxApp extends App {
  {
    val myFile = py.Dynamic.global.open("../README.md")
    py.`with`(myFile) { file =>
      println(file.encoding.as[String])
    }
  }

  {
    val pythonList = py.Dynamic.global.list(Seq(1, 2, 3).toPythonProxy)
    println(pythonList)
    pythonList.bracketAccess(0)
    pythonList.bracketUpdate(1, 100)
    println(pythonList)
  }

  {
    val myDict = py.Dynamic.global.dict()
    myDict.bracketUpdate("hello", "world")
    println(myDict)
    myDict.bracketDelete("hello")
    println(myDict)
  }

  {
    CPythonInterpreter.execManyLines(
      """class MyClass:
        |  myAttribute = 0""".stripMargin
    )
    py.Dynamic.global.MyClass.attrDelete("myAttribute")
  }

  {
    val myValue = py.Dynamic.global.MyClass()
    myValue.del()
    try {
      println(myValue)
    }
    catch {
      case throwable: Throwable => println(throwable)
    }
  }

}
