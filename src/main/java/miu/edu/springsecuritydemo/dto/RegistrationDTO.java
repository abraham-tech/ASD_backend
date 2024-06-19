package miu.edu.springsecuritydemo.dto;

import lombok.Data;

@Data
public class RegistrationDTO {
    private String id;
    private String name;
    private String email;
    private String roles;
}
