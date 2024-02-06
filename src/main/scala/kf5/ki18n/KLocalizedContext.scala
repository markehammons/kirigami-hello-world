package kf5.ki18n

import scalanative.unsafe._
import qt.core.QObject
import scala.util.Using.Manager

opaque type KLocalizedContext <: QObject = QObject

@extern
@link("KF5I18n")
private object _KLocalizedContext:
  def k_localized_context_init(parent: QObject): KLocalizedContext = extern

object KLocalizedContext:
  def apply(parent: QObject)(using m: Manager) = 
    m(_KLocalizedContext.k_localized_context_init(parent))
  
