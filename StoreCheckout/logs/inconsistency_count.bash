#!/bin/bash

reads=`awk -F, '$7 == "Read"' migrationLog.csv | wc -l`
echo "Reads = "  $reads

readInconsistencies=`awk -F, '$7 == "Read Inconsistency"' migrationLog.csv | wc -l`
echo "Read Inconsistencies = "  $readInconsistencies

readRatio=$(echo "scale=2; (1 - $readInconsistencies / $reads) *100" | bc -l)
echo "Read Consistency = " $readRatio "%"

writes=`awk -F, '$7 == "Write"' migrationLog.csv | wc -l`
echo "Writes = "  $writes

writeInconsistencies=`awk -F, '$7 == "Write Inconsistency"' migrationLog.csv | wc -l`
echo "Write Inconsistencies = "  $writeInconsistencies

writeRatio=$(echo "scale=2; (1 - $writeInconsistencies / $writes) *100" | bc -l)
echo "Write Consistency = " $writeRatio "%"

consistencyRatio=$(echo "scale=2; (1 - ($writeInconsistencies + $readInconsistencies) / ($writes + $reads)) *100" | bc -l)
echo "Consistency = " $consistencyRatio "%"






