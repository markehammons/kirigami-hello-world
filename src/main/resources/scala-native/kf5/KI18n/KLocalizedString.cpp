#include <KLocalizedString>
#include "KLocalizedString.hpp"
#include "../../qt/core/QByteArray.hpp"

void k_localized_string_set_application_domain(q_byte_array domain) {
  KLocalizedString::setApplicationDomain(*((QByteArray*) domain));
  return;
}