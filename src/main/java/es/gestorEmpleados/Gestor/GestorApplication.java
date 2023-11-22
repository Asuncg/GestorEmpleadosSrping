package es.gestorEmpleados.Gestor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class GestorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorApplication.class, args);
	}

}
