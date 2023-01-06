package mcloudapps.rest_db.mapper;

import org.mapstruct.Mapper;

import mcloudapps.rest_db.dto.UserCreateDTO;
import mcloudapps.rest_db.dto.UserDTO;
import mcloudapps.rest_db.model.User;

@Mapper(componentModel = "spring", uses = {CommentMapper.class})
public interface UserMapper {

    UserDTO toDTO(User user);

    User toDomain(UserDTO userDTO);

    User toDomain(UserCreateDTO userCreateDTO);
    
}
