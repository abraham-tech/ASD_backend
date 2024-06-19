package miu.edu.springsecuritydemo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.edu.springsecuritydemo.exception.ApiRequestException;
import miu.edu.springsecuritydemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static miu.edu.springsecuritydemo.util.AppConstant.SUCCESS;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController extends BaseController {

    private final UserService userService;

    @GetMapping("/dashboard")
    public ResponseEntity<?> getUserDashboard() {
        try {
            return getResponse(SUCCESS, userService.getDashboard(getUser()), HttpStatus.OK);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        throw new ApiRequestException("Unable to fetch Dashboard data", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
