package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Builder
public class RollBackLog {
    private Long id;
    private Long transactionId;
    private Long rolledBackBy;
    private LocalDateTime rolledBackAt;
    private String reason;
}
