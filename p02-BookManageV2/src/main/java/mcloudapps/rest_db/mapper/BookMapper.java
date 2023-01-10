package mcloudapps.rest_db.mapper;

import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

import mcloudapps.rest_db.dto.BookDTO;
import mcloudapps.rest_db.dto.BookCreateDTO;
import mcloudapps.rest_db.model.Book;

@Mapper(componentModel = "spring", uses = {CommentMapper.class})
public interface BookMapper {

    BookDTO toDTO(Book book);

    List<BookDTO> toDTOs(Collection<Book> books);

    Book toDomain(BookDTO bookDTO);

    Book toDomain(BookCreateDTO bookCreateDTO);

}
