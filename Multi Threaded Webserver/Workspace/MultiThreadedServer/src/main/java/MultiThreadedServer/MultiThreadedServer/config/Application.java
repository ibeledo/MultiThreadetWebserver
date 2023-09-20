package MultiThreadedServer.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("MultiThreadedServer.persistence.repo")
@EntityScan("MultiThreadedServer.persistence.model")
@SpringBootApplication(scanBasePackages = {"MultiThreadedServer.controller"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
