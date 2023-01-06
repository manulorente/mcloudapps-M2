package mcloudapps.rest_db.dto;

public record CommentDTO(
    Long id, 
    String text, 
    Long rating,
    Long userId,
    Long bookId
    ){
}
