## File Descriptor
Based on operating system whenever a file read/write, kernel keep the reference of the loaded file. This also true for Sockets and threads. 
On windows file descriptors are knows as _handles_

## Configuration & impact
On unix based system, descriotrs are listed with _ulimit_ command. By default a process can open 1024 descriptors. Descriptors are kept inside _/proc/<PID>/fd_ directory.

Very high number of open descriptor will rapidly increase IO calls, and bring down the system.
  
## Generate File Descriptor Leak
Run the program and generate Descriptor leak with below command. Here using the default ulimit 1024.
```
java -XX:+HeapDumpOnOutOfMemoryError -XX:VMThreadStackSize=5m -Xss5m -Xmx1024m -XX:MaxMetaspaceSize=25m -jar high-memory-0.0.1-SNAPSHOT-jar-with-dependencies.jar fdl
```

## Analysis
Go to _/proc/<<PID>>/fd_ and list the directory. Find out which file is loaded maximum number of time.
Reach out to dev team for detail RCA.

