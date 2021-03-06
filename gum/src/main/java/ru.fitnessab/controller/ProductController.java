package ru.fitnessab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.fitnessab.persist.entity.Product;
import ru.fitnessab.persist.repo.ProductRepository;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String allProducts(Model model){
        List<Product> allProducts = productRepository.findAll();
        model.addAttribute("products", allProducts);
        return "products";
    }

    @GetMapping("/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model) throws SQLException {
        Product product = productRepository.findById(id).get();
        model.addAttribute("product", product);
        return "product";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteProduct(@PathVariable("id") Integer id) throws SQLException {
        Product product = productRepository.findById(id).get();
        if (id != null) productRepository.delete(product);
        return "redirect:/product";
    }

    @GetMapping("/create")
    public String createProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/update")
    public String updateProduct(Product product){
            productRepository.save(product);
        return "redirect:/product";
    }

//    @PostMapping("/create")
//    public String insertProduct(Product product) throws SQLException {
//        productRepository.insert(product);
//        return "redirect:/product";
//    }

//    @PostMapping("/delete")
//    public String deleteProduct(Product product) throws SQLException {
//        productRepository.delete(product);
//        return "redirect:/product";
//    }
}
