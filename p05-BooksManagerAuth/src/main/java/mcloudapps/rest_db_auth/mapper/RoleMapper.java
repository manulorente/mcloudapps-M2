package mcloudapps.rest_db_auth.mapper;

import org.mapstruct.Mapper;

import mcloudapps.rest_db_auth.dto.RoleCreateDTO;
import mcloudapps.rest_db_auth.dto.RoleDTO;
import mcloudapps.rest_db_auth.model.Role;

@Mapper(componentModel = "spring", uses = {CommentMapper.class})
public interface RoleMapper {

    RoleDTO toDTO(Role role);

    Role toDomain(Role roleDTO);

    Role toDomain(RoleCreateDTO roleCreateDTO);
    
}
