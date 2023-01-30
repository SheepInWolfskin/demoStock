package com.example.demo.stock.buzLogic;

import com.example.demo.stock.Stock;
import com.example.demo.stock.client.StockRepositoryImpl;
import com.example.demo.stock.exception.InternalServiceException;
import com.example.demo.stock.exception.InvalidRequestException;
import com.example.demo.stock.utils.StockUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    private StockRepositoryImpl stockRepositoryImpl;

    public StockService(StockRepositoryImpl stockRepositoryImpl) {
        this.stockRepositoryImpl = stockRepositoryImpl;
    }

    public List<Stock> getStock(String code) {
        return stockRepositoryImpl.getStock(code);
    }

    public Stock addStock(Stock code) {
        return stockRepositoryImpl.addStock(code);
    }

    public Stock updateStock(Stock stock) throws Exception {
        List<Stock> codes = stockRepositoryImpl.getStockDate(stock.getCode(), stock.getDate());
        if (codes.size() == 0) {
            throw new InvalidRequestException("the code and date combination was not found.");
        } else if (codes.size() > 1) {
            throw new InternalServiceException("multiple record has been found.");
        }
        Stock existingStock = codes.get(0);
        existingStock.setQuarter(stock.getQuarter());
        stockRepositoryImpl.addStock(existingStock);
        return existingStock;
    }

    public List<Stock> bulkAddStock(MultipartFile file) throws IOException, InvalidRequestException {
        BufferedReader fileReader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), "UTF-8"));
        String thisLine = fileReader.readLine();
        List<Stock> stocks = new ArrayList<>();
        while((thisLine = fileReader.readLine()) != null) {
            stocks.add(StockUtil.convertStreamDataToStock(thisLine));
        }
        fileReader.close();
        return stockRepositoryImpl.bulkAddStock(stocks);
    }
}
