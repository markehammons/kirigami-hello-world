#include "QString.hpp"
#ifdef __cplusplus
#define EXTERNC extern "C"
#else 
#define EXTERNC 
#endif

EXTERNC void q_core_application_set_organization_name(const q_string orgName);
EXTERNC void q_core_application_set_organization_domain(const q_string orgDomain);
EXTERNC void q_core_application_set_application_name(const q_string application);

#undef EXTERNC
