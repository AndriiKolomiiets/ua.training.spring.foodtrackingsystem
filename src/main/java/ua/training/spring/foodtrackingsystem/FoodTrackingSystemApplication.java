package ua.training.spring.foodtrackingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FoodTrackingSystemApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
        return app.sources(FoodTrackingSystemApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FoodTrackingSystemApplication.class, args);
    }

}
