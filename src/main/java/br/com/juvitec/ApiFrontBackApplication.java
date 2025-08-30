package br.com.juvitec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
// esta classe não cria a tela de Login (exclude = {SecurityAutoConfiguration.class})
//public class ApiFrontBackApplication(exclude = {SecurityAutoConfiguration.class})
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})   
public class ApiFrontBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFrontBackApplication.class, args);
	}

}
