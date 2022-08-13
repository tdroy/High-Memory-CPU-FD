## High-Memory-CPU-FD
Purpose of this project to crash JVM and find the RCA.

Note : assuming readers already familiar with GC, heap allocation, multithreading etc.

## Use Case
1) [Out Of Memory : heapspace](doc/OutOfMemory-heapspace.md)
2) [Out Of Memory : metaspace](doc/OutOfMemory-metapace.md)
3) [Stack Overflow](doc/StackOverflow.md)
4) [File Descriptor Leak](doc/FileDescriptorLeak.md)
5) [High CPU Usgae](doc/HighCpuUsage.md)

## Build Project
1) Clone or download the project.
2) In a terminal goto the downloaded directory.
3) Run ```mvn test```
4) This will produce _high-memory-0.0.1-SNAPSHOT-jar-with-dependencies.jar_ under target folder.

## Run project
1) Execute below command
```
java -XX:+HeapDumpOnOutOfMemoryError -XX:VMThreadStackSize=5m -Xss5m -Xmx1024m -XX:MaxMetaspaceSize=55m -jar high-memory-0.0.1-SNAPSHOT-jar-with-dependencies.jar help
```
2) Utility takes below arguments.
```
1. OOM : Generate Out of Memory heap space.
2. SOF : Generate StackOverFlow error.
3. CLL : Class loader leak, OOM metaspace
4. FDL : File descriptor limit, Too many open file.
5. CPU : Create high CPU usgae.
6. help : Help option.
```

## MAT (Memory Analyzer Tool) 
We are going to use Eclipse MAT to analyse the dumps. [MAT](https://www.eclipse.org/mat/downloads.php)
 
