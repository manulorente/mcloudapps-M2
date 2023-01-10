package mcloudapps.rest_db.dto;

import java.util.List;

public record BookDTO(
    Long id, 
    String title, 
    String summary, 
    String author, 
    String publisher, 
    String date, 
    List<CommentDTO> comments
    ){
}