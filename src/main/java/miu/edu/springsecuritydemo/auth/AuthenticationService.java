package miu.edu.springsecuritydemo.auth;

import lombok.RequiredArgsConstructor;
import miu.edu.springsecuritydemo.config.JwtService;
import miu.edu.springsecuritydemo.dto.response.AuthResponse;
import miu.edu.springsecuritydemo.repository.UserRepository;
import miu.edu.springsecuritydemo.user.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        // Create user by using the data from the registerRequest
        User user = new User(
                registerRequest.getUsername(),
                passwordEncoder.encode(registerRequest.getPassword()),
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                registerRequest.getEmail(),
                registerRequest.getRole()
        );
        User savedUser = userRepository.save(user);
        String token = jwtService.generateToken(savedUser);

        return new AuthenticationResponse(token);
    }

    public AuthResponse authenticate(AuthenticationRequest authenticationRequest) {
        // Attempts to authenticate the passed Authentication object
        // Throws:
        // AuthenticationException -if authentication fails
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//        var User = userRepository.findByUsername(authenticationRequest.getUsername()).orElse(() -> new UsernameNotFoundException(authenticationRequest.getUsername()));
        var User = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String token = jwtService.generateToken(User);
//        return new AuthenticationResponse(token);
        User user = (User) authentication.getPrincipal();

        return new AuthResponse(user.getId(), user.getEmail(), user.getFirstName(), user.getRole(), token);
    }
}
