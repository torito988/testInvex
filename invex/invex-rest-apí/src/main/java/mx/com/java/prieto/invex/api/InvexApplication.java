package mx.com.java.prieto.invex.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "mx.com.java.prieto.*")
@EnableJpaRepositories("mx.com.java.prieto.persistence.repository")
@EntityScan("mx.com.java.prieto.persistence.entity")
public class InvexApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvexApplication.class, args);
	}

}
