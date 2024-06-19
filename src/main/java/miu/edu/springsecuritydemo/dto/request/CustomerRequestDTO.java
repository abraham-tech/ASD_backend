package miu.edu.springsecuritydemo.dto.request;

import lombok.Data;

@Data
public class CustomerRequestDTO {
    private Long id;
    private String email;
    private String name;
}
