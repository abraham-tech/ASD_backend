package miu.edu.springsecuritydemo.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.springsecuritydemo.dto.request.DashboardRequestDTO;
import miu.edu.springsecuritydemo.repository.ProductRepository;
import miu.edu.springsecuritydemo.service.UserService;
import miu.edu.springsecuritydemo.user.User;
import org.springframework.stereotype.Service;

import static miu.edu.springsecuritydemo.util.AppConstant.ROLE_USER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ProductRepository productRepository;


    @Override
    public DashboardRequestDTO getDashboard(User user) {
        user.getRole();
        int totalProduct = productRepository.findAll().size();
        return new DashboardRequestDTO(totalProduct, user.getBalance(), ROLE_USER);
    }
}
