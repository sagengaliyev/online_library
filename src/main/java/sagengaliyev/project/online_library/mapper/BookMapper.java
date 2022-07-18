package sagengaliyev.project.online_library.mapper;

import org.springframework.stereotype.Component;
import sagengaliyev.project.online_library.dto.BooksDTO;
import sagengaliyev.project.online_library.model.Book;

@Component
public class BookMapper {
    public BooksDTO toDTO(Book book){
        BooksDTO booksDTO = new BooksDTO();
        booksDTO.setId(book.getId());
        booksDTO.setName(book.getName());
        booksDTO.setAuthor(book.getAuthor());
        booksDTO.setDescription(book.getDescription());
        booksDTO.setMaintext(book.getMaintext());
        return booksDTO;
    }

    public Book toEntity(BooksDTO booksDTO){
        Book books = new Book();
        books.setId(booksDTO.getId());
        books.setName(booksDTO.getName());
        books.setAuthor(booksDTO.getAuthor());
        books.setDescription(booksDTO.getDescription());
        books.setMaintext(booksDTO.getMaintext());
        return books;
    }

    public Book toEntityFromId(long id) {
        Book book = new Book();
        book.setId(id);
        return book;
    }
}
