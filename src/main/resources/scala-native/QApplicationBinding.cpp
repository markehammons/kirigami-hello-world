#include <qt5/QtWidgets/QApplication>
#include "QApplicationBinding.hpp"

qapplication_type_t qapplication_init(int argc, char *argv[]) {
  
  QApplication* app = new QApplication(argc, argv);
  return app;
}

int qapplication_exec(qapplication_type_t qapplication) {
  QApplication* app = (QApplication*) qapplication;
  return app->exec();
}