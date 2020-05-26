package pl.krawczykpatryk.onlineshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krawczykpatryk.onlineshop.converters.ProductConverter;
import pl.krawczykpatryk.onlineshop.converters.ProductDtoConverter;
import pl.krawczykpatryk.onlineshop.dtos.ProductDto;
import pl.krawczykpatryk.onlineshop.exceptions.ProductNotFoundException;
import pl.krawczykpatryk.onlineshop.models.Product;
import pl.krawczykpatryk.onlineshop.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductDtoConverter productDtoConverter;
    private ProductConverter productConverter;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductDtoConverter productDtoConverter,
                              ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productDtoConverter = productDtoConverter;
        this.productConverter = productConverter;
    }

    @Override
    public List<ProductDto> findAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(product -> productDtoConverter.apply(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDto findProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        return productDtoConverter.apply(product);
    }

    @Override
    public void createProduct(ProductDto productDto) {
        Product product = productConverter.apply(productDto);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
