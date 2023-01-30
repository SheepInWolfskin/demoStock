package com.example.demo.stock;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@CompoundIndex(def = "{'code': 1, 'date': 1}", unique = true)
public class Stock {
    @Id
    private String id;
    private String code;
    private String date;
    private String quarter;

    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;
    private String percent_change_price;
    private String percent_change_volume_over_last_wk;
    private String previous_weeks_volume;
    private String next_weeks_open;
    private String next_weeks_close;
    private String percent_change_next_weeks_price;
    private String days_to_next_dividend;
    private String percent_return_next_dividend;

    public Stock() {};

    public Stock(String code,
                 String date,
                 String quarter,
                 String open,
                 String high,
                 String low,
                 String close,
                 String volume,
                 String percent_change_price,
                 String percent_change_volume_over_last_wk,
                 String previous_weeks_volume,
                 String next_weeks_open,
                 String next_weeks_close,
                 String percent_change_next_weeks_price,
                 String days_to_next_dividend,
                 String percent_return_next_dividend) {
        this.code = code;
        this.date = date;
        this.quarter = quarter;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.percent_change_price = percent_change_price;
        this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
        this.previous_weeks_volume = previous_weeks_volume;
        this.next_weeks_open = next_weeks_open;
        this.next_weeks_close = next_weeks_close;
        this.percent_change_next_weeks_price = percent_change_next_weeks_price;
        this.days_to_next_dividend = days_to_next_dividend;
        this.percent_return_next_dividend = percent_return_next_dividend;
    }

}
