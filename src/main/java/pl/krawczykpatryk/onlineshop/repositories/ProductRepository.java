package pl.krawczykpatryk.onlineshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krawczykpatryk.onlineshop.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
