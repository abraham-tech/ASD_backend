package miu.edu.springsecuritydemo.service;


import miu.edu.springsecuritydemo.dto.request.DashboardRequestDTO;
import miu.edu.springsecuritydemo.user.User;

public interface UserService {

    public DashboardRequestDTO getDashboard(User user);

}