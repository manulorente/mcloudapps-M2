package mcloudapps.rest_db_auth.dto;

import java.util.Set;

import mcloudapps.rest_db_auth.model.Role;

public record UserDTO(
    Long id, 
    String username,
    String email,
    String password,
    Role role,
    Set<Role> roles
    ){
}
