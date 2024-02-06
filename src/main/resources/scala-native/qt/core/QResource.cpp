#include "QResource.hpp"
#include <qt5/QtCore/QResource>
#include <qt5/QtCore/QString>

void q_resource_register_resource(q_string rccFile) {
  QResource::registerResource(*((QString*) rccFile));
  return;
}