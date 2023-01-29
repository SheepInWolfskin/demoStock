package com.example.demo.stock;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
@CompoundIndex(def = "{'code': 1, 'date': 1}", unique = true)
public class Stock {
    @Id
    private String id;
    private String code;
    private String date;

    public Stock() {}

    public Stock(String code, String date) {
        this.id = UUID.randomUUID().toString();
        this.code = code;
        this.date = date;
    }

}
