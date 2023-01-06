package mcloudapps.rest_db.dto;

public record BookCreateDTO(
    String title, 
    String summary, 
    String author, 
    String publisher, 
    String date
    ) {
}