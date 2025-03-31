#include "../core/QObject.hpp"

#ifdef __cplusplus
#define EXTERNC extern "C"
#else 
#define EXTERNC 
#endif

typedef void* q_qml_context;

EXTERNC void q_qml_context_set_context_object(q_qml_context qml_context, q_object object);

#undef EXTERNC