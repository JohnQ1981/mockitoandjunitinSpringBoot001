package com.in28002.junit.junit002;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations= {"classpath:test-configuration.properties"})
class Junit002ApplicationTests {

	@Test
	void contextLoads() {
	}

}
