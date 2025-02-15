package com.tradingbot.stock.service;

import com.tradingbot.stock.dto.StockDto;
import com.tradingbot.stock.model.Stock;
import com.tradingbot.stock.repository.StockRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<StockDto> getAllStocks() {
        List<Stock> stocks = stockRepository.findAll();
        return stocks.stream().map(stock -> StockDto.builder()
            .symbol(stock.getSymbol())
            .name(stock.getName())
            .price(stock.getPrice())
            .build()
        ).collect(Collectors.toList());
    }

    public StockDto addStock(StockDto stockDto) {
        Stock stock = Stock.builder()
            .symbol(stockDto.getSymbol())
            .name(stockDto.getName())
            .price(stockDto.getPrice())
            .build();
        Stock savedStock = stockRepository.save(stock);

        return StockDto.builder()
            .symbol(savedStock.getSymbol())
            .name(savedStock.getName())
            .price(savedStock.getPrice())
            .build();
    }
}
