package ma.enset.bdccensetspringmvc.web;

import jakarta.validation.Valid;
import ma.enset.bdccensetspringmvc.entities.Product;
import ma.enset.bdccensetspringmvc.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductRepository productRepository; // Uncomment this line to enable dependency injection

//    public ProductController(IProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @GetMapping("/") // This method maps the root URL ("/") to the home method
    public String home() {
        return "redirect:/user/index"; // Redirect to the index page when accessing the root URL
    }

    @GetMapping("/user/index") // This method maps the "/products" URL to the index method
    public String index(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList); // Add the list of products to the model
        return "products"; // This method returns the name of the view to be rendered
    }

    @GetMapping("/admin/delete") // This method maps the "/delete" URL to the deleteProduct method
    public String deleteProduct(@RequestParam(name = "id") Long id, Model model) {
        productRepository.deleteById(id); // Delete the product by its ID
        List<Product> productList = productRepository.findAll(); // Retrieve the updated list of products
        model.addAttribute("productList", productList); // Add the updated list to the model
        return "redirect:/user/index"; // Redirect to the index page after deletion
    }

    @GetMapping("/admin/addProduct") // This method maps the "/addProduct" URL to the addProduct method
    public String addProduct(Model model) {
        model.addAttribute("product", new Product()); // Add a new Product object to the model
        return "new-product"; // Return the view name for adding a product
    }

    @PostMapping("/admin/saveProduct") // This method maps the "/saveProduct" URL to the saveProduct method
    public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "new-product"; // If there are validation errors, return to the new-product view
        }
        productRepository.save(product); // Save the product to the repository
        List<Product> productList = productRepository.findAll(); // Retrieve the updated list of products
        model.addAttribute("productList", productList); // Add the updated list to the model
        return "redirect:/user/index"; // Redirect to the index page after saving the product
    }
}
