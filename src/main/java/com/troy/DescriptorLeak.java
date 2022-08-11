package com.troy;

import java.io.File;
import java.io.FileReader;

import java.util.LinkedList;
import java.util.List;

public class DescriptorLeak {
	
	FileReader fr = null; 
	List<FileReader> frList = new LinkedList<FileReader>();

	public void startLoad()
	{
		new Thread(new Runnable()
		{
		public void run()
			{
				try {
			          for (int j=0; j < 500; j++ ) {    
						  fr = new FileReader(new File("pom.xml"));
						  frList.add(fr);
				          Thread.sleep(50);
				          //fr.close();
			          }
			    Thread.sleep(50000);
				}
				 catch (Exception e) {
					e.printStackTrace();
				 }
			}
		}).start();
	}
}
