package net.javaguides.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.javaguides.springboot.controller.EmployeeController;

@SpringBootTest
class SpringbootBackendApplicationTests {

	@Autowired
	private EmployeeController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
	