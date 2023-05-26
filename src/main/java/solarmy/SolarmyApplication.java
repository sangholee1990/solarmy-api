package solarmy;

import java.text.NumberFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import solarmy.front.controller.MainController;

@SpringBootApplication
public class SolarmyApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SolarmyApplication.class, args);
		System.err.println("============================ Reloaded ============================");
		
		Runtime runtime = Runtime.getRuntime();
		 
	    final NumberFormat format = NumberFormat.getInstance();
	 
	    final long maxMemory = runtime.maxMemory();
	    final long allocatedMemory = runtime.totalMemory();
	    final long freeMemory = runtime.freeMemory();
	    final long mb = 1024 * 1024;
	    final String mega = " MB";
	 
	    log.info("========================== Memory Info ==========================");
	    log.info("Free memory: " + format.format(freeMemory / mb) + mega);
	    log.info("Allocated memory: " + format.format(allocatedMemory / mb) + mega);
	    log.info("Max memory: " + format.format(maxMemory / mb) + mega);
	    log.info("Total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / mb) + mega);
	    log.info("=================================================================\n");
	    
	    System.out.println("========================== Memory Info ==========================");
	    System.out.println("Free memory: " + format.format(freeMemory / mb) + mega);
	    System.out.println("Allocated memory: " + format.format(allocatedMemory / mb) + mega);
	    System.out.println("Max memory: " + format.format(maxMemory / mb) + mega);
	    System.out.println("Total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / mb) + mega);
	    System.out.println("=================================================================\n");
	}

}
