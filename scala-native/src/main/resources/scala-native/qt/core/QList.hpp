#ifdef __cplusplus
#define EXTERNC extern "C"
#else 
#define EXTERNC 
#endif

typedef void* q_list;

EXTERNC char q_list_is_empty(q_list list);
#undef EXTERNC