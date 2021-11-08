package com.example.demo.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {
    private Integer paymentId;
    private Double  paidAmount;
    private String transactionId;
    private String transactionStatus;
    private Integer productId;
    private Integer quantity;

}