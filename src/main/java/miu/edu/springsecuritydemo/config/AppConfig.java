package miu.edu.springsecuritydemo.config;

import miu.edu.springsecuritydemo.dto.request.ProductRequestDTO;
import miu.edu.springsecuritydemo.dto.response.ProductResponseDTO;
import miu.edu.springsecuritydemo.entity.Product;
import miu.edu.springsecuritydemo.entity.ProductOrder;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<ProductRequestDTO, Product>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setName(source.getName());
                map().setDescription(source.getDescription());
                map().setPrice(source.getPrice());
                map().setStatus(source.getStatus());
                map().setSeller(source.getSeller());
                map().setCategories(source.getCategories());
                map().setCategoryIds(source.getCategoryIds());
            }
        });


        // Mapping from Product to ProductResponseDTO
        modelMapper.addMappings(new PropertyMap<Product, ProductResponseDTO>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setName(source.getName());
                map().setDescription(source.getDescription());
                map().setPrice(source.getPrice());
                map().setStatus(source.getStatus());
                map().setSeller(source.getSeller());
                map().setCategories(source.getCategories());
                map().setCategoryIds(source.getCategoryIds());
            }
        });

        modelMapper.addMappings(new PropertyMap<ProductOrder, ProductResponseDTO>() {
            @Override
            protected void configure() {
                // Custom mappings can be defined here
                map().setId(source.getId());
                map().setStatus(source.getStatus());
                map().setCategories(source.getProduct().getCategories());
                map().setSeller(source.getProduct().getSeller());
                map().setName(source.getProduct().getName());
                map().setDescription(source.getProduct().getDescription());
                map().setPrice(source.getProduct().getPrice());
            }
        });

        return modelMapper;
    }
}