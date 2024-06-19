package miu.edu.springsecuritydemo.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import miu.edu.springsecuritydemo.user.Role;

@Data
@AllArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}
