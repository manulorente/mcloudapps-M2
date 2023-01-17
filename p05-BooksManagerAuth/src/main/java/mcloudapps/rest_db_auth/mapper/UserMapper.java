package mcloudapps.rest_db_auth.mapper;

import org.mapstruct.Mapper;

import mcloudapps.rest_db_auth.dto.UserCreateDTO;
import mcloudapps.rest_db_auth.dto.UserDTO;
import mcloudapps.rest_db_auth.model.User;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {

    UserDTO toDTO(User user);

    User toDomain(UserDTO userDTO);

    User toDomain(UserCreateDTO userCreateDTO);
    
}
