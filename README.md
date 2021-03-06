# scalapy

Examples from the [ScalaPy documentation](https://scalapy.dev/docs/)

To use the programs with IntelliJ, define the VM options that `sbt` derives programmatically.  First run `sbt` and note the values that are printed out when you try to access the programs, for example like

```
sbt:scalapy> GettingStarted/runMain org.clulab.scalapy.gettingstarted.HelloWorldApp
```

* Linux:

    * Python: -Djna.library.path=/usr/lib/python3.8/config-3.8-x86_64-linux-gnu:/usr/lib
    * Python: -Dscalapy.python.library=python3.8
    * Python: -Dscalapy.python.programname=/bin/python3


* Mac:

    It may be important to match the Java VM hardware architecture to architecture used by PyTorch.

    * Python: -Djna.library.path=/Library/Frameworks/Python.framework/Versions/3.10/lib/python3.10/config-3.10-darwin:/Library/Frameworks/Python.framework/Versions/3.10/lib
    * Python: -Dscalapy.python.library=python3.10
    * Python: -Dscalapy.python.programname=/Library/Frameworks/Python.framework/Versions/3.10/bin/python3


* Windows:

    The automatic configuration does not work with Windows, so values need to be entered into the `python.sbt` files for each subproject.
    
    * "-Djna.library.path=D:/ProgramFiles/Python39",
    * "-Dscalapy.python.library=python39"
    