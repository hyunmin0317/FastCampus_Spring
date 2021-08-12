package com.example.springioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
public class SpringIocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIocApplication.class, args);
		ApplicationContext context = ApplicationContextProvider.getContext();

//		Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//		UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

		String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
		Encoder encoder = context.getBean("base64Encode", Encoder.class);
		String result = encoder.encode(url);
		System.out.println(result);

		Encoder encoder2 = context.getBean("urlEncode", Encoder.class);
		String result2 = encoder2.encode(url);
		System.out.println(result2);
	}
}

@Configuration
class AppConfig {

	@Bean("base64Encode")
	public Encoder encoder(Base64Encoder base64Encoder){
		return new Encoder(base64Encoder);
	}

	@Bean("urlEncode")
	public Encoder encoder(UrlEncoder urlEncoder){
		return new Encoder(urlEncoder);
	}
}