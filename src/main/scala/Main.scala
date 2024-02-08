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
import kf5.ki18n.KLocalizedContext
import kf5.ki18n.KLocalizedString
import qt.quickcontrols2.QQuickStyle
import qt.core.QCoreApplication

object Main {
  def main(args: Array[String]): Unit =
    Using.Manager { implicit manager =>
      val ptr = QApplication(args)
      KLocalizedString.setApplicationDomain("helloworld")
      QCoreApplication.setOrganizationName("KDE")
      QCoreApplication.setOrganizationDomain("kde.org")
      QCoreApplication.setApplicationName("Hello World")
      QResource.registerResource(Paths.get("./myresource.rcc"))


      println(Paths.get("./myresource.rcc").toAbsolutePath())

      QQuickStyle.setStyle("org.kde.desktop") 

      val appEngine = QQmlApplicationEngine.apply
      
      println("here")
      appEngine.rootContext.setContextObject(KLocalizedContext(appEngine))
      println("here2")
      appEngine.load(URI("qrc:/main.qml"))
      println("there")

      if appEngine.rootObjects.isEmpty then -1
      else 
        println("exec")
        0
        ptr.exec()
    }

    // println(ptr.exec())
    println("Hello, world!")
}
