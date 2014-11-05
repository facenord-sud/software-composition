# Scala DSL for DICTŌ
> A DSL for interacting with [DICTŌ](http://scg.unibe.ch/dicto/index.php)

## Goal
The goal of this project is to build a Scala DSL which interact with DICTŌ. A Scala DSL provide the advantage to can be used in every Scala and Java projects. So using DICTŌ will become really easy.

An other advantage is to provide smart autocompletion in almost every plateform

## Organization
All the files for the Scala library are under `src/main/scala`. The tests are not accuarte any more and will be updated soon.

In the package `examples` you can have a look at a simple code which generate and print the DICTŌ code to the console.

## Usage

1. If not already done, install [sbt](http://www.scala-sbt.org) (`brew install sbt` on OS X)
2. Clone this repo
3. From the root of this repo, run sbt: `sbt`
4. To run the example: `run`
 
## Future work
The next steps will to generate the DSL from the DICTO specifications and to interact with the Small-talk engine. After that it is neede to provide a way to easely integrate in a Java or Scala project. The best way would probably to create a Maven dependecie

## TODO

TODO!!!

