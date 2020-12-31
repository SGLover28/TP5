package AENSIMLH.TP5;

import AENSIMLH.TP5.model.Coordinates;
import org.apache.naming.factory.BeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Tp5Application {

	public static void main(String[] args) {

		SpringApplication.run(Tp5Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public Coordinates coordinates(){
		Coordinates coordinates = new Coordinates();
		return coordinates;
	}
	@Autowired
	Coordinates coordinates;

	@Bean
	public String nom(){
		String nom = "World";
		return nom;
	}








}


