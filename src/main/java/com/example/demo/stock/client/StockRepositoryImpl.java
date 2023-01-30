package com.example.demo.stock.client;

import com.example.demo.stock.Stock;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StockRepositoryImpl{

    private StockRepository stockRepository;
    @Lazy
    public StockRepositoryImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getStock(String code) {
        return stockRepository.findByCode(code);
    }

    public Stock addStock(Stock stock) {
        stockRepository.save(stock);
        return stock;
    }

    public List<Stock> bulkAddStock(List<Stock> stocks) {
        stockRepository.saveAll(stocks);
        return stocks;
    }

    public List<Stock> getStockDate(String code, String date) {
        return stockRepository.findByCodeAndDate(code, date);
    }

}
