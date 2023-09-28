package com.example.learnflatfrombackend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class AdminDTO {
    private int adminID;
    private String adminName;
    private String email;
    private String password;
}
