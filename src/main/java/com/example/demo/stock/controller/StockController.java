package com.example.demo.stock.controller;

import com.example.demo.stock.Stock;
import com.example.demo.stock.buzLogic.StockService;
import com.example.demo.stock.utils.StockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/stock")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping(value = "/getStock")
    public List<Stock> getStock(@RequestParam String code) {
        return stockService.getStock(code);
    }

    @PostMapping(value = "/addStock", consumes = "application/json", produces = "application/json")
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }

    @PostMapping("/uploadFile")
    public List<Stock> uploadFile(@RequestParam MultipartFile file) throws Exception {
        return stockService.bulkAddStock(file);
    }

    @PutMapping(value = "/updateStock" , consumes = "application/json", produces = "application/json")
    public Stock updateStock(@RequestBody Stock stock) throws Exception {
        return stockService.updateStock(stock);
    }

}
