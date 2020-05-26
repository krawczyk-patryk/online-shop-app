package pl.krawczykpatryk.onlineshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.krawczykpatryk.onlineshop.dtos.ProductDto;
import pl.krawczykpatryk.onlineshop.services.ProductService;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<ProductDto> products = productService.findAllProducts();
        model.addAttribute("productList", products);
        return "productListView";
    }
}