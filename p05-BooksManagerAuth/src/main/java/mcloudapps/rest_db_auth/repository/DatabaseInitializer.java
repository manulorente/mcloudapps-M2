package mcloudapps.rest_db_auth.repository;

import jakarta.annotation.PostConstruct;
import mcloudapps.rest_db_auth.model.Book;
import mcloudapps.rest_db_auth.model.Comment;
import mcloudapps.rest_db_auth.model.Eroles;
import mcloudapps.rest_db_auth.model.Role;
import mcloudapps.rest_db_auth.model.User;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {
    private final PasswordEncoder encoder;
    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DatabaseInitializer(BookRepository bookRepository, CommentRepository commentRepository, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.bookRepository = bookRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }
    @PostConstruct
    public void init() {
        User user1 = new User("Pablo", "pablo@gmal.com", this.encoder.encode("1234"));
        User user2 = new User("Jesus", "jesus@gmail.com", this.encoder.encode("1234"));

        Book book1 = new Book("Tomás Nevinson",
                "Dos hombres, uno en la ficción y otro en la realidad...",
                "Javier Marías",
                "Alfaguara",
                "2021");

        Book book2 = new Book("Los vencejos",
                "Una espléndida novela humanista sobre la dignidad y la esperanza",
                "Fernando Aramburu",
                "TUSQUETS EDITORES",
                "2021");

        Comment comment1 = new Comment("Me ha gustado mucho", 4, user1, book1);
        Comment comment2 = new Comment("Me ha gustado poco", 2, user2, book1);
        Comment comment3 = new Comment("Me ha gustado mucho", 4, user1, book2);
        Comment comment4 = new Comment("Me ha gustado poco", 2, user2, book2);

        Role role1 = new Role(Eroles.ROLE_USER);
        Role role2 = new Role(Eroles.ROLE_ADMIN);

        book1.getComments().add(comment1);
        book1.getComments().add(comment2);
        book2.getComments().add(comment3);
        book2.getComments().add(comment4);

        user1.getComments().add(comment1);
        user1.getComments().add(comment3);
        user2.getComments().add(comment2);
        user2.getComments().add(comment4);

        user1.getRoles().add(role1);
        user2.getRoles().add(role2);

        this.bookRepository.save(book1);
        this.bookRepository.save(book2);

        this.commentRepository.save(comment1);
        this.commentRepository.save(comment2);
        this.commentRepository.save(comment3);
        this.commentRepository.save(comment4);

        this.userRepository.save(user1);
        this.userRepository.save(user2);

        this.roleRepository.save(role1);
        this.roleRepository.save(role2);
    }
}
