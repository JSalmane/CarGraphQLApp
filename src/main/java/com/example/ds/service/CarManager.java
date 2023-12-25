package com.example.ds.service;


import com.example.ds.service.dtos.CarDTO;

import java.util.List;

public interface CarManager {
    public List<CarDTO> getCarByModel(String model);
    public List<CarDTO> getCarByModelAndPrice(String model,Float price);

    public CarDTO saveCar(CarDTO carDTO);
    public CarDTO deleteCar(Long id);

}