package miu.edu.springsecuritydemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import miu.edu.springsecuritydemo.user.User;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
@Setter
public class ProductOrder {
    @Id
    @UuidGenerator
    private String id;

    @ManyToOne
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private User customer; // customer only

    private double amount;

    private String status = "Running"; // Closed

    private LocalDateTime createdOn;
}
