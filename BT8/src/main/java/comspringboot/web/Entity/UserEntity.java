package comspringboot.web.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Users")
public class UserEntity implements Serializable{
	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "fullname", length = 100, nullable = false)
	    private String fullname;

	    @Column(name = "password", nullable = false)
	    private String password;

	    @Column(name = "email", length = 200)
	    private String email;
	    
	    @Column(name="phone", length=15)
	    private String phone;

	    @ManyToMany
	    @JoinTable(
	        name = "user_category",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "category_id")
	    )
	    private List<ProductEntity> products = new ArrayList<>();
}

