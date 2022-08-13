package com.troy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Run {	
	
	final static Logger logger =  LogManager.getLogger(Run.class);
 
	public static void main(String[] args) throws InterruptedException {

		logger.info("******************************************");
		logger.info("**** High Memory Usage Troubleshootin ****");
		logger.info("****     Memory leak usecase demo.    ****");
		logger.info("****        	By Tanmoy Roy.         ****");
		logger.info("******************************************");

		if (args.length == 0 || args.length > 1 || args[0].equalsIgnoreCase("help")) {
			System.out.println("Invalid options.");
			System.out.println("Usage : java -XX:+HeapDumpOnOutOfMemoryError -Xss5m -Xmx150m -XX:MaxMetaspaceSize=55m -jar high-memory-0.0.1-SNAPSHOT-jar-with-dependencies.jar <options>");
			System.out.println("Options :");
			System.out.println("1. OOM : Generate Out of Memory heap space.");
			System.out.println("2. SOF : Generate StackOverFlow error.");
			System.out.println("3. CLL : Class loader leak, OOM metaspace");
			System.out.println("4. FDL : File descriptor limit, Too many open file.");
			System.out.println("5. CPU : Create high CPU usgae.");
			System.exit(0);
		}
		
		if (args[0].equalsIgnoreCase("OOM")) {
			MemoryLeak ml = new MemoryLeak();
			ml.start();
		}
		
		if (args[0].equalsIgnoreCase("SOF")) {
			System.out.println("Generating Stack Overflow...");
			StackOverFlow sof = new StackOverFlow();
			sof.methodA();
		}
		
		if (args[0].equalsIgnoreCase("CLL")) {
			System.out.println("Generating Metaspace leak...");
			ClassLoaderLeak cll = new ClassLoaderLeak();
			cll.startClassLoader();
		}
		
		if (args[0].equalsIgnoreCase("FDL")) {
			System.out.println("Generating File descriptor leak...");
			DescriptorLeak dl = new DescriptorLeak();
			for (int i=0; i < 100; i++)
				dl.startLoad();
		}
		
		if (args[0].equalsIgnoreCase("CPU")) {
			System.out.println("Generating High CPU Load...");
			HighCpu hc = new HighCpu();
			hc.startCpuLoad();
		}
		
		if(!args[0].equalsIgnoreCase("CLL") && !args[0].equalsIgnoreCase("SOF") && !args[0].equalsIgnoreCase("OOM")
				&& !args[0].equalsIgnoreCase("FDL") && !args[0].equalsIgnoreCase("CPU")) {
			System.out.println("Please refer to usage.");
		}
	}
}
