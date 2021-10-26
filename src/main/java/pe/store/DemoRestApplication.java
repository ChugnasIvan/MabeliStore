package pe.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoRestApplication {

	public static void main(String[] args) {
		System.out.println("Arrancando Demo Rest");
		SpringApplication.run(DemoRestApplication.class, args);
		System.out.println("Fin de arranque!!");
	}

}
