package comspringboot.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import comspringboot.web.Entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long>{

}
