package com.troy;

import java.util.LinkedList;
import java.util.List;

public class ClassLoaderLeak {
	static List<byte []> list = new LinkedList<byte []>();
	
	public void startClassLoader() {
		
		while(true) {
			Leak l1 = new Leak("Troy-ClassLoader-Leak");
			l1.start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	public class Leak extends Thread {
		
		List<Demo> list = new LinkedList<Demo>();
		
		public Leak(String name) {
			super(name);
		}

		@Override
		public void run() {
			try {
				while(true) {
					Demo demo = new Demo();
					Demo.startLeak();
					list.add(demo);
					Thread.sleep(90000);
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
}


