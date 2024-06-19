package miu.edu.springsecuritydemo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.springsecuritydemo.user.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private Long id;
    private String email;
    private String firstname;
    private Role role;
    private String accessToken;

}
