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
public class Account {
    private Long id;
    private String accountNumber;
    private Long userId;
    private String currency;
    private BigDecimal balance;
    private LocalDateTime createdAt;
}
