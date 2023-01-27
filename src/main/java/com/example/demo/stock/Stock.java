package com.example.demo.stock;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Stock {
    @Id
    private Long id;
    private String code;
    private String date;

    public Stock() {}

    public Stock(String code, String date) {
        this.code = code;
        this.date = date;
    }

}
