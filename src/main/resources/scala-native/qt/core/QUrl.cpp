#include "QUrl.hpp"
#include <qt5/QtCore/QUrl>
#include <qt5/QtCore/QString>

q_url q_url_init(q_string url) {
  QString qstr = *((QString*) url);
  return new QUrl(qstr);
}

void q_url_destroy(q_url url) {
  delete (QUrl*) url;
}