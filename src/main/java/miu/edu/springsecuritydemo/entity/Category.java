package miu.edu.springsecuritydemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;
    @JsonIgnore

    @ManyToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList<>();

}
