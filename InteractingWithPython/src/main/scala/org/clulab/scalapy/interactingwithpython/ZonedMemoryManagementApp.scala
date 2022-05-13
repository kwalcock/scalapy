package org.clulab.scalapy.interactingwithpython

import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.SeqConverters

object ZonedMemoryManagementApp extends App {

  py.local {
    (1 to 100).foreach { _ =>
      py.Dynamic.global.len(Seq(1, 2, 3).toPythonCopy)
    }
  }
}
