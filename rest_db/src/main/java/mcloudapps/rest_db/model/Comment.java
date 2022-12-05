package mcloudapps.rest_db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private Long id;
    private Long bookId;
    private String text;
    private String userName;
    private Long rating;
}
