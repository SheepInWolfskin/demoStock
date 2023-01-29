package com.example.demo.stock.controller;

import com.example.demo.stock.Stock;
import com.example.demo.stock.buzLogic.StockService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/stock")
public class StockController {

    private final StockService stockService;
//    private BufferedReader br;


    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
//        this.br = br;
    }
    @GetMapping(value = "/getStock")
    public List<Stock> getStock(@RequestParam String code) {
        return stockService.getStock(code);
    }

    @PostMapping(value = "/addStock", consumes = "application/json", produces = "application/json")
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }

    @PostMapping("/uploadFile")
    public String submit(@RequestParam MultipartFile file) throws IOException {
        System.out.println("uploading file");
        System.out.println(file.getOriginalFilename());
        BufferedReader fileReader = new BufferedReader(new
                InputStreamReader(file.getInputStream(), "UTF-8"));
//        char c = (char)fileReader.read();
//        System.out.print(c);
//        fileReader.close();
//        int data = fileReader.read();
        String thisLine = null;
        while((thisLine = fileReader.readLine()) != null) {
            //do something with data...
            System.out.println(thisLine);
//            data = fileReader.readLine();
        }
        fileReader.close();
        return "True";
    }

}
