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

import java.util.List;

@Repository
public class StockRepositoryImpl{

    private StockRepository stockRepository;
    @Lazy
    public StockRepositoryImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

//    localhost:8080/api/v1/stock/getStock?code=MSFT
    public List<Stock> getStock(String code) {
        return stockRepository.findByCode(code);
    }

    public Stock addStock(Stock stock) {
        //localhost:8080/api/v1/stock/addStock
        stockRepository.save(stock);
        return stock;
    }

    public void bulkAddStock(List<Stock> stocks) {
        stockRepository.saveAll(stocks);
    }

}
