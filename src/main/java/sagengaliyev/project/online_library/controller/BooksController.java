package sagengaliyev.project.online_library;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sagengaliyev.project.online_library.dto.BooksDTO;
import sagengaliyev.project.online_library.models.Book;
import sagengaliyev.project.online_library.repository.BookRepository;
import sagengaliyev.project.online_library.service.BooksService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return new ResponseEntity<>(booksService.getAllBooks(), HttpStatus.OK);
    }
//    @GetMapping("/books/{id}")
//    public ResponseEntity<String> fullBookInfo(@PathVariable(value = "id") long id, Model model){
////        if(!bookRepo.existsById(id)){
////            return "redirect:/books";
////        }
//
//        Optional<Book> book = bookRepo.findById(id);
//        ArrayList <Book> res = new ArrayList<>();
//        book.ifPresent(res::add);
//        model.addAttribute("book", res);
//        ResponseEntity<ArrayList<Book>> arrayListResponseEntity = new ResponseEntity<>(res, HttpStatus.OK);
//        return new ResponseEntity<>(ArrayList<book>, HttpStatus.OK);
//    }
    @GetMapping("/books/add")
    public String addBook(Model model){
        return "add-book";
    }

    @PostMapping("/books/add")
    public String addNewBook(@RequestParam String name,@RequestParam String author,@RequestParam String description,@RequestParam String maintext){
        Book book = new Book(name, author,description,maintext);
        bookRepo.save(book);
        return "redirect:/books";
    }
    @PostMapping("/books/{id}/delete")
    public String deleteBook(@PathVariable(value = "id") long id, Model model){
        Book book = bookRepo.findById(id).orElseThrow();
        bookRepo.delete(book);
        return "redirect:/books";
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


