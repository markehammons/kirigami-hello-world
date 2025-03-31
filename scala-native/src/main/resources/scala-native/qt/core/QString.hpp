typedef void* q_string;

#ifdef __cplusplus
#define EXTERNC extern "C"
#else 
#define EXTERNC 
#endif
EXTERNC q_string q_string_init(const char *string);
EXTERNC void q_string_destroy(q_string string);

#undef EXTERNC