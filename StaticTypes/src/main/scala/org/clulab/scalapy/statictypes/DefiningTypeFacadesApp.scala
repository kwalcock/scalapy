package org.clulab.scalapy.statictypes

import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.PyBracketAccess
import me.shadaj.scalapy.py.PyQuote

@py.native trait PyString extends py.Object {
  def count(subsequence: String): Int = py.native
}

@py.native trait IntList extends py.Any {
  @PyBracketAccess
  def apply(index: Int): Int = py.native

  @PyBracketAccess
  def update(index: Int, newValue: Int): Unit = py.native
}

object DefiningTypeFacadesApp extends App {

  {
    val string = py.module("string").digits.as[PyString]
    val result = string.count("123")

    // string.count(123)
    println(result)
  }

  {
    val myList = py"[1, 2, 3]".as[IntList]

    println(myList(0))
    myList(0) = 4
    println(myList(0))
  }
}
