package ma.enset.bdccensetspringmvc.web;

import ma.enset.bdccensetspringmvc.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    private IProductRepository productRepository; // Uncomment this line to enable dependency injection

//    public ProductController(IProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
    @GetMapping("/index") // This method maps the "/products" URL to the index method
    public String index() {
        return "products"; // This method returns the name of the view to be rendered
    }
}
