package miu.edu.springsecuritydemo.repository;

import miu.edu.springsecuritydemo.entity.Product;
import miu.edu.springsecuritydemo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByNameContainingIgnoreCase(String keyword);

    @Query("select p from  Product p where p.status = :status and p.name like %:search% or p.status = :status and p.description like %:search% order by p.createdOn desc")
    List<Product> filterByStatus(@Param("status") String status, @Param("search") String search);


}



