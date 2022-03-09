package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {

		// controller req json(text) -> object
		// response object -> json(text)

		var objectMapper = new ObjectMapper();
		// Object -> Text JSON
		// object mapper 는 클래스의 getter 메서드를 필요로 한다.
		var user = new User("steve", 10, "010-1111-2222");
		var text = objectMapper.writeValueAsString(user);
		System.out.println(text);

		// Text JSON -> Object
		// object mapper 는 클래스의 default 생성자를 필요로 한다.
		var objectUser = objectMapper.readValue(text, User.class);
		System.out.println(objectUser);
	}

}
