package miu.edu.springsecuritydemo;

import miu.edu.springsecuritydemo.entity.Category;
import miu.edu.springsecuritydemo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityDemoApplication implements ApplicationRunner {
    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // category
        if (categoryRepository.findByName("Antique").isEmpty()) {
            Category category1 = new Category();
            category1.setName("Antique");
            categoryRepository.save(category1);
        }

        if (categoryRepository.findByName("Art").isEmpty()) {
            Category category2 = new Category();
            category2.setName("Art");
            categoryRepository.save(category2);
        }

        if (categoryRepository.findByName("Jewelry").isEmpty()) {
            Category category3 = new Category();
            category3.setName("Jewelry");
            categoryRepository.save(category3);
        }

        if (categoryRepository.findByName("Electronics").isEmpty()) {
            Category category4 = new Category();
            category4.setName("Electronics");
            categoryRepository.save(category4);
        }
    }
}
