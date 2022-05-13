# scalapy

Examples from the [ScalaPy documentation](https://scalapy.dev/docs/)

To use the programs with IntelliJ, define the `jna.library.path` with the VM options.  First run `sbt` and note the values that are printed out when you try to access the programs, for example like

```
sbt:scalapy> GettingStarted/runMain org.clulab.scalapy.gettingstarted.HelloWorldApp
```

* Linux:

    * Python: -Djna.library.path=/usr/lib/python3.8/config-3.8-x86_64-linux-gnu:/usr/lib
    * Python: -Dscalapy.python.library=python3.8
    * Python: -Dscalapy.python.programname=/bin/python3

* Windows:

* Mac:
