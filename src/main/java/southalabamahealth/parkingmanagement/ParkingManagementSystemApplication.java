package southalabamahealth.parkingmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
@ComponentScan(basePackages = { "southalabamahealth.parkingmanagement", "southalabamahealth.parkingmanagement.api" , "southalabamahealth.parkingmanagement.configuration"})
public class ParkingManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingManagementSystemApplication.class, args);
	}

}
