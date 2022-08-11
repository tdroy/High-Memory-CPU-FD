package com.troy;

public class HighCpu {
	
	public void startCpuLoad() {
		int cores = Runtime.getRuntime().availableProcessors();
		for (int i=0; i < cores; i++)
	    {
	       Thread x=new Thread(new Runnable(){
	    	   public void run()
	                    {
	                       double val=10;
	                       for (;;)
	                         {
	                            Math.atan(Math.sqrt(Math.pow(val, 10)));
	                         }
	                     }
	              });
	  
	        x.start();
	    }
	}

}
