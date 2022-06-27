package sagengaliyev.project.online_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sagengaliyev.project.online_library.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
