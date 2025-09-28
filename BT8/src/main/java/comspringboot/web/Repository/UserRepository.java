package comspringboot.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import comspringboot.web.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{

}
