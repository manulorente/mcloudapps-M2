package mcloudapps.rest_db_auth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import mcloudapps.rest_db_auth.dto.CommentBasicDTO;
import mcloudapps.rest_db_auth.dto.CommentCreateDTO;
import mcloudapps.rest_db_auth.dto.CommentDTO;
import mcloudapps.rest_db_auth.model.Comment;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(source = "username.id", target = "userId")
    @Mapping(source = "book.id", target = "bookId")
    CommentDTO toDTO(Comment comment);

    List<CommentDTO> toDTOs(Collection<Comment> comments);

    Comment toDomain(CommentDTO commentDTO);

    Comment toDomain(CommentCreateDTO commentCreateDTO);  
    
    @Mapping(source = "username.id", target = "userId")
    CommentBasicDTO toBasicDTO(Comment comment);
    
}
