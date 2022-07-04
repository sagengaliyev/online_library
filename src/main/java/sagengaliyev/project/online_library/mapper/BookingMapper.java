package sagengaliyev.project.online_library.mapper;

import sagengaliyev.project.online_library.dto.BookingDTO;
import sagengaliyev.project.online_library.model.Booking;

public class BookingMapper {
    public BookingDTO toDTO(Booking booking){
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setBook(booking.getBook());
        bookingDTO.setUser(booking.getUser());
        bookingDTO.setStartDate(booking.getStartDate());
        bookingDTO.setDeliveryDate(booking.getDeliveryDate());
        return bookingDTO;
    }
}
