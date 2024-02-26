package citybike.HelsinkiCitybikeBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.baeldung.dependency.exception"})
public class HelsinkiCitybikeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelsinkiCitybikeBackendApplication.class, args);
	}

}
