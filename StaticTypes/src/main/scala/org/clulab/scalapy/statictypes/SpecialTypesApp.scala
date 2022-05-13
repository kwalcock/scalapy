package org.clulab.scalapy.statictypes

import me.shadaj.scalapy.py

@py.native trait PythonRandomModule extends py.Object {
  def Random(a: py.|[Int, String]): py.Dynamic = py.native
}

object SpecialTypesApp extends App {
  val random = py.module("random").as[PythonRandomModule]
  println(random.Random(123))
  println(random.Random("123"))
}
