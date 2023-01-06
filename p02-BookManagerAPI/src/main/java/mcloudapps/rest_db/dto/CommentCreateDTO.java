package mcloudapps.rest_db.dto;

public record CommentCreateDTO(
    String text, 
    Long rating, 
    long userId, 
    long bookId
    ) {
}