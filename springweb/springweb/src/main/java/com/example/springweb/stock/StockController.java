package com.example.springweb.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StockController {

    @Autowired
    StockServiceImpl memoryStockService;


    @GetMapping("/stocklist")
    public String stocklist(Model model) {

        model.addAttribute("stocks", memoryStockService.findAll());

        // stock list 가져오기
        return "stocklist";
    }

    @GetMapping("/stockdelete")
    public String delete(@RequestParam String comCode, Model model){

        memoryStockService.delete(comCode);

        return "redirect:/stocklist";
    }
}
