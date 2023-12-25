package com.example.ds.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDTO {
    private String model;
    private String color;
    private String matricul;
    private Float price;

}