package pl.krawczykpatryk.onlineshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.krawczykpatryk.onlineshop.dtos.ProductDto;
import pl.krawczykpatryk.onlineshop.models.ProductType;
import pl.krawczykpatryk.onlineshop.services.ProductService;

import javax.validation.Valid;
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

    @GetMapping("/product")
    public String findById(@RequestParam final Long id, Model model) {
        model.addAttribute("productTypes", ProductType.values());
        ProductDto productById = productService.findProductById(id);
        if (productById != null) {
            model.addAttribute("productModel", productById);
        }
        return "productPageView";
    }

    @PostMapping("/product")
    public String save(@Valid @ModelAttribute("productModel") ProductDto productDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute( "productTypes", ProductType.values());
            return "productPageView";
        }
        productService.createProduct(productDto);
        return "redirect:/";
    }

    @GetMapping("/product/delete")
    public String delete(@RequestParam final Long id, Model model) {
        productService.deleteProduct(id);
        return "redirect:/";
    }

    @GetMapping("/product/add")
    public String add(Model model) {
        model.addAttribute("productModel", new ProductDto());
        model.addAttribute("productTypes", ProductType.values());
        return "productPageView";
    }
}