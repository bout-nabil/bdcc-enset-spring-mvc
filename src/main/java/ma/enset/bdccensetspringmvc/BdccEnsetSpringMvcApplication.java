package ma.enset.bdccensetspringmvc;

import ma.enset.bdccensetspringmvc.entities.Product;
import ma.enset.bdccensetspringmvc.repository.IProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class BdccEnsetSpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdccEnsetSpringMvcApplication.class, args);
    }
    @Bean
    public CommandLineRunner start(IProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder().name("Samsung").price(1000)
                            .description("A smartphone with a large display")
                            .quantity(20).stocked(10).selected(true)
                    .build());
            productRepository.save(Product.builder().name("Apple").price(2000)
                    .description("A smartphone with a sleek design")
                    .quantity(10).stocked(5).selected(true)
                    .build());
            productRepository.save(Product.builder().name("HP").price(3000)
                    .description("A laptop with high performance")
                    .quantity(5).stocked(2).selected(false)
                    .build());
            productRepository.findAll().forEach(product -> {
                System.out.println(product.toString());
            });
        };
    }

}
