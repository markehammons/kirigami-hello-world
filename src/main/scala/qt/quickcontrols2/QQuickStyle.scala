package qt.quickcontrols2

import scalanative.unsafe.*
import qt.QString
import scala.util.Using.Manager

@extern
@link("Qt5QuickControls2")
object _QQuickStyle:
  def q_quick_style_set_style(style: QString): Unit = extern

object QQuickStyle:
  def setStyle(style: String)(using m: Manager): Unit = 
    _QQuickStyle.q_quick_style_set_style(QString(style))
