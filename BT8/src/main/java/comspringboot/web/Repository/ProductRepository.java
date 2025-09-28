package comspringboot.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import comspringboot.web.Entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
