package org.clulab.scalapy.interactingwithpython

import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.SeqConverters

import scala.collection.mutable

object ScalaPythonConversionsApp extends App {
  {
    val mySeqToCopy = Seq(Seq(1, 2), Seq(3))
    val result = mySeqToCopy.toPythonCopy

    println(result)
  }

  {
    val mySeqToProxy = Array(1, 2, 3)
    val myProxy = mySeqToProxy.toPythonProxy
    println(py.Dynamic.global.list(myProxy))
    mySeqToProxy(2) = 100
    println(py.Dynamic.global.list(myProxy))
  }

  {
    val myPythonList = py.Dynamic.global.list(py.Dynamic.global.range(10))
    val copyLoad = myPythonList.as[Vector[Int]]
    val proxyLoad = myPythonList.as[mutable.Seq[Int]]

    println(copyLoad)
    println(proxyLoad)

    myPythonList.bracketUpdate(0, 100)

    println(copyLoad)
    println(proxyLoad)

    proxyLoad(0) = 200

    println(myPythonList)
  }
}
