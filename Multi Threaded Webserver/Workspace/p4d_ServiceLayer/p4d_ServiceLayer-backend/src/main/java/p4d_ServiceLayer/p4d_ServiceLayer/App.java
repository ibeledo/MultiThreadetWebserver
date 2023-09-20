package p4d_ServiceLayer.p4d_ServiceLayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public RouterFunction<?> routes(WelcomeHandler welcomeHandler, GreetingHandler greetingHandler) {
        return welcomeHandler.routes()
            .and(greetingHandler.routes());
    }
}

