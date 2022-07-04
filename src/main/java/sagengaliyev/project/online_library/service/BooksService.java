package sagengaliyev.project.online_library.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sagengaliyev.project.online_library.dto.BooksDTO;
import sagengaliyev.project.online_library.models.Book;
import sagengaliyev.project.online_library.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksService {
    private final BookRepository booksRepo;
    private final ModelMapper modelMapper;

    public BooksService(BookRepository booksRepo, ModelMapper modelMapper) {
        this.booksRepo = booksRepo;
        this.modelMapper = modelMapper;
    }

    public List<BooksDTO> getAllBooks(){
        return booksRepo.findAll().stream().map(this::convertBooksEntityToDTO).collect(Collectors.toList());
    }

    public void deleteBook(Book book){
        booksRepo.findById(book.getId());
        booksRepo.delete(book);
    }

    private BooksDTO convertBooksEntityToDTO(Book book){
        BooksDTO booksDTO = new BooksDTO();
        booksDTO.setId(book.getId());
        booksDTO.setName(book.getName());
        booksDTO.setAuthor(book.getAuthor());
        booksDTO.setDescription(book.getDescription());
        booksDTO.setMaintext(book.getMaintext());
        return booksDTO;
    }

}
