package mcloudapps.rest_db_auth.dto;

public record CommentCreateDTO(
    String text, 
    Long rating, 
    Long userId, 
    Long bookId
    ) {
}