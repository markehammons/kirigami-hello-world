#include <qt5/QtQuickControls2/QQuickStyle>
#include <qt5/QtCore/QString>
#include "QQuickStyle.hpp"

void q_quick_style_set_style(const q_string style) {
  QQuickStyle::setStyle(*((QString*) style));
  return;
}