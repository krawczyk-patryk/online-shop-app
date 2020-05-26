package pl.krawczykpatryk.onlineshop.converters;

import org.springframework.stereotype.Component;
import pl.krawczykpatryk.onlineshop.dtos.ProductDto;
import pl.krawczykpatryk.onlineshop.models.Product;
import pl.krawczykpatryk.onlineshop.models.ProductType;

import java.util.function.Function;

@Component
public class ProductConverter implements Function<ProductDto, Product> {

    @Override
    public Product apply(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .type(ProductType.valueOf(productDto.getType()))
                .build();
    }
}