package mcloudapps.rest_db.model;

import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id;
    private String title;
    private String summary;
    private String author;
    private String publisher;
    private String date;
    private @Builder.Default Collection<Comment> comments = List.of();
}
