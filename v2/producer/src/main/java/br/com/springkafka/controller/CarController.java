package br.com.springkafka.controller;

import br.com.springkafka.Car;
import br.com.springkafka.dto.CarDTO;
import br.com.springkafka.producer.CarProducer;
import io.swagger.models.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {

    private final CarProducer carProducer;
    
    public ResponseEntity<Void> sendMessage(@RequestBody CarDTO carDTO){
        var id = UUID.randomUUID().toString();
        var message = Car.newBuilder().setId(id).setName(carDTO.getName()).setBrand(carDTO.getBrand()).build();

        carProducer.sendMessage(message);

        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
