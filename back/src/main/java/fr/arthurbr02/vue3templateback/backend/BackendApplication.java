package fr.arthurbr02.vue3templateback.backend;

import fr.arthurbr02.vue3templateback.backend.core.flyway.FlywayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackendApplication {
	@Autowired
	private static FlywayService flywayService;

	public static void main(String[] args) {
//		flywayService.migrate();
		SpringApplication.run(BackendApplication.class, args);
	}

}
