package com.tradingbot.stock.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class StockDto {
    private String symbol;
    private String name;
    private Double price;
}
