package br.com.springkafka.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CarDTO {

    private String id;
    private String name;
    private String brand;

}
