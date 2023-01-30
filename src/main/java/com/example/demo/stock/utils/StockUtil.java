package com.example.demo.stock.utils;

import com.example.demo.stock.Stock;
import com.example.demo.stock.exception.InvalidRequestException;

public class StockUtil {
    public static Stock convertStreamDataToStock(final String line) throws InvalidRequestException {
        String[] executeData = line.split(",");
        if (executeData[1] == null || executeData[2] == null) {
            throw new InvalidRequestException("the Stock code or date cannot be null.");
        }
        Stock stock = new Stock(executeData[1], executeData[2], executeData[0], executeData[3],
                executeData[4], executeData[5], executeData[6], executeData[7], executeData[8],
                executeData[9], executeData[10], executeData[11], executeData[12], executeData[13], executeData[14],
                executeData[15]);
        return stock;
    }
}
