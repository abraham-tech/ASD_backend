package miu.edu.springsecuritydemo.repository;


import miu.edu.springsecuritydemo.entity.OrderPayment;
import miu.edu.springsecuritydemo.entity.Product;
import miu.edu.springsecuritydemo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderPaymentRepository extends JpaRepository<OrderPayment, String> {


    OrderPayment findOrderPaymentByUser(User customer);

    OrderPayment findOrderPaymentByUserAndProductAndStatus(User customer, Product product, String status);

    List<OrderPayment> findAllByProductAndStatus(Product product, String status);
}
