package miu.edu.springsecuritydemo.service.impl;

import lombok.RequiredArgsConstructor;

import miu.edu.springsecuritydemo.entity.OrderPayment;
import miu.edu.springsecuritydemo.repository.OrderPaymentRepository;
import miu.edu.springsecuritydemo.service.OrderPaymentService;
import miu.edu.springsecuritydemo.user.User;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderPaymentServiceImpl implements OrderPaymentService {
    private final OrderPaymentRepository orderPaymentRepository;


    @Override
    public OrderPayment getOrderPaymentByUser(User customer) {
        return orderPaymentRepository.findOrderPaymentByUser(customer);
    }

    @Override
    public OrderPayment create(OrderPayment orderPayment) {
        return orderPaymentRepository.save(orderPayment);
    }

}

