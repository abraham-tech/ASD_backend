package miu.edu.springsecuritydemo.repository;

import miu.edu.springsecuritydemo.entity.Product;
import miu.edu.springsecuritydemo.entity.ProductOrder;
import miu.edu.springsecuritydemo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<ProductOrder, String> {
    int countDistinctByCustomer(User customer);

    List<ProductOrder> findOrderByProductAndCustomer(Product product, User customer);

    int countOrderByProductAndCustomer(Product product, User customer);

    List<ProductOrder> findAllByProductOrderByCreatedOnDesc(Product product);

    ProductOrder findTopByProductAndCustomerOrderByAmountDesc(Product product, User customer);

}
