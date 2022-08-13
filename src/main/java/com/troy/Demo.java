package com.troy;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Demo extends ClassLoader {

	@SuppressWarnings("resource")
	public static void startLeak() {
		try {
	
/*		    while (true) {
		        URL[] classLoaderUrls = new URL[]{new URL("file:high-memory-0.0.1-SNAPSHOT-jar-with-dependencies.jar")};
		        URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls);
		        Class<?> beanClass = urlClassLoader.loadClass("com.mysql.cj.jdbc.DatabaseMetaData");
			}*/
			String jarPath = "high-memory-0.0.1-SNAPSHOT-jar-with-dependencies.jar";
			String CLASS_FILE_EXTENSION = ".class";
			
            JarFile jarFile = new JarFile(jarPath);
            Enumeration<JarEntry> jarEntries = jarFile.entries();

            URLClassLoader cl = URLClassLoader.newInstance(new URL[] { new URL("jar:file:" + jarPath + "!/") });

            while (jarEntries.hasMoreElements()) {
                JarEntry jarEntry = jarEntries.nextElement();

                if (jarEntry.isDirectory() || !jarEntry.getName().endsWith(CLASS_FILE_EXTENSION) || jarEntry.getName().startsWith("META-INF")) {
                    continue;
                }

                String className = jarEntry.getName().substring(0, jarEntry.getName().length() - 6).replace('/','.');
                try {
                	cl.loadClass(className);
                }catch (NoClassDefFoundError e) {
                	//Some debug line by troy.
                }
            }
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
