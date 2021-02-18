package test.db2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import test.db2.controllers.UserController;

@SpringBootApplication
public class SpringBootDb2Application {

	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDb2Application.class, args);
		log.info("Application up");
	}
}
