package com.example.demo.stock.client;

import com.example.demo.stock.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StockRepository extends MongoRepository<Stock, String>{
    List<Stock> findByCode(String code);

    List<Stock> findByCodeAndDate(String code, String date);
}