package com.example.demo.stock.controller;

import com.example.demo.stock.Stock;
import com.example.demo.stock.buzLogic.StockService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/stock")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }
    @GetMapping(value = "/getStock", consumes = "application/json", produces = "application/json")
    public List<Stock> getStock(@RequestParam String code) {
        return stockService.getStock(code);
    }

    @PostMapping(value = "/addStock", consumes = "application/json", produces = "application/json")
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }



//    @PostMapping
//    public void uploadData() {
//
//    }
}
