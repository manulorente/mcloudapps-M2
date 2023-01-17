package mcloudapps.rest_db_auth.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mcloudapps.rest_db_auth.dto.CommentDTO;
import mcloudapps.rest_db_auth.dto.UserCreateDTO;
import mcloudapps.rest_db_auth.dto.UserDTO;
import mcloudapps.rest_db_auth.mapper.CommentMapper;
import mcloudapps.rest_db_auth.mapper.UserMapper;
import mcloudapps.rest_db_auth.model.Comment;
import mcloudapps.rest_db_auth.model.User;
import mcloudapps.rest_db_auth.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final CommentMapper commentMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, CommentMapper commentMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.commentMapper = commentMapper;
        this.userRepository = userRepository;
    }

    public boolean existsByUsername(String username) {
        return this.userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    public UserDTO save(UserCreateDTO userCreateDTO) {
        User user = userMapper.toDomain(userCreateDTO);
        return this.userMapper.toDTO(this.userRepository.save(user));
    }

    public Page<UserDTO> findAll(Pageable pageable) {
        return this.userRepository.findAll(pageable).map(this.userMapper::toDTO);
    }

    public User findById(long id) {
        return this.userRepository.findById(id).orElseThrow();
    }

    public UserDTO findByIdDTO(long id) {
        return this.userMapper.toDTO(this.userRepository.findById(id).orElseThrow());
    }

    public Page<CommentDTO> findAllByUserId(long id) {
        List<Comment> comments = this.userRepository.findById(id).orElseThrow().getComments();
        return new PageImpl<>(this.commentMapper.toDTOs(comments));
    }

    public UserDTO replace(UserCreateDTO userCreateDTO, long id) {
        User newUser = this.userMapper.toDomain(userCreateDTO);
        this.userRepository.findById(id).orElseThrow();
        newUser.setId(id);
        return this.userMapper.toDTO(this.userRepository.save(newUser));
    }

    public UserDTO delete(long id) {
        User user = this.userRepository.findById(id).orElseThrow();
        this.userRepository.deleteById(id);
        return this.userMapper.toDTO(user);
    }


}
