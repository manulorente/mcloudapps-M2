package mcloudapps.rest_db_auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import mcloudapps.rest_db_auth.dto.UserCreateDTO;
import mcloudapps.rest_db_auth.dto.UserDTO;
import mcloudapps.rest_db_auth.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    //@Mapping(source = "role.id", target = "roleId")
    UserDTO toDTO(User user);

    User toDomain(UserDTO userDTO);

    User toDomain(UserCreateDTO userCreateDTO);
    
}
