# Scala DSL for DICTŌ
> A DSL for interacting with [DICTŌ](http://scg.unibe.ch/dicto/index.php)

Release [v0.3](https://github.com/facenord-sud/software-composition/releases/tag/v0.3)

## Goal
The goal of this project is to build a Scala DSL which interact with DICTŌ and integrated with JUnit. A Scala DSL provide the advantage to can be used in every Scala and Java projects. So using DICTŌ will become really easy.

An other advantage is to provide smart autocompletion in almost every IDE or text editors

## Organization
All the files for the Scala library are under `src/main/scala`.

Files in packages `examples` and `tools` are not accurate anymore, but
can be run with: `sbt run`. See Usage for more infos. And refer to
comments in the files to know what they are doing.

The test in the folder `src/test/scala/ExampleTest.scala` is for
demonstration only. It shows how the results from DICTŌ are used and
integrated with JUnit 4. For now, it do not really interact with DICTŌ,
but it use an example file located in: `src/main/resources`.

## Usage

1. If not already done, install [sbt](http://www.scala-sbt.org) (`brew install sbt` on OS X)
2. Clone this repo
3. From the root of this repo, run sbt: `sbt`
4. To run the example test: `test`
 
## Future work
The next steps will to generate the DSL from the DICTO specifications and to interact with the Small-talk engine.

An other point is to think about a way to distribute it. Actually a JAR
is available.
