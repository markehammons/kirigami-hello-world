#ifdef __cplusplus
#define EXTERNC extern "C"
#else 
#define EXTERNC 
#endif

typedef void* q_byte_array;

EXTERNC q_byte_array q_byte_array_init(const char* data);
EXTERNC void q_byte_array_destroy(q_byte_array array);

#undef EXTERNC