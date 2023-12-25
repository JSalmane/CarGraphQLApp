package com.example.ds.service.mappers;

import com.example.ds.dao.entities.Car;
import com.example.ds.service.dtos.CarDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    private final ModelMapper modelMapper;

    public CarMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CarDTO convertToDTO(Car car) {
        return modelMapper.map(car, CarDTO.class);
    }

    public Car convertToEntity(CarDTO carDTO) {
        return modelMapper.map(carDTO, Car.class);
    }
}
