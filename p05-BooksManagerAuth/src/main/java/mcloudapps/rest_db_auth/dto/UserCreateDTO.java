package mcloudapps.rest_db_auth.dto;

import java.util.Set;

import mcloudapps.rest_db_auth.model.Role;

public record UserCreateDTO(
    String username, 
    String email,
    String password,
    Set<Role> roles
    ) {
}
