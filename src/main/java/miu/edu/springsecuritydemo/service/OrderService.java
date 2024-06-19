package miu.edu.springsecuritydemo.service;

import miu.edu.springsecuritydemo.dto.request.OrderRequestDTO;
import miu.edu.springsecuritydemo.dto.response.OrderResponseDTO;
import miu.edu.springsecuritydemo.dto.response.ProductResponseDTO;
import miu.edu.springsecuritydemo.user.User;

import java.util.List;

public interface OrderService {
    Integer totalOrderProductCountByCustomer(User customer);

    ProductResponseDTO create(OrderRequestDTO orderRequestDTO, User user) throws Exception;

    List<OrderResponseDTO> getOrderByProduct(String productId);
}
