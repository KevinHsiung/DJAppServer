package com.khsiung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class KhsiungApplication {
	public static void main(String[] args) {
		SpringApplication.run(KhsiungApplication.class, args);
	}
}
