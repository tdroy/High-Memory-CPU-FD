package com.troy;

import java.util.LinkedList;
import java.util.List;

public class MemoryLeak extends Thread{
	
	public MemoryLeak() {
		//setting the thread name to 'Troy-OOM'
		super("Troy-MemoryLeak");
	}

	@Override
	public void run() {
		createLeak();
	}

	public void createLeak() {	
		Long maxMemoryMB = Runtime.getRuntime().maxMemory()/(1024 * 1024); 
		
		List<byte []> runList = new LinkedList<byte []>();
		
		while(true) {
	
		    byte b[] = new byte[1048576];
		    runList.add(b);
	
			Long memoryUsed  = ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() ) / (1024 * 1024);
			System.out.print( "Memory usage : "  + (memoryUsed * 100) / maxMemoryMB  + "% \r");
		}	
	} 
}
