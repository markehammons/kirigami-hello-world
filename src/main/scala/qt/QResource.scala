package qt

import scalanative.unsafe.*
import java.nio.file.Path
import scala.util.Using
import scala.util.Using.Manager
@extern
@link("Qt5Core")
object _QResource:
  def q_resource_register_resource(rccFileName: QString): Unit = extern

object QResource:
  def registerResource(rccFilePath: Path)(using m: Manager) = 
    val absolutePathString = rccFilePath.toAbsolutePath().toString()
    println(s"registering resource: $absolutePathString")
    val qs = QString(absolutePathString)
    _QResource.q_resource_register_resource(qs)
