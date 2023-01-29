package com.example.demo.stock.utils;

import com.example.demo.stock.Stock;

import java.util.ArrayList;
import java.util.List;

public class StockUtil {
    public static Stock convertStreamDataToStock(final String line) {
        String[] executeData = line.split(",");
        Stock stock = new Stock(executeData[1], executeData[2]);
        return stock;
    }
}
