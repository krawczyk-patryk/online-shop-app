package pl.krawczykpatryk.onlineshop.converters;

import org.springframework.stereotype.Component;
import pl.krawczykpatryk.onlineshop.dtos.ProductDto;
import pl.krawczykpatryk.onlineshop.models.Product;

import java.util.function.Function;

@Component
public class ProductDtoConverter implements Function<Product, ProductDto> {

    @Override
    public ProductDto apply(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .type(product.getType().name())
                .build();
    }
}