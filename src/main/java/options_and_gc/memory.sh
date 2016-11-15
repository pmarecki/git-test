#Java options and memory profiling

jps

(every 100 ms; 1000 times; OC: current max heap size; OU: current utilization [commitet heap] (-Xmx is max OC achievable [maximum heap]);
O: % of OC used; FGC: full GC event count; GCT= gc total duration)
 
# Full heap = young generation (eden) + old generation (true long-persistent objects) 
-XX:NewRatio=3   --> 1GB eden + 3GB old
----------------------------
gc flow: eden >> old
YGC  = young generation gc
FGC  = full gc (old)
------------------------

jstat -gccapacity <pid>
# OGC, OC == size of old gen; OGCMX == max old gen
# (old + eden < Xmx)

jstat -gcutil <pid>
# E = eden(%), O = old(%); E^^100% --> YGC event, E=0%; O grows very slowly 

# Nice commands:
jstat -gcutil -h15 <pid> 500 1000  #watch as E grows, and as O grows slowly
jstat -gccapacity <pid>            #


#O grows to ~85%; then OC start to grow up to OGCMX, then O will grow to 100% and crash may occurr
