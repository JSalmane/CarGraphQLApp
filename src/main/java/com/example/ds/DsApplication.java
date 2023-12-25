package com.example.ds;

import com.example.ds.dao.entities.Car;
import com.example.ds.dao.repositories.ICarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Bean
	public CommandLineRunner start(ICarRepository carRepository){
		return args ->{
			Car car = Car.builder().model("ferrari").price(199999F).color("red").matricul("hello").build();
			Car car1 = Car.builder().model("mclaren").price(299900F).color("black").matricul("hi").build();
			Car car2 = Car.builder().model("lamborghini").price(359000F).color("yellow").matricul("hey").build();
			Car car3 = Car.builder().model("bugatti").price(369999F).color("blue").matricul("aloha").build();

			carRepository.saveAll(List.of(car,car1,car2,car3));
		};
	}

}
