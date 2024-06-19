package miu.edu.springsecuritydemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import miu.edu.springsecuritydemo.user.User;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @UuidGenerator()
    private String id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
    private double price;
    private double deposit;
    private double depositAmount;
    private String status = "Saved"; // Released, Closed, Sold, Sold & Paid

    @Transient
    private List<String> categoryIds = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    private User seller;

    @ManyToMany
    private List<Category> categories = new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductOrder> orders = new ArrayList<>();

    private LocalDateTime createdOn;
}
