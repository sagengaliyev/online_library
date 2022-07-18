package sagengaliyev.project.online_library.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sagengaliyev.project.online_library.dto.BooksDTO;
import sagengaliyev.project.online_library.exception.BooksException;
import sagengaliyev.project.online_library.mapper.BookMapper;
import sagengaliyev.project.online_library.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BooksService {
    private final BookRepository booksRepo;
    private final BookMapper bookMapper;

    public List<BooksDTO> getAllBooks() {
        return booksRepo.findAll()
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * @param id
     * @throws BooksException
     */
    public void delete(long id) throws BooksException {
        if (!booksRepo.existsById(id)) {
            throw new BooksException(String.format("Book with ID %d not found!", id));
        }
        booksRepo.deleteById(id);
    }



}
