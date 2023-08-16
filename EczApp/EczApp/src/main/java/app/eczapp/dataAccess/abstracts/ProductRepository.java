package app.eczapp.dataAccess.abstracts;

import app.eczapp.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

    boolean existsByName(String name);
}
