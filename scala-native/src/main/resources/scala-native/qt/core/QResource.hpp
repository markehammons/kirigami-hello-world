#include "QString.hpp"

#ifdef __cplusplus
#define EXTERNC extern "C"
#else 
#define EXTERNC 
#endif

EXTERNC void q_resource_register_resource(q_string rccFileName);

#undef EXTERNC