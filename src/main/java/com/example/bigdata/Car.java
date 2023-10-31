package com.example.bigdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car{
    private String brand;
    private int price;

//    public Car(){}
//    public Car(String brand, int price){
//        this.brand = brand;
//        this.price = price;
//    }
}
