#include "QUrl.hpp"
#include <qt5/QtCore/QUrl>
#include <qt5/QtCore/QString>

q_url q_url_init(q_string url) {
  return new QUrl(*((QString*) url));
}

void q_url_destroy(q_url url) {
  delete (QUrl*) url;
}