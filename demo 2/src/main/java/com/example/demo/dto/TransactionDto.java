package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class TransactionDto {
    private Long id;

    @NotBlank(message = "From account is required")
    private String fromAccountNumber;

    @NotBlank(message = "To account is required")
    private String toAccountNumber;

    @NotNull
    @Positive(message = "Amount must be positive")
    private BigDecimal amount;

    private String currency;
    private String toCurrency;
    private BigDecimal convertedAmount;
    private BigDecimal exchangeRate;
    private String status;
    private boolean requiresApproval;
    private LocalDateTime createdAt;
    private LocalDateTime processedAt;
}
