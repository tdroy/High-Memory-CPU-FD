package com.troy;

import java.net.URL;
import java.net.URLClassLoader;

public class Demo extends ClassLoader {

	public static void startLeak() {
		try {
			while (true) {
		        URL[] classLoaderUrls = new URL[]{new URL("file:high-memory-0.0.1-SNAPSHOT-jar-with-dependencies.jar")};
		        URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls);
		        Class<?> beanClass = urlClassLoader.loadClass("com.mysql.cj.jdbc.DatabaseMetaData");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
