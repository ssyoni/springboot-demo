package com.demo.study.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@SpringBootApplication
public class SpringbootDemoApplication {
	/* @RestController : @Controller와 @ResponseBody를 합쳐놓은 역할을 수행. 어노테이션을 사용하면 스프링은 반환값이 Response Body 부분에 자동 바인딩 된다. 
						 스프링에서 RESTful 웹 서비스를 만들 때 주로 사용됨.
	   @GetMapping : Get 방식으로 경로를 받는 매핑 어노테이션. value값 별도지정 없을 경우 기본값인 빈 값("")이 들어간다.
	*/
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
	
	@GetMapping
	public String HelloWorld(){
		return "Hello World";
	}

}
