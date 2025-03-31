#include <qt5/QtWidgets/QApplication>
#include "QApplicationBinding.hpp"

qapplication_type_t qapplication_init(int argc, char **argv) {
  int count = 0;
  return new QApplication(count, NULL);
}

int qapplication_exec(qapplication_type_t qapplication) {
  QApplication* app = (QApplication*) qapplication;
  return app->exec();
}