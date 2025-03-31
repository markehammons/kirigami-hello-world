package qt.qml

import scalanative.unsafe.*
import qt.core.QObject
import scala.util.Using.{Manager, Releasable}
import qt.core.QUrl
import java.net.URI
import scala.util.Using
import qt.core.QList

//todo: real subtype is QQmlEngine
opaque type QQmlApplicationEngine <: QObject = QObject

@extern
@link("Qt5Core")
@link("Qt5Qml")
private object _QQmlApplicationEngine:
  def q_qml_application_engine_init(): QQmlApplicationEngine = extern

  def q_qml_application_engine_root_context(
      appEngine: QQmlApplicationEngine
  ): QQmlContext = extern

  def q_qml_application_engine_destroy(appEngine: QQmlApplicationEngine): Unit =
    extern

  def q_qml_application_engine_load(
      appEngine: QQmlApplicationEngine,
      path: QUrl
  ): Unit = extern

  def q_qml_application_engine_root_objects(appEngine: QQmlApplicationEngine): QList[QObject] = extern

object QQmlApplicationEngine:
  given Releasable[QQmlApplicationEngine] with
    def release(resource: QQmlApplicationEngine): Unit =
      println("destroying qmlappengine")
      _QQmlApplicationEngine.q_qml_application_engine_destroy(resource)
  def apply(using m: Manager) =
    println("creating qmlappengine")
    m(_QQmlApplicationEngine.q_qml_application_engine_init())

  extension (appEngine: QQmlApplicationEngine)
    def rootContext: QQmlContext =
      _QQmlApplicationEngine.q_qml_application_engine_root_context(appEngine)

    def load(url: URI)(using m: Manager): Unit = 
      _QQmlApplicationEngine.q_qml_application_engine_load(appEngine, QUrl(url))

    def rootObjects: QList[QObject] =
      _QQmlApplicationEngine.q_qml_application_engine_root_objects(appEngine)
