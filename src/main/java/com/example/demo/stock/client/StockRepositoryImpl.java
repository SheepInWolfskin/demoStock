package com.example.demo.stock.client;

import com.example.demo.stock.Stock;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Repository
public class StockRepositoryImpl{

    private StockRepository stockRepository;
    public StockRepositoryImpl(@Lazy StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getStock(String code) {
        return stockRepository.findByCode(code);
    }

    public Stock addStock(Stock stock) {
        //localhost:8080/api/v1/stock/addStock
        System.out.println("hello");
        System.out.println(stock);
        stockRepository.save(stock);
//        System.out.println("22222");
//        System.out.println(stockRepository.findByCode("AA"));
        return stock;
    }

}
