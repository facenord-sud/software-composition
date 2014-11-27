# Scala DSL for DICTŌ
> A DSL for interacting with [DICTŌ](http://scg.unibe.ch/dicto/index.php)

Version [v0.3](https://github.com/facenord-sud/software-composition/releases/tag/v0.3)

## Goal
The goal of this project is to build a Scala DSL which interact with DICTŌ and integrated with JUnit. A Scala DSL provide the advantage to can be used in every Scala and Java projects. So using DICTŌ will become really easy.

An other advantage is to provide smart autocompletion in almost every IDE or text editors

## Organization
All the files for the Scala library are under `src/main/scala`.

Files in packages `examples` and `tools` are not accurate anymore, but
can be run with: `sbt run`. See usage for more infos. And refer to
comments in the files to know what they are doing.

The tests in the folder `src/test/scala/` is for
demonstration only. It shows how the results from DICTŌ are used and
integrated with JUnit 4.

## Getting started

1. If not already done, install [sbt](http://www.scala-sbt.org) (`brew install sbt` on OS X)
2. Clone this repo
3. From the root of this repo, run sbt: `sbt`
4. To run the example test: `test`
5. If you want to add more dicto tests:
6. edit the file src/test/scala/DictoTester.scala
7. A dicto tests is something like that:
```scala
@DictoTest
def aTest = {
 // use the dicto DSL here:
}
```

## Installation

You have two possibilities:
- Downlaod the latest [release]() and include it in your path of your Java or Scala project
- clone the repo:
  1. Run `sbt package`
  2. Run `sbt publish-locally`
  3. Include the project as a sbt, maven or ivy dependecie (browse where the lib is installed locally to know how to include it)
  
 ## Usage

Once installed, start creating a test file like every other JUnit test. You can inspire of this [one]() to get started.

After that, start coding dicto tests based on the DSL an run it like every JUnit tests! 
 
## Future work
The next steps will to generate the DSL from the DICTO specifications
