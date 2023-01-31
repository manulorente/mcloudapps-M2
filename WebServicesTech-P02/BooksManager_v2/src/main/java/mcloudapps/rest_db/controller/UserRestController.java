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

import mcloudapps.rest_db.dto.UserDTO;
import mcloudapps.rest_db.dto.CommentDTO;
import mcloudapps.rest_db.dto.UserCreateDTO;
import mcloudapps.rest_db.service.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get all users")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found all users", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))) }) })
    @GetMapping("/")
    public ResponseEntity<Page<UserDTO>> getAllUsers(Pageable pageable) {
        return ResponseEntity.ok(this.userService.findAll(pageable));
    }

    @Operation(summary = "Get a user by id")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found the user", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid format id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(this.userService.findByIdDTO(id));
    }
    
    @Operation(summary = "Get all comments of a user")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found all comments of the user", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CommentDTO.class))) }),
            @ApiResponse(responseCode = "400", description = "Invalid format id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
    @GetMapping("/{id}/comments")
    public ResponseEntity<Page<CommentDTO>> getAllCommentsOfUser(@PathVariable long id) {
        return ResponseEntity.ok(this.userService.findAllByUserId(id));
    }

    @Operation(summary = "Create a user")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "User created", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid user supplied", content = @Content) })
    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        UserDTO userDTO = this.userService.save(userCreateDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.id())
                .toUri();
        return ResponseEntity.created(location).body(userDTO);
    }

    @Operation(summary = "Update a user")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "User updated", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid user supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable long id, @Valid @RequestBody UserCreateDTO userCreateDTO) {
        return ResponseEntity.ok(this.userService.replace(userCreateDTO, id));
    }

    @Operation(summary = "Delete a user")
    @ApiResponses(value = { @ApiResponse(responseCode = "204", description = "User deleted", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid format id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable long id) {
        return ResponseEntity.ok(this.userService.delete(id));
    }
}
