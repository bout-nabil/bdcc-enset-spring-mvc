package ma.enset.bdccensetspringmvc.repository;

import ma.enset.bdccensetspringmvc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
