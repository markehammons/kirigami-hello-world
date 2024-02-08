#include "QQmlContext.hpp"
#include "../core/QUrl.hpp"
#include "../core/QList.hpp"

#ifdef __cplusplus
#define EXTERNC extern "C"
#else 
#define EXTERNC 
#endif

typedef void* q_qml_application_engine;

EXTERNC q_qml_application_engine q_qml_application_engine_init();
EXTERNC q_qml_context q_qml_application_engine_root_context(q_qml_application_engine application_engine);
EXTERNC void q_qml_application_engine_destroy(q_qml_application_engine application_engine);
EXTERNC void q_qml_application_engine_load(q_qml_application_engine application_engine, q_url path);  
EXTERNC q_list q_qml_application_engine_root_objects(q_qml_application_engine application_engine);

#undef EXTERNC