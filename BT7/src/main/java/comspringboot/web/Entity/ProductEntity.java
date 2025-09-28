package comspringboot.web.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", length = 200, nullable = false, columnDefinition = "nvarchar(200)")
	private String title;

	@Column(name = "price", nullable = false)
	private Double price;
	
	@Column(name="description", columnDefinition="nvarchar(500)")
	private String desc;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id", nullable=false)
	private CategoryEntity category;
}
