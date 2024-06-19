package miu.edu.springsecuritydemo.dto.response;

import lombok.Getter;

@Getter
public class DashboardResponseDTO {
    private int totalNumberOfProduct = 0;
    private double balance;
    private String type;

    public DashboardResponseDTO(int totalNumberOfProduct, double balance, String type) {
        this.totalNumberOfProduct = totalNumberOfProduct;
        this.balance = balance;
        this.type = type;
    }
}
