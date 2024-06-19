package miu.edu.springsecuritydemo.dto.request;

import lombok.Data;

@Data
public class OrderRequestDTO {
    private String productId;
    private double amount;
}
