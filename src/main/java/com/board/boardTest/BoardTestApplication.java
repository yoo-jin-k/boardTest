package com.board.boardTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@Slf4j
@ServletComponentScan
@SpringBootApplication
public class BoardTestApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		log.info("========** Board Application start **=======");
		SpringApplication springApplication = new SpringApplication(BoardTestApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
		log.info("========** Board Application end **=======");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BoardTestApplication.class);
	}

}
