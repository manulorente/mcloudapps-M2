package mcloudapps.rest_db.service;

import mcloudapps.rest_db.dto.CommentDTO;
import mcloudapps.rest_db.dto.UserDTO;
import mcloudapps.rest_db.dto.UserCreateDTO;
import mcloudapps.rest_db.mapper.UserMapper;
import mcloudapps.rest_db.mapper.CommentMapper;
import mcloudapps.rest_db.model.Comment;
import mcloudapps.rest_db.model.User;
import mcloudapps.rest_db.repository.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public UserDTO save(UserCreateDTO userCreateDTO) {
        User user = userMapper.toDomain(userCreateDTO);
        return userMapper.toDTO(userRepository.save(user));
    }

    public Page<UserDTO> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDTO);
    }

    public User findById(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public UserDTO findByIdDTO(long id) {
        return userMapper.toDTO(userRepository.findById(id).orElseThrow());
    }

    public Page<CommentDTO> findAllByUserId(long id) {
        List<Comment> comments = userRepository.findById(id).orElseThrow().getComments();
        return new PageImpl<>(commentMapper.toDTOs(comments));
    }

    public UserDTO replace(UserCreateDTO userCreateDTO, long id) {
        User newUser = userMapper.toDomain(userCreateDTO);
        userRepository.findById(id).orElseThrow();
        newUser.setId(id);
        userRepository.save(newUser);
        return userMapper.toDTO(newUser);
    }

    public UserDTO delete(long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);
        return userMapper.toDTO(user);
    }


}
