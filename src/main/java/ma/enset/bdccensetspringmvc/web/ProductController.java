package ma.enset.bdccensetspringmvc.web;

import ma.enset.bdccensetspringmvc.entities.Product;
import ma.enset.bdccensetspringmvc.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductRepository productRepository; // Uncomment this line to enable dependency injection

//    public ProductController(IProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
    @GetMapping("/index") // This method maps the "/products" URL to the index method
    public String index(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList); // Add the list of products to the model
        return "products"; // This method returns the name of the view to be rendered
    }

    @GetMapping("/delete") // This method maps the "/delete" URL to the deleteProduct method)
    public String deleteProduct(@RequestParam(name = "id") Long id, Model model) {
        productRepository.deleteById(id); // Delete the product by its ID
        List<Product> productList = productRepository.findAll(); // Retrieve the updated list of products
        model.addAttribute("productList", productList); // Add the updated list to the model
        return "redirect:/index"; // Redirect to the index page after deletion
    }
}
