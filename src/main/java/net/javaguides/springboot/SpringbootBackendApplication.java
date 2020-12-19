package net.javaguides.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Value(value = "${spring.datasource.url}")
	String dbName;

	@Override
	public void run(String... arg0) throws Exception{
		System.out.println("*************"+dbName+"*******************");
	}

}