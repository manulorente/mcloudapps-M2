package mcloudapps.rest_db.controller;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.net.URI;

import jakarta.validation.Valid;

import mcloudapps.rest_db.dto.CommentDTO;
import mcloudapps.rest_db.dto.CommentCreateDTO;
import mcloudapps.rest_db.service.CommentService;

@RestController
@RequestMapping("api/v1/comments")
public class CommentRestController {
    
    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(summary = "Get all comments")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found all comments", content = {
        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CommentDTO.class))) }) })
    @GetMapping("/")
    public ResponseEntity<Page<CommentDTO>> getAllComments(Pageable pageable) {
        return ResponseEntity.ok(this.commentService.findAll(pageable));
    }

    @Operation(summary = "Get a comment by id")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found the comment", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = CommentDTO.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid format id supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Comment not found", content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById( @PathVariable Long id) {
        return ResponseEntity.ok(this.commentService.findById(id));
    }

    @Operation(summary = "Add a comment to a book")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Added the comment", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = CommentDTO.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid comment attributes supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })
    @PostMapping("/")
    public ResponseEntity<CommentDTO> addComment(@Valid @RequestBody CommentCreateDTO commentCreateDTO) {
        CommentDTO commentDTO = this.commentService.save(commentCreateDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(commentDTO.id()).toUri();
        return ResponseEntity.created(location).body(commentDTO);
    }

    @Operation(summary = "Update a comment")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Updated the comment", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = CommentDTO.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid comment attributes supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Comment not found", content = @Content) })
    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id, @Valid @RequestBody CommentCreateDTO commentCreateDTO) {
        return ResponseEntity.ok(this.commentService.replace(commentCreateDTO, id));
    }

    @Operation(summary = "Delete a comment")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Deleted the comment", content = @Content),
        @ApiResponse(responseCode = "400", description = "Invalid format id supplied", content = @Content),
        @ApiResponse(responseCode = "404", description = "Comment not found", content = @Content) })
    @DeleteMapping("/{id}")
    public ResponseEntity<CommentDTO> deleteComment(@PathVariable Long id) {
        return ResponseEntity.ok(this.commentService.delete(id));
    }
}
