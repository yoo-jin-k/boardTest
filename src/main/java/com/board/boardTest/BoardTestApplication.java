package com.board.boardTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BoardTestApplication {

	public static void main(String[] args) {
		log.info("========** Board Application start **=======");
		SpringApplication springApplication = new SpringApplication(BoardTestApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
		log.info("========** Board Application end **=======");
	}

}
