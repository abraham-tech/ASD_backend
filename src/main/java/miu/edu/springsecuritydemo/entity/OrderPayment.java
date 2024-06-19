package miu.edu.springsecuritydemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import miu.edu.springsecuritydemo.user.User;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class OrderPayment {
    @Id
    @UuidGenerator
    private String id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    private double amount; //deposit amount,

    private String status; 

    private LocalDateTime createdOn;
}
