package com.example.ds.service;

import com.example.ds.dao.entities.Car;
import com.example.ds.dao.repositories.ICarRepository;
import com.example.ds.service.dtos.CarDTO;
import com.example.ds.service.mappers.CarMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CarManagerAction implements CarManager {
    private final ICarRepository iCarRepository;
    private final CarMapper mapper;

    public CarManagerAction(ICarRepository iCarRepository, CarMapper mapper) {
        this.iCarRepository = iCarRepository;
        this.mapper = mapper;
    }


    @Override
    public List<CarDTO> getCarByModel(String model) {
        return iCarRepository.findCarsByModel(model).stream().map(mapper::convertToDTO).collect(Collectors.toList());
    }



    @Override
    public List<CarDTO> getCarByModelAndPrice(String model, Float price) {
        return iCarRepository.findCarsByModelAndPrice(model,price).stream().map(mapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public CarDTO saveCar(CarDTO carDTO) {
        Car car = mapper.convertToEntity(carDTO);
        boolean exist = iCarRepository.existsCarByMatricul(car.getModel());
        if (exist){
            throw new RuntimeException("car exist with this model");
        }
        Car car1 = iCarRepository.save(car);
        return mapper.convertToDTO(car1);
    }

    @Override
    public CarDTO deleteCar(Long id) {
        Car car = iCarRepository.findById(id).orElseThrow(()->new RuntimeException("car doesn't exist"));
        iCarRepository.deleteById(id);
        return mapper.convertToDTO(car);
    }
}
