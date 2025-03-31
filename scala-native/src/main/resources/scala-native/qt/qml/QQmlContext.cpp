#include "QQmlContext.hpp"
#include <qt5/QtQml/QQmlContext>

void q_qml_context_set_context_object(q_qml_context qml_context, q_object object) {
  ((QQmlContext*) qml_context)->setContextObject((QObject*) object);
  return;
}