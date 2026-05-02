package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Builder
public class Transaction {
    private Long id;
    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;
    private String currency;
    private BigDecimal convertedAmount;
    private String toCurrency;
    private BigDecimal exchangeRate;
    private String status;
    private boolean requiresApproval;
    private LocalDateTime createdAt;
    private LocalDateTime processedAt;
}
