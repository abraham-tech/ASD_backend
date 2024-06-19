package miu.edu.springsecuritydemo.dto.response;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.springsecuritydemo.entity.Category;
import miu.edu.springsecuritydemo.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {
    private String id;
    private String name;
    private String description;
    private double price;
    private LocalDateTime expirationDate = LocalDateTime.now();
    private String status = "SaveWithoutRelease"; // SaveWithoutRelease, SaveAndRelease, Canceled, Sold
    private User seller;

    @Transient
    private List<String> categoryIds = new ArrayList<>();

    private List<Category> categories = new ArrayList<>();
}
