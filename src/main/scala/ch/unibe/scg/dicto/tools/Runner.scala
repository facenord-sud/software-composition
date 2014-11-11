package ch.unibe.scg.dicto.tools

import java.io.File
import java.net.{URLClassLoader, URL}
import java.nio.file._
import scala.sys.process._
/**
 * Created by leo on 10.11.14.
 */

object Runner {

  def main(args: Array[String]):Unit = {
    val optionalArgs = Option(args)
    val dir = new File(if (args isDefinedAt 0) args(0) else "dicto")
    val searchCriteria = if (args isDefinedAt(1)) args(1) else "Dicto.scala"
    val tmpDir: Path = Files.createTempDirectory("dicto")
    if(!dir.exists()) {
      println(s"The directory: $dir doesn't exists.")
      System.exit(0)
    }
    val classes = getFileTree(dir).filter(_.getName.endsWith(searchCriteria))
    val compile = classes.map(_.getAbsolutePath).mkString(" ")
    if(compile.length == 0) {
      println("empty test suite.")
      System.exit(0)
    }

    val scalac = s"scalac -cp ${getJARPath()} -d ${tmpDir.toUri.getPath} $compile"
    println(scalac.!!)

    var urls = Array[URL](tmpDir.toUri.toURL)

    val classLoader: ClassLoader = new URLClassLoader(urls)
    classLoader.loadClass("test.dicto.TestDicto").newInstance()

  }

  def getFileTree(f: File): Stream[File] =
    f #:: (if (f.isDirectory) f.listFiles().toStream.flatMap(getFileTree)
    else Stream.empty)

  def getJARPath() :String = {
    new File(this.getClass.getProtectionDomain().getCodeSource().getLocation().toURI.getPath()).getAbsolutePath
  }
}
