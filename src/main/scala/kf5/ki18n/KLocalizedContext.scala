package kf5.ki18n

import scalanative.unsafe._
import qt.core.QObject
import scala.util.Using.Manager
import scala.util.Using.Releasable

opaque type KLocalizedContext <: QObject = QObject

@extern
@link("KF5I18n")
private object _KLocalizedContext:
  def k_localized_context_init(parent: QObject): KLocalizedContext = extern
  def k_localized_context_destroy(context: KLocalizedContext): Unit = extern

object KLocalizedContext:
  given Releasable[KLocalizedContext] with
    def release(resource: KLocalizedContext): Unit =
      println("destroying klocalizedcontext")
      _KLocalizedContext.k_localized_context_destroy(resource)
  def apply(parent: QObject)(using m: Manager) =
    println("creating klocalizedcontext")
    m(_KLocalizedContext.k_localized_context_init(parent))
