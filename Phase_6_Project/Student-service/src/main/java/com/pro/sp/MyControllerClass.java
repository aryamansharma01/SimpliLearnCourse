package com.pro.sp;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8081/
@Slf4j
@RestController
public class MyControllerClass {
	
	Logger log=LoggerFactory.getLogger(MyControllerClass.class);

	@GetMapping("/name")
	public String myName() {
		LocalDateTime localDateTime = LocalDateTime.now();
		log.info("Name Page at " + localDateTime);
		return "Application developed by Aryaman Sharma.";
	}
	
	@GetMapping("/tech")
	public String mytech() {
		LocalDateTime localDateTime = LocalDateTime.now();
		log.info("Tech Page at " + localDateTime);
		return "Spring boot is used here !";
	}
	
	@GetMapping("/data")
	public String data() {
		LocalDateTime localDateTime = LocalDateTime.now();
		log.info("Data Page at " + localDateTime);
		return "This is the data page";
	}
}
