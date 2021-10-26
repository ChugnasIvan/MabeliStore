package pe.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MabeliStoreRestApplication {

	public static void main(String[] args) {
		System.out.println("Arrancando Demo");
		SpringApplication.run(MabeliStoreRestApplication.class, args);
		System.out.println("Fin de arranque!!");
	}

}
