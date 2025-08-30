package hamit.demir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TmoRestoranPaneliApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmoRestoranPaneliApplication.class, args);
    }

}
