package mcloudapps.rest_db_auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mcloudapps.rest_db_auth.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{    
}
