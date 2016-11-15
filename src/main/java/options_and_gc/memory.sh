#Java options and memory profiling

jps
jstat -gcold <pid> 100 1000

(every 100 ms; 1000 times; OC: current max heap size; OU: current utilization [commitet heap] (-Xmx is max OC achievable [maximum heap]);
O: % of OC used; FGC: full GC event count; GCT= gc total duration)
 
 Full heap = young generation (eden + rest) + old generation (true long-persistent objects) 
-XX:NewRatio=3   --> 1GB eden + 3GB old
----------------------------
gc flow: eden >> old
YGC  = young generation gc
FGC  = full gc (old)
------------------------

jstat -gccapacity <pid>
OGCMN/OGCMX -- old gen current sizes (together with Eden < Xmx)
