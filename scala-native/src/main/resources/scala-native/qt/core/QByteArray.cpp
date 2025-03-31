#include <QByteArray>
#include "QByteArray.hpp"

q_byte_array q_byte_array_init(const char* data) {
  return new QByteArray(data);
}

void q_byte_array_destroy(q_byte_array array) {
  delete (QByteArray*) array;
  return;
}