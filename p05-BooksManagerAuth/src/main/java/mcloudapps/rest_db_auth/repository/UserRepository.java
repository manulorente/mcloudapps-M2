package mcloudapps.rest_db_auth.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mcloudapps.rest_db_auth.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Page<User> findAll(Pageable pageable);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
