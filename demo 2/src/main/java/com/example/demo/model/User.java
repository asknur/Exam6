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
public class User {
    private Long id;
    private String phoneNumber;
    private String username;
    private String password;
    private String role;
    private boolean blocked;
    private LocalDateTime createdAt;
}
