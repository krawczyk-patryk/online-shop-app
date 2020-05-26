package pl.krawczykpatryk.onlineshop.dtos;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductDto {

    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    @NotNull()
    private BigDecimal price;

    @Size(max = 50)
    @NotNull()
    private String type;
}
