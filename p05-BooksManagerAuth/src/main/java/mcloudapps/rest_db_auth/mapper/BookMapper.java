package mcloudapps.rest_db_auth.mapper;

import org.mapstruct.Mapper;

import mcloudapps.rest_db_auth.dto.BookBasicDTO;
import mcloudapps.rest_db_auth.dto.BookCreateDTO;
import mcloudapps.rest_db_auth.dto.BookDTO;
import mcloudapps.rest_db_auth.model.Book;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", uses = {CommentMapper.class})
public interface BookMapper {

    BookDTO toDTO(Book book);

    Book toDomain(BookDTO bookDTO);

    Book toDomain(BookCreateDTO bookCreateDTO);

    BookBasicDTO toBasicDTO(Book book);

    List<BookDTO> toDTOs(Collection<Book> books);

}
