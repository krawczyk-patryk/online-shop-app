package pl.krawczykpatryk.onlineshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krawczykpatryk.onlineshop.converters.ProductDtoConverter;
import pl.krawczykpatryk.onlineshop.dtos.ProductDto;
import pl.krawczykpatryk.onlineshop.models.Product;
import pl.krawczykpatryk.onlineshop.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductDtoConverter productDtoConverter;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductDtoConverter productDtoConverter) {
        this.productRepository = productRepository;
        this.productDtoConverter = productDtoConverter;
    }

    @Override
    public List<ProductDto> findAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(product -> productDtoConverter.apply(product)).collect(Collectors.toList());
    }
}
