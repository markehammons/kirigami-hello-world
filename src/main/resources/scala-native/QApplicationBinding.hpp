#ifdef __cplusplus
#define EXTERNC extern "C"
#else 
#define EXTERNC 
#endif

typedef void* qapplication_type_t;
EXTERNC qapplication_type_t qapplication_init(int argc, char *argv[]);

EXTERNC int qapplication_exec(qapplication_type_t qapplication);

#undef EXTERNC