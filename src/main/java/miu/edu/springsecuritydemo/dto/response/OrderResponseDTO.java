package miu.edu.springsecuritydemo.dto.response;

import lombok.Data;
import miu.edu.springsecuritydemo.dto.request.CustomerRequestDTO;

import java.time.LocalDateTime;

@Data
public class OrderResponseDTO {
    private String id;
    private CustomerRequestDTO customer; // customer only
    private double amount;

    private String status = "Running"; // Closed

    private LocalDateTime createdOn;
}
