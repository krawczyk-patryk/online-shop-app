package pl.krawczykpatryk.onlineshop.dtos;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductDto {

    private Long id;

    private String name;

    private BigDecimal price;

    private String type;
}
