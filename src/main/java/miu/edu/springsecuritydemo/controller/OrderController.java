package miu.edu.springsecuritydemo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.edu.springsecuritydemo.dto.request.OrderRequestDTO;
import miu.edu.springsecuritydemo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static miu.edu.springsecuritydemo.util.AppConstant.ERROR;
import static miu.edu.springsecuritydemo.util.AppConstant.SUCCESS;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/orders")
public class OrderController extends BaseController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> orderByCustomers(@RequestBody OrderRequestDTO orderRequestDTO) {
        try {
            return getResponse(SUCCESS, orderService.create(orderRequestDTO, getUser()), HttpStatus.OK);

        } catch (Exception e) {
            log.error(e.getMessage());
            if (e.getMessage().equals("Not sufficient balance available")) {
                return getResponse(ERROR, e.getMessage(), HttpStatus.PRECONDITION_FAILED);
            }
            if (e.getMessage().equals("Error occurred while processing payment")) {
                return getResponse(ERROR, e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
            }
            return getResponse(ERROR, "Unable to get products", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getOrderedProduct(@PathVariable("id") String productId) {
        try {
            return getResponse(SUCCESS, orderService.getOrderByProduct(productId), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return getResponse(ERROR, "Unable to get products", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
