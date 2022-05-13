package org.clulab.scalapy.interactingwithpython

import me.shadaj.scalapy.py

object GlobalScopeApp extends App {
  val list = py.Dynamic.global.range(1, 3 + 1)
  val listSum = py.Dynamic.global.sum(list)

  println(listSum)
}
