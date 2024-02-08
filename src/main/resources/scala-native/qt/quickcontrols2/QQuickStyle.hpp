#include "../core/QString.hpp"
#ifdef __cplusplus
#define EXTERNC extern "C"
#else 
#define EXTERNC 
#endif

typedef void* q_quick_style;

EXTERNC void q_quick_style_set_style(const q_string style);

#undef EXTERNC