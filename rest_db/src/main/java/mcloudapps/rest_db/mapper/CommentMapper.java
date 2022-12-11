package mcloudapps.rest_db.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

import mcloudapps.rest_db.dto.CommentDTO;
import mcloudapps.rest_db.dto.CommentCreateDTO;
import mcloudapps.rest_db.model.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(source = "userName.id", target = "userId")
    @Mapping(source = "book.id", target = "bookId")
    CommentDTO toDTO(Comment comment);

    List<CommentDTO> toDTOs(Collection<Comment> comments);

    Comment toDomain(CommentDTO commentDTO);

    Comment toDomain(CommentCreateDTO commentCreateDTO);    
    
}
