package miu.edu.springsecuritydemo.dto;

import jakarta.persistence.Column;
import lombok.Data;


@Data
public class UserDTO {
    private String name;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(nullable = false, length = 64)
    private String password;
    private String roles;


}
