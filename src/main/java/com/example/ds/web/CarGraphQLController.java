package com.example.ds.web;


import com.example.ds.service.CarManager;
import com.example.ds.service.dtos.CarDTO;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CarGraphQLController {

    private final CarManager carManager;


    public CarGraphQLController(CarManager carManager) {
        this.carManager = carManager;
    }

    @QueryMapping
    public List<CarDTO> getCarByModel(@Argument String title){
        return carManager.getCarByModel(title);
    }
    @QueryMapping
    public List<CarDTO> getCarByModelAndPrice(@Argument String model, @Argument Float price){
        return carManager.getCarByModelAndPrice(model,price);
    }
    @MutationMapping
    public CarDTO saveCook(@Argument CarDTO car){
        return carManager.saveCar(car);
    }
    @MutationMapping
    public CarDTO delete(@Argument Long id){
        return carManager.deleteCar(id);
    }
}
