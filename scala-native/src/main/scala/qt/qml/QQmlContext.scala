package qt.qml

import scalanative.unsafe.*
import qt.core.QObject

opaque type QQmlContext <: QObject = QObject

@extern
@link("Qt5Qml")
@link("Qt5Core")
private object _QQmlContext:
  def q_qml_context_set_context_object(
      qml_context: QQmlContext,
      obj: QObject
  ): Unit = extern

object QQmlContext:
  extension (q: QQmlContext)
    def setContextObject(obj: QObject): Unit =
      _QQmlContext.q_qml_context_set_context_object(q, obj)
