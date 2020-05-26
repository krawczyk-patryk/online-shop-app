package pl.krawczykpatryk.onlineshop.services;

import pl.krawczykpatryk.onlineshop.dtos.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAllProducts();
}
