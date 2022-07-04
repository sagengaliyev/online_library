package sagengaliyev.project.online_library.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sagengaliyev.project.online_library.dto.BooksDTO;
import sagengaliyev.project.online_library.exception.BooksException;
import sagengaliyev.project.online_library.model.Book;
import sagengaliyev.project.online_library.repository.BookRepository;
import sagengaliyev.project.online_library.service.BooksService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class BooksController {


    private final BookRepository bookRepo;
    private final BooksService booksService;
    public BooksController(BookRepository bookRepo, BooksService booksService) {
        this.bookRepo = bookRepo;
        this.booksService = booksService;
    }

//    @GetMapping("/books")
//    public ResponseEntity<List<Book>> booksPage() {
//        List<Book> books = bookRepo.findAll();
////        model.addAttribute("books", books);
//        return new ResponseEntity<>(books, HttpStatus.OK);
//    }

    @GetMapping("/allbooks")
    public ResponseEntity<List<BooksDTO>> getAllBooks(){
        log.info("Get a list of books");
        return new ResponseEntity<>(booksService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/books/add")
    public String addBook(Model model){
        return "add-book";
    }

    @PostMapping("/books/add")
    public ResponseEntity<String> addNewBook(@RequestParam String name,@RequestParam String author,@RequestParam String description,@RequestParam String maintext){
        Book book = new Book(name, author,description,maintext);
        bookRepo.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/books/{id}/delete")
    public ResponseEntity<List<Book>> deleteBook(@PathVariable(value = "id") long id, Model model) throws BooksException {
        booksService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @GetMapping("/books/{id}/update")
    public String updateBook(@PathVariable(value = "id") long id, Model model){
        if(!bookRepo.existsById(id)){
            return "redirect:/books";
        }
        Optional<Book> book = bookRepo.findById(id);
        ArrayList <Book> res = new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book", res);
        return "update-book";
    }


//    @PostMapping("/books/{id}/update")
//    public String updateTheBook(){
//        return "update-book";
//    }


}


