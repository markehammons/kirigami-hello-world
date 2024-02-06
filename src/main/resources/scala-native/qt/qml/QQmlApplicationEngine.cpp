#include <qt5/QtQml/QQmlApplicationEngine>
#include <qt5/QtCore/QUrl>
#include "QQmlApplicationEngine.hpp"

q_qml_application_engine q_qml_application_engine_init()
{
  q_qml_application_engine ptr = new QQmlApplicationEngine();
  return ptr;
}

q_qml_context q_qml_application_engine_root_context(q_qml_application_engine application_engine)
{
  return ((QQmlApplicationEngine *)application_engine)->rootContext();
}

void q_qml_application_engine_destroy(q_qml_application_engine application_engine)
{
  delete (QQmlApplicationEngine *)application_engine;
  return;
}

void q_qml_application_engine_load(q_qml_application_engine application_engine,
                                   q_url path)
{
  ((QQmlApplicationEngine *)application_engine)->load(*((QUrl *)path));
  return;
}

q_list q_qml_application_engine_root_objects(q_qml_application_engine application_engine)
{
  QList<QObject*>* list = new QList<QObject*>(((QQmlApplicationEngine *)application_engine)->rootObjects());
  
  return list;
}