package kf5.ki18n

import scalanative.unsafe._
import qt.core.QByteArray
import scala.util.Using.Manager

@extern
@link("KF5I18n")
private object _KLocalizedString:
  def k_localized_string_set_application_domain(domain: QByteArray): Unit =
    extern

object KLocalizedString:
  def setApplicationDomain(domain: String)(using m: Manager) =
      _KLocalizedString.k_localized_string_set_application_domain(
        QByteArray(domain)
      )