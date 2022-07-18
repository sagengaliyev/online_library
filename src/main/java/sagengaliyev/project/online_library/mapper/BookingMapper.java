package sagengaliyev.project.online_library.mapper;

import org.springframework.stereotype.Component;
import sagengaliyev.project.online_library.dto.BookingDTO;
import sagengaliyev.project.online_library.model.Book;
import sagengaliyev.project.online_library.model.Booking;

@Component
public class BookingMapper {
    private final BookMapper bookMapper;
    private final UserMapper userMapper;

    public BookingMapper(BookMapper bookMapper, UserMapper userMapper) {
        this.bookMapper = bookMapper;
        this.userMapper = userMapper;
    }

    public BookingDTO toDTO(Booking booking){
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setBookId(booking.getBook().getId());
        bookingDTO.setUserId(booking.getUser().getId());
        bookingDTO.setStartDate(booking.getStartDate());
        bookingDTO.setDeliveryDate(booking.getDeliveryDate());
        bookingDTO.setFinishDate(booking.getFinishDate());
        return bookingDTO;
    }

    public Booking toEntity(BookingDTO bookingDTO){
        Booking booking = new Booking();
        booking.setId(booking.getId());
        booking.setBook(bookMapper.toEntityFromId(bookingDTO.getBookId()));
        booking.setUser(userMapper.toEntityFromId(bookingDTO.getUserId()));
        booking.setStartDate(bookingDTO.getStartDate());
        booking.setDeliveryDate(bookingDTO.getDeliveryDate());
        booking.setFinishDate(bookingDTO.getFinishDate());
        return booking;

    }
}
