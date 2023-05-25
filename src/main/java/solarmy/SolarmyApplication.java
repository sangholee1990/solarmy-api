package solarmy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolarmyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolarmyApplication.class, args);
		System.err.println("============================ Reloaded ============================");
	}

}
