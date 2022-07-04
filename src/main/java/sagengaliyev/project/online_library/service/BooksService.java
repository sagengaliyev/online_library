package sagengaliyev.project.online_library.service;

import org.modelmapper.ModelMapper;
import sagengaliyev.project.online_library.dto.BooksDTO;
import sagengaliyev.project.online_library.models.Book;
import sagengaliyev.project.online_library.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

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
