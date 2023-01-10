package mcloudapps.rest_db.service;

import mcloudapps.rest_db.dto.CommentDTO;
import mcloudapps.rest_db.dto.CommentCreateDTO;
import mcloudapps.rest_db.mapper.CommentMapper;
import mcloudapps.rest_db.model.Comment;
import mcloudapps.rest_db.repository.CommentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;

    private final BookService bookService;
    private final UserService userService;

    public CommentService(CommentMapper commentMapper, CommentRepository commentRepository, BookService bookService, UserService userService) {
        this.commentMapper = commentMapper;
        this.commentRepository = commentRepository;
        this.bookService = bookService;
        this.userService = userService;
    }

    public CommentDTO save(CommentCreateDTO commentCreateDTO) {
        Comment comment = commentMapper.toDomain(commentCreateDTO);
        comment.setBook(bookService.findById(commentCreateDTO.bookId()));
        comment.setUserName(userService.findById(commentCreateDTO.userId()));
        return commentMapper.toDTO(commentRepository.save(comment));
    }

    public Page<CommentDTO> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable).map(commentMapper::toDTO);
    }

    public CommentDTO findById(long id) {
        return commentMapper.toDTO(commentRepository.findById(id).orElseThrow());
    }
    
    public CommentDTO replace(CommentCreateDTO commentCreateDTO, long id) {
        Comment newComment = commentMapper.toDomain(commentCreateDTO);
        Comment oldComment = commentRepository.findById(id).orElseThrow();
        newComment.setId(id);
        newComment.setBook(oldComment.getBook());
        newComment.setUserName(oldComment.getUserName());
        commentRepository.save(newComment);
        return commentMapper.toDTO(newComment);
    }

    public CommentDTO delete(long id) {
        Comment comment = commentRepository.findById(id).orElseThrow();
        commentRepository.deleteById(id);
        return commentMapper.toDTO(comment);
    }
}
