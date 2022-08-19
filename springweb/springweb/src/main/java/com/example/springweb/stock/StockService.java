package com.example.springweb.stock;

import java.util.List;


public interface StockService {

    List<Stock> findAll();
    void delete(String comCode);

}
