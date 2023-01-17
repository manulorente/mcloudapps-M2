package mcloudapps.rest_db_auth.dto;

import mcloudapps.rest_db_auth.model.Eroles;

public record RoleDTO(
    Long id,
    Eroles name
) {  
}
