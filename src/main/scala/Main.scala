import scalanative.unsafe.*
import scalanative.libc.stdlib.free

import qt.QApplication
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import qt.QResource
import java.nio.file.Paths
import scala.util.Using
import qt.qml.QQmlApplicationEngine
import java.net.URI
import qt.core.QUrl

object Main {
  def main(args: Array[String]): Unit =
    Using.Manager { implicit manager =>
      val ptr = QApplication(args)
      QResource.registerResource(Paths.get("./myresource.rcc"))

      val appEngine = QQmlApplicationEngine.apply

      println("here")
      appEngine.rootContext.setContextObject(???)
      appEngine.load(URI("qrc:/main.qml"))
      println("there")

      if appEngine.rootObjects.isEmpty then -1
      else ptr.exec()
    }

    // println(ptr.exec())
    println("Hello, world!")
}
