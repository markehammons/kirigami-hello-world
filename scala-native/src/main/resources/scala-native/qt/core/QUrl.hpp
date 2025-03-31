#include "QString.hpp"

#ifdef __cplusplus
#define EXTERNC extern "C"
#else 
#define EXTERNC 
#endif

typedef void* q_url;

EXTERNC q_url q_url_init(q_string url);
EXTERNC void q_url_destroy(q_url url);

#undef EXTERNC