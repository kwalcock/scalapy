package org.clulab.scalapy.statictypes

import me.shadaj.scalapy.py

@py.native object StringsModule extends py.StaticModule("string") {
  def digits: String = py.native
}

object StaticModuleTypesApp extends App {

  println(StringsModule.digits)
}
