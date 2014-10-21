springegg
=========

Output, when I invoke the rest call, with 5 concurrent thread.
Endpoint: http://localhost:8080/springegg/spsa/weather
Method: POST

Console Output:
==============
SPSA - Pre Handle
SPSA - Pre Handle
SPSA - Pre Handle
SPSA - Pre Handle
Before Sleep:Thread[http-bio-8080-exec-6,5,main]::d1b97890-4803-4680-a3d8-4c1e99e8cd11
SPSA - Pre Handle
Before Sleep:Thread[http-bio-8080-exec-4,5,main]::9194302c-0e3d-496e-b13e-926e633fd66c
Before Sleep:Thread[http-bio-8080-exec-3,5,main]::7733e245-3493-4fe7-ac5a-8e197fa4561c
Before Sleep:Thread[http-bio-8080-exec-5,5,main]::c9ee243a-d5c3-46ed-96c7-ded039cb77ef
Before Sleep:Thread[http-bio-8080-exec-7,5,main]::e8c6fb3e-073d-497d-bde9-63e87b32c81d
After Sleep:Thread[http-bio-8080-exec-6,5,main]::d1b97890-4803-4680-a3d8-4c1e99e8cd11
After Sleep:Thread[http-bio-8080-exec-4,5,main]::9194302c-0e3d-496e-b13e-926e633fd66c
After Sleep:Thread[http-bio-8080-exec-3,5,main]::7733e245-3493-4fe7-ac5a-8e197fa4561c
After Sleep:Thread[http-bio-8080-exec-5,5,main]::c9ee243a-d5c3-46ed-96c7-ded039cb77ef
After Sleep:Thread[http-bio-8080-exec-7,5,main]::e8c6fb3e-073d-497d-bde9-63e87b32c81d

Observation:
============
Usually, the "@AutoWired" will happen during instance creation, but here the "request" (Class variable) object is wired properly, for each & every method call..!!
All these due to Dynamic Proxy usage by spring framework.. 

