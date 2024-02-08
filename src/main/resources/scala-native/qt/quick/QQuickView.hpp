#include "../core/QUrl.hpp"
#ifdef __cplusplus
#define EXTERNC extern "C"
#else 
#define EXTERNC 
#endif

typedef void* q_quick_view;

EXTERNC q_quick_view q_quick_view_init();
EXTERNC void q_quick_view_destroy(q_quick_view view);
EXTERNC void q_quick_view_load(q_url url);

#undef EXTERNC