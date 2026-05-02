package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionHistoryDto {
    private Long id;
    private String direction;
    private String counterpartAccountNumber;
    private BigDecimal amount;
    private String currency;
    private BigDecimal convertedAmount;
    private String toCurrency;
    private String status;
    private LocalDateTime createdAt;

}
