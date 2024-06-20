package miu.edu.springsecuritydemo.service;


import miu.edu.springsecuritydemo.dto.request.ProductRequestDTO;
import miu.edu.springsecuritydemo.dto.response.ProductResponseDTO;
import miu.edu.springsecuritydemo.entity.Product;
import miu.edu.springsecuritydemo.user.User;

import java.util.List;

public interface ProductService {
    List<ProductResponseDTO> getProducts(Integer pageNumber, Integer pageSize, String direction, String orderBy);

    List<ProductResponseDTO> findByNameContainingIgnoreCase(String keyword);

    public ProductResponseDTO getProduct(String id);

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    public ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO) throws Exception;

    public Boolean deleteProduct(String id);

    public List<ProductResponseDTO> getCustomerProducts(User user, String status, String search);

}
