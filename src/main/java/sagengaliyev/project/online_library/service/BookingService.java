package sagengaliyev.project.online_library.service;

import org.springframework.stereotype.Service;

import sagengaliyev.project.online_library.dto.BookingDTO;
import sagengaliyev.project.online_library.exception.BookingException;
import sagengaliyev.project.online_library.mapper.BookingMapper;
import sagengaliyev.project.online_library.model.Booking;
import sagengaliyev.project.online_library.repository.BookingRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    private Booking booking;
    public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    public List<BookingDTO> getInfo() {
        return bookingRepository.findAll()
                .stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String save(BookingDTO bookingDTO) throws BookingException {
        long bookId = bookingDTO.getBookId();
        long userId = bookingDTO.getUserId();
        int numberOFDelay = userValidation(bookingDTO);
        if(numberOFDelay >= 3) {
            return "Sorry we cannot give you book because of exceeded the delay limit";
        } else {
            Booking booking = bookingMapper.toEntity(bookingDTO);
            checkUser(bookingDTO);
            LocalDate bookingDate = LocalDate.now();
            booking.setStartDate(bookingDate);
            LocalDate deliveryDate = bookingDate.plusDays(7);
            booking.setDeliveryDate(deliveryDate);
            bookingRepository.save(booking);
            return "Congrats! You successfully took this book!";
        }
    }

    public boolean bookingIsExists(BookingDTO bookingDTO) {
        //if finishDate == null
        long bookId = bookingDTO.getBookId();
        long userId = bookingDTO.getUserId();
        Booking booking = bookingRepository.searchBookingByBook(userId,bookId);
        if(booking==null){
            return false;
        } else {
            return true;
        }

    }

    public void searchBookingByBook(BookingDTO bookingDTO){
        long bookId = bookingDTO.getBookId();
        long userId = bookingDTO.getUserId();
        Booking booking = bookingRepository.searchBookingByBook(userId, bookId);
        booking.setFinishDate(LocalDate.now());
        bookingRepository.save(booking);
    }

//   public void passBook(BookingDTO bookingDTO){
//       long bookId = bookingDTO.getBookId();
//       long userId = bookingDTO.getUserId();
//       List<Booking> bookings = getAllById(bookingDTO);
//       if(!bookings) {
//           bookingRepository.save(booking);
//       }
//    try {
//        boolean bookIsExists = bookingIsExists(bookingDTO);
//        if(bookIsExists) {
//            throw new BookingException("Book with this is ID: is already busy");
//        }
//    }
//        catch (BookingException e){
//        System.out.println(e.getMessage());
//    }
//   }

    public void checkUser(BookingDTO bookingDTO){
        long bookId = bookingDTO.getBookId();
        long userId = bookingDTO.getUserId();
        Booking booking = bookingRepository.verifyUser(userId, bookId);
        if(booking!=null){
            System.out.println("You can take the book");
        } else {
            System.out.println("Sorry, we can not give you book");
        }
    }

    public List<Booking> searchByUserId(BookingDTO bookingDTO){
        long userId = bookingDTO.getUserId();
        List<Booking> booking = bookingRepository.getBookingByUserId(userId);
        return booking;
    }

    public int userValidation(BookingDTO bookingDTO){
        long userId = bookingDTO.getUserId();
        int booking = bookingRepository.userValidation(userId);
        return booking;
    }

    public Integer deleteBookingByStartDateAndFinishDate(BookingDTO  bookingDTO ){
        LocalDate startDate = bookingDTO.getStartDate();
        LocalDate finishDate = bookingDTO.getFinishDate();
        int res = bookingRepository.deleteBookingByStartDateAndFinishDate(startDate,finishDate);
        if(res==0){
            System.out.println("There are no  such records with this date range");
        } else {
        System.out.println("Your data has been deleted successfully!");
        }
        return res;

    }


}
