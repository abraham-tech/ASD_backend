package miu.edu.springsecuritydemo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.edu.springsecuritydemo.exception.ApiRequestException;
import miu.edu.springsecuritydemo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static miu.edu.springsecuritydemo.util.AppConstant.SAVE_AND_RELEASE;
import static miu.edu.springsecuritydemo.util.AppConstant.SUCCESS;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/customers")
public class CustomerController extends BaseController {
    private final ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<?> getCustomerProduct(@RequestParam(required = false) String search) {
        try {
            return getResponse(SUCCESS, productService.getCustomerProducts(getUser(), SAVE_AND_RELEASE, search), HttpStatus.OK);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new ApiRequestException("Unable to get products", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
