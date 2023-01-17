package mcloudapps.rest_db_auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mcloudapps.rest_db_auth.model.Eroles;
import mcloudapps.rest_db_auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Eroles roleName);
}
