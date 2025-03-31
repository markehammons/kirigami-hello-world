#include <KF5/KI18n/KLocalizedContext>
#include "KLocalizedContext.hpp"

k_localized_context k_localized_context_init(q_object parent)
{
  return new KLocalizedContext((QObject *)parent);
}

void k_localized_context_destroy(k_localized_context context) {
  delete (KLocalizedContext*) context;
  return;
}