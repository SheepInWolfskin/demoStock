package com.example.demo.stock.client;

import com.example.demo.stock.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StockRepository extends MongoRepository<Stock, String>{
    @Query("{ 'fircodestname' : ?0 }")
    List<Stock> findByCode(String code);
//    List<Stock> getStock(String code);
//    Stock addStock(Stock stock);
}