package miu.edu.springsecuritydemo.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.springsecuritydemo.dto.request.ProductRequestDTO;
import miu.edu.springsecuritydemo.dto.response.ProductResponseDTO;
import miu.edu.springsecuritydemo.entity.Category;
import miu.edu.springsecuritydemo.entity.Product;
import miu.edu.springsecuritydemo.repository.CategoryRepository;
import miu.edu.springsecuritydemo.repository.ProductRepository;
import miu.edu.springsecuritydemo.service.ProductService;
import miu.edu.springsecuritydemo.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static miu.edu.springsecuritydemo.util.AppConstant.*;


@Component
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ProductResponseDTO> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDTO> findByNameContainingIgnoreCase(String search) {
        List<Product> products;
        if(search == null || search.isEmpty()) {
            products = productRepository.findAll();
        }else {
            products = productRepository.findByNameContainingIgnoreCase(search);
        }
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO getProduct(String id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return null;
        }
        return convertToDto(product);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = convertToEntity(productRequestDTO);
        product.setCreatedOn(LocalDateTime.now());
        product.setDepositAmount(product.getPrice() * (product.getDeposit() / 100));
//        setProductCategory(product);
        Product savedProduct = productRepository.save(product);
        return convertToDto(savedProduct);
    }

    @Override
    public ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO) throws Exception {
        Product productExisting = productRepository.findById(productRequestDTO.getId()).get();
        if (productExisting != null) {
            productExisting.setName(productRequestDTO.getName());
            productExisting.setDescription(productRequestDTO.getDescription());
            productExisting.setPrice(productRequestDTO.getPrice());
//            productExisting.setDeposit(product.getDeposit());
//            productExisting.setDepositAmount(product.getPrice() * (product.getDeposit() / 100));
            productExisting.setStatus(productRequestDTO.getStatus());
            setProductCategory(productRequestDTO);
//            productExisting.setCategoryIds(product.getCategoryIds());
            productExisting.setCategories(productRequestDTO.getCategories());

            Product updatedProduct = productRepository.save(productExisting);

            return convertToDto(updatedProduct);
        } else {
            throw new Exception("Unable to update product");
        }
    }

    /*
     * Set product seller and category
     */
    void setProductCategory(ProductRequestDTO productRequestDTO) {
        List<Category> categoryList = new ArrayList<>();

        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            User seller = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            productRequestDTO.setSeller(seller);
        }
        for (String id : productRequestDTO.getCategoryIds()) {
            Category category = categoryRepository.findById(id).get();
            categoryList.add(category);
        }
        productRequestDTO.setCategories(categoryList);
    }

    //update status
    public void statusUpdate(Product product) {
        Product productExisting = productRepository.findById(product.getId()).get();
        ;
        if (productExisting != null) {
            productExisting.setStatus(product.getStatus());
            productRepository.save(productExisting);
        }
    }

    @Override
    public Boolean deleteProduct(String id) {
        Product product = productRepository.findById(id).get();
        if (product != null) {
            product.setStatus(PRODUCT_DELETED_STATUS);
            productRepository.delete(product);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


//    @Override
//    public List<Product> getProductBySellerV2(User user, String search) {
//        return productRepository.findAll();
//    }

    @Override
    public List<ProductResponseDTO> getCustomerProducts(User user, String status, String search) {
        List<Product> products;
        if(search == null || search.isEmpty()) {
            products = productRepository.findAll();
        }else {
            products = productRepository.findByNameContainingIgnoreCase(search);
        }
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Product convertToEntity(ProductRequestDTO productRequestDTO) {
        return modelMapper.map(productRequestDTO, Product.class);
    }

    public ProductResponseDTO convertToDto(Product product) {
        return modelMapper.map(product, ProductResponseDTO.class);
    }



}

