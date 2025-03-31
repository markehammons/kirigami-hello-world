#include <QCoreApplication>
#include "QCoreApplication.hpp"

void q_core_application_set_organization_domain(const q_string orgDomain) {
  QCoreApplication::setOrganizationDomain(*((QString*)orgDomain));
  return;
}

void q_core_application_set_organization_name(const q_string orgName) {
  QCoreApplication::setOrganizationName(*((QString*) orgName));
  return;
}

void q_core_application_set_application_name(const q_string applicationName) {
  QCoreApplication::setApplicationName(*((QString*) applicationName));
  return;
}