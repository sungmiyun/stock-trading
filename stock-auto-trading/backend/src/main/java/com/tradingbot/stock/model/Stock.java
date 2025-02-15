package com.tradingbot.stock.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Builder;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String symbol;  // 주식 코드 (ex: "005930" - 삼성전자)
    private String name;    // 주식 이름
    private Double price;   // 현재 가격
}
