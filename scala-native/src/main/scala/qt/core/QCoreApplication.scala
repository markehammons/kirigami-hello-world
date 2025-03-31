package qt.core

import scalanative.unsafe.*
import qt.QString
import scala.util.Using
import scala.util.Using.Manager

@extern
@link("Qt5Core")
object _QCoreApplication:
  def q_core_application_set_organization_name(orgName: QString): Unit = extern
  def q_core_application_set_organization_domain(orgDomain: QString): Unit =
    extern

  def q_core_application_set_application_name(appName: QString): Unit = extern

object QCoreApplication:
  def setOrganizationDomain(orgDomain: String)(using m: Manager) =
    _QCoreApplication.q_core_application_set_organization_domain(
      QString(orgDomain)
    )

  def setOrganizationName(orgName: String)(using m: Manager) =
    _QCoreApplication.q_core_application_set_organization_name(QString(orgName))

  def setApplicationName(name: String)(using m: Manager) =
    _QCoreApplication.q_core_application_set_application_name(QString(name))
