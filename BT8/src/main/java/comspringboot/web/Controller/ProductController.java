package comspringboot.web.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import comspringboot.web.Entity.CategoryEntity;
import comspringboot.web.Entity.ProductEntity;
import comspringboot.web.Repository.CategoryRepository;
import comspringboot.web.Repository.ProductRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Optional<ProductEntity> productByCategory(Long categoryId){
    	return productRepository.findById(categoryId);
    }

	public ProductEntity createProduct(ProductEntity product) {
		Long categoryId = product.getCategory().getId();
        CategoryEntity category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));
        product.setCategory(category);
        return productRepository.save(product);
	}

	public List<ProductEntity> getAllProductsSortedByPrice() {
	    return productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
	}
	
	public ProductEntity updateProduct(Long id, ProductEntity updatedProduct) {
			    return productRepository.findById(id)
	            .map(product -> {
	                product.setTitle(updatedProduct.getTitle());
	                product.setPrice(updatedProduct.getPrice());
	                product.setDesc(updatedProduct.getDesc());
	                product.setCategory(updatedProduct.getCategory());
	                return productRepository.save(product);
	            })
	            .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
	}
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
