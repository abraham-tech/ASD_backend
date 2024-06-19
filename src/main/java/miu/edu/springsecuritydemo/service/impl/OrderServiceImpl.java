package miu.edu.springsecuritydemo.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.edu.springsecuritydemo.dto.request.CustomerRequestDTO;
import miu.edu.springsecuritydemo.dto.request.OrderRequestDTO;
import miu.edu.springsecuritydemo.dto.response.OrderResponseDTO;
import miu.edu.springsecuritydemo.dto.response.ProductResponseDTO;
import miu.edu.springsecuritydemo.entity.Product;
import miu.edu.springsecuritydemo.entity.ProductOrder;
import miu.edu.springsecuritydemo.repository.OrderPaymentRepository;
import miu.edu.springsecuritydemo.repository.OrderRepository;
import miu.edu.springsecuritydemo.repository.ProductRepository;
import miu.edu.springsecuritydemo.repository.UserRepository;
import miu.edu.springsecuritydemo.service.OrderService;
import miu.edu.springsecuritydemo.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static miu.edu.springsecuritydemo.util.AppConstant.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final OrderPaymentRepository orderPaymentRepository;
    private final ModelMapper modelMapper;

    @Override
    public Integer totalOrderProductCountByCustomer(User customer) {
        return orderRepository.countDistinctByCustomer(customer);
    }

    @Override
    @Transactional
    public ProductResponseDTO create(OrderRequestDTO orderRequestDTO, User user) throws Exception {
        Product product = productRepository.findById(orderRequestDTO.getProductId()).get();
        if (product.getStatus().equals(PRODUCT_SOLD_STATUS)) {
            log.error("Product is sold. Unable to save order");
            throw new Exception("Product is sold. Unable to sale");
        }
        ProductOrder order = new ProductOrder();
        order.setStatus(ON_SALE);
        order.setProduct(productRepository.findById(orderRequestDTO.getProductId()).get());
        order.setCustomer(user);
        order.setAmount(orderRequestDTO.getAmount());
        order.setCreatedOn(LocalDateTime.now());
        productRepository.save(product);
        user.setBalance(user.getBalance() - (orderRequestDTO.getAmount() * product.getPrice()));
        userRepository.save(user);
        ProductOrder savedOrder = orderRepository.save(order);

        return convertToDto(savedOrder);
    }


    @Override
    public List<OrderResponseDTO> getOrderByProduct(String productId) {
        Product product = productRepository.findById(productId).get();

        List<ProductOrder> orderList = orderRepository.findAllByProductOrderByCreatedOnDesc(product);
        List<OrderResponseDTO> orderResponseDTOS = new ArrayList<>();

        orderList.stream().forEach(order -> {
            OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
            orderResponseDTO.setId(order.getId());
            orderResponseDTO.setAmount(order.getAmount());
            orderResponseDTO.setCreatedOn(order.getCreatedOn());
            orderResponseDTO.setStatus(order.getStatus());
            CustomerRequestDTO customerDTO = new CustomerRequestDTO();
            customerDTO.setName(order.getCustomer().getUsername());
            customerDTO.setEmail(order.getCustomer().getEmail());
            customerDTO.setId(order.getCustomer().getId());

            orderResponseDTO.setCustomer(customerDTO);
            orderResponseDTOS.add(orderResponseDTO);
        });

        return orderResponseDTOS;
    }

    public ProductResponseDTO convertToDto(ProductOrder productOrder) {
        return modelMapper.map(productOrder, ProductResponseDTO.class);
    }

}
