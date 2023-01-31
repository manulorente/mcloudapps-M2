package mcloudapps.rest_db_auth.dto;

public record CommentBasicDTO(
    Long id,
    String text,
    Long rating,
    Long userId
) {   
}
