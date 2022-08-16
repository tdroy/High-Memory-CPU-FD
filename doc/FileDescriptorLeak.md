## File Descriptor
Based on operating system whenever a file read/write, kernel keep the reference of the loaded file. This also true for Sockets and threads. 
On windows file descriptors are knows as _handles_

## Configuration & impact
On unix based system, descriotrs are listed with _ulimit_ command. By default a process can open 1024 descriptors. Descriptors are kept inside _/proc/<PID>/fd_ directory.

Very high number of open descriptor will rapidly increase IO calls, and bring down the system.
  
## Generate File Descriptor Leak



