## OOM Metaspace Reasons
1) Using custom classloader.
2) Incorrect Metaspace size.

Metaspace leaks are mostly due to coding fault and hard to fix.

## Steps To Collect Evidences
Similar to OOM heapspace, enable auto dump flag at JVM argument, _-XX:+HeapDumpOnOutOfMemoryError_

Note : The meta space by default 64MB on 32-bit and ~80MB on 64-bit. You can configure metaspace by using _-XX:MaxMetaspaceSize=128m_ [More Info](https://dzone.com/articles/java-8-permgen-metaspace)


## Generate OOM
Run the program and generate OOM with below command. Here max metaspace is set to 25MB. The program will load approx 5K classes.
```
java -XX:+HeapDumpOnOutOfMemoryError -XX:VMThreadStackSize=5m -Xss5m -Xmx1024m -XX:MaxMetaspaceSize=25m -jar high-memory-0.0.1-SNAPSHOT-jar-with-dependencies.jar cll
```
This will create a _java_pid<xxxxx>.hprof_ in the current directory.

## Analysis
Now its time analyze the dump with Eclipse MAT. 


