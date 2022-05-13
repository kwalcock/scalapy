name := "interacting_with_python"
description := ""

resolvers ++= Seq(
//  Resolvers.localResolver, // Reserve for Two Six.
//  Resolvers.clulabResolver // processors-models, transitive dependency
)

libraryDependencies ++= {
  Seq(
    "me.shadaj" %% "scalapy-core" % "0.5.2"
  )
}

fork := true

