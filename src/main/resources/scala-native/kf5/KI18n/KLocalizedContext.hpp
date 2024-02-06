#include "qt/core/QObject.hpp"

#ifdef __cplusplus
#define EXTERNC extern "C"
#else 
#define EXTERNC 
#endif

typedef void* k_localized_context;

EXTERNC k_localized_context k_localized_context_init(q_object parent);

#undef EXTERNC