package com.example.ds.dao.repositories;

import com.example.ds.dao.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarsByModel(String model);
    List<Car> findCarsByModelAndPrice(String model,double price);
    boolean existsCarByMatricul(String matricul);
}
