package com.example.demo.stock.buzLogic;

import com.example.demo.stock.Stock;
import com.example.demo.stock.client.StockRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

//    @Autowired
    private StockRepositoryImpl stockRepositoryImpl;
    public List<Stock> getStock(String code) {
        return stockRepositoryImpl.getStock(code);
    }
    public Stock addStock(Stock code) {
        return stockRepositoryImpl.addStock(code);
    }
}