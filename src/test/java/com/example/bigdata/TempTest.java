package com.example.bigdata;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;

import com.example.bigdata.Car;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TempTest {

    @Test
    void HelloworldTest(){
        System.out.println("hello world jaejung");
    }

    @Test
    void ObectMapperTest() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String carJson = "{ \"brand\": \"Mercedes\", \"price\": 100}";
        Car car = new Car("gekki", 123);
        System.out.println(car);
        byte[] bytes = carJson.getBytes("UTF-8");
        // byte[] bytes = objectMapper.writeValueAsBytes(car);
        System.out.println(bytes);
        car = objectMapper.readValue(bytes, Car.class);
        System.out.println(car);
        // System.out.println(car);
        // car.setBrand("carJson");
        // car.setPrice(123);
        // System.out.println(car);
    }
}
