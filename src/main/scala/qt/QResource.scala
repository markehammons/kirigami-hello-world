package qt

import scalanative.unsafe.*
import java.nio.file.Path
import scala.util.Using
@extern
@link("Qt5Core")
object _QResource:
  def q_resource_register_resource(rccFileName: QString): Unit = extern

object QResource:
  def registerResource(rccFilePath: Path) = 
    Using.Manager{ implicit m =>
      val absolutePathString = rccFilePath.toAbsolutePath().toString()
      val qs = QString(absolutePathString)
      _QResource.q_resource_register_resource(qs)
    }
