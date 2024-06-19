package miu.edu.springsecuritydemo.dto.request;

import lombok.Getter;

@Getter
public class DashboardRequestDTO {
    private int totalNumberOfProduct = 0;
    private double balance;
    private String type;

    public DashboardRequestDTO(int totalNumberOfProduct, double balance, String type) {
        this.totalNumberOfProduct = totalNumberOfProduct;
        this.balance = balance;
        this.type = type;
    }
}
