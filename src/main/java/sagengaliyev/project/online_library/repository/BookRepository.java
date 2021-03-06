package sagengaliyev.project.online_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sagengaliyev.project.online_library.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsById(long id);


}
