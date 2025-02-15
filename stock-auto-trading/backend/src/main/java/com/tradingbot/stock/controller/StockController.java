package com.tradingbot.stock.controller;

import com.tradingbot.stock.dto.StockDto;
import com.tradingbot.stock.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<StockDto> getStocks() {
        return stockService.getAllStocks();
    }

    @PostMapping
    public StockDto addStock(@RequestBody StockDto stockDto) {
        return stockService.addStock(stockDto);
    }
}
