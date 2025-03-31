#include <qt5/QtCore/QList>
#include "QList.hpp"

char q_list_is_empty(q_list list) {
  return ((QList<void*>*)list)->isEmpty();
}