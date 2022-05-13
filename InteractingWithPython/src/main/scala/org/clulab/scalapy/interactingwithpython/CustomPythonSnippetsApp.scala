package org.clulab.scalapy.interactingwithpython

import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.PyQuote
import me.shadaj.scalapy.py.SeqConverters

object CustomPythonSnippetsApp extends App {

  val mappedList = py.Dynamic.global.list(
    py"map(lambda elem: elem + 1, ${Seq(1, 2, 3).toPythonProxy})"
  )
  println(mappedList)

  val result = py.eval("1 + 2")
  println(result)
}
