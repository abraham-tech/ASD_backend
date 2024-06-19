package miu.edu.springsecuritydemo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.edu.springsecuritydemo.dto.request.ProductRequestDTO;
import miu.edu.springsecuritydemo.dto.response.ProductResponseDTO;
import miu.edu.springsecuritydemo.entity.Product;
import miu.edu.springsecuritydemo.exception.ApiRequestException;
import miu.edu.springsecuritydemo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static miu.edu.springsecuritydemo.util.AppConstant.ERROR;
import static miu.edu.springsecuritydemo.util.AppConstant.SUCCESS;


@RestController
@RequestMapping("/api/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController extends BaseController  {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts(@RequestParam(value = "search", required = false) String search) {
        try {
            List<ProductResponseDTO> products;
            if(search == null || search.isEmpty()) {
                products = productService.getProducts();
            }else {
                products = productService.findByNameContainingIgnoreCase(search);
            }
            return getResponse(SUCCESS, products, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Unable to get products", ex);
            return getResponse(ERROR, "Unable to get products", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProducts(@PathVariable("id") String id) {

        try {
            return getResponse(SUCCESS, productService.getProduct(id), HttpStatus.OK);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new ApiRequestException("Unable to get product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO result = null;
        try {
            result = productService.createProduct(productRequestDTO);
            return getResponse(SUCCESS, result, HttpStatus.OK);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new ApiRequestException("Unable to create product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO result = null;
        try {
            result = productService.updateProduct(productRequestDTO);
            return getResponse(SUCCESS, result, HttpStatus.OK);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new ApiRequestException("Unable to update product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new ApiRequestException("Unable to delete product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
