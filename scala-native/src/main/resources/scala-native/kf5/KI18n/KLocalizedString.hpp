#include "../../qt/core/QByteArray.hpp"

#ifdef __cplusplus
#define EXTERNC extern "C"
#else 
#define EXTERNC 
#endif

EXTERNC void k_localized_string_set_application_domain(q_byte_array domain);

#undef EXTERNC