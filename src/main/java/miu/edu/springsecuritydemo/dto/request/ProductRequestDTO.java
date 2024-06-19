package miu.edu.springsecuritydemo.dto.request;

import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Data;
import miu.edu.springsecuritydemo.entity.Category;
import miu.edu.springsecuritydemo.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ProductRequestDTO {
    private String id;
    private String name;
    private String description;
    private double price;
    private LocalDateTime expirationDate;
    private String status = "SaveWithoutRelease"; // SaveWithoutRelease, SaveAndRelease, Canceled, Sold
    private User seller;

    @Transient
    private List<String> categoryIds = new ArrayList<>();

    private List<Category> categories = new ArrayList<>();
}
