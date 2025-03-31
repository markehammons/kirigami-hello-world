#include "QString.hpp"
#include <qt5/QtCore/QString>

q_string q_string_init(const char* string) {
  return new QString(string);
}

void q_string_destroy(q_string q_string) {
  delete (QString*) q_string;
  return;
}