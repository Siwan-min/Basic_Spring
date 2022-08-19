package com.example.springweb.stock;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private ArrayList<Stock> stocks = new ArrayList<>() {{
        add(new Stock("005930", "삼성전자", 20));
        add(new Stock("267850", "아시아나IDT", 15));
        add(new Stock("035720", "카카오", 35));
        add(new Stock("020560", "삼성바이오로직스", 35));
    }};

   @Override
    public List<Stock> findAll() {
        return stocks;
    }

    @Override
    public void delete(String comCode) {
        Stock find = stocks.stream().filter(stock ->stock.getComCode().equals(comCode)).findAny().get();
        stocks.remove(find);
    }


}
