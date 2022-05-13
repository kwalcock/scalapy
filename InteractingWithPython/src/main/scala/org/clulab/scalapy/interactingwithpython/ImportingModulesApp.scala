package org.clulab.scalapy.interactingwithpython

import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.SeqConverters

object ImportingModulesApp extends App {
  val np = py.module("numpy")
  val a = np.array(Seq(
    Seq(1, 0),
    Seq(0, 12)
  ).toPythonProxy)
  val aSquared = np.matmul(a, a)

  println(aSquared)
}
