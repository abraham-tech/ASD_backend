package miu.edu.springsecuritydemo.service;

import miu.edu.springsecuritydemo.entity.OrderPayment;
import miu.edu.springsecuritydemo.user.User;

public interface OrderPaymentService {

    public OrderPayment getOrderPaymentByUser(User customer);

    public OrderPayment create(OrderPayment orderPayment);
}