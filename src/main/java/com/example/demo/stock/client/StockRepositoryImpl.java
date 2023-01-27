package com.example.demo.stock.client;

import com.example.demo.stock.Stock;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Repository
public class StockRepositoryImpl{

//    @Autowired
//    MongoTemplate mongoTemplate;
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getStock(String code) {
        return stockRepository.findByCode(code);
    }

    public Stock addStock(Stock stock) {
        stockRepository.save(stock);
        return stock;
    }

}
