package miu.edu.springsecuritydemo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.edu.springsecuritydemo.exception.ApiRequestException;
import miu.edu.springsecuritydemo.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static miu.edu.springsecuritydemo.util.AppConstant.SUCCESS;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
@Slf4j
public class CategoryController extends BaseController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getCategories() {
        try {
            return getResponse(SUCCESS, categoryService.getCategories(), HttpStatus.OK);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new ApiRequestException("Unable to get categories", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
