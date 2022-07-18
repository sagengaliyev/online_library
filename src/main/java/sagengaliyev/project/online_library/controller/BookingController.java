package sagengaliyev.project.online_library.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sagengaliyev.project.online_library.dto.BookingDTO;
import sagengaliyev.project.online_library.exception.BookingException;
import sagengaliyev.project.online_library.model.Booking;
import sagengaliyev.project.online_library.service.BookingService;

import java.net.http.HttpResponse;
import java.util.List;

@Slf4j
@Controller
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping(value = "/request",consumes = "application/json")
    @ResponseBody
    public String bookRequest(@RequestBody BookingDTO bookingDTO){

        return "User with the ID: " + bookingDTO.getUserId() + " took the book: " + bookingDTO.getBookId() +
                " on the date: " + bookingDTO.getStartDate() + " and must be return it on the date: " + bookingDTO.getDeliveryDate();
    }

    @PostMapping(value = "/record",consumes = "application/json")
    public ResponseEntity<String> saveRecord(@RequestBody BookingDTO bookingDTO) throws BookingException {
        String answer = bookingService.save(bookingDTO);
        return new ResponseEntity<String>(answer,HttpStatus.OK);
    }


    @PostMapping(value = "/pass",consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Booking> passBook(@RequestBody BookingDTO bookingDTO){
        bookingService.searchBookingByBook(bookingDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<List<BookingDTO>> getInfo (BookingDTO bookingDTO){
        List<BookingDTO> bookings = bookingService.getInfo();
        return new ResponseEntity<List<BookingDTO>>(bookings,HttpStatus.OK);
    }

    @PostMapping(value = "/personal",consumes = "application/json")
    @ResponseBody
    public ResponseEntity<List<Booking>> personalInfo(@RequestBody BookingDTO bookingDTO){
        List<Booking> bookings = bookingService.searchByUserId(bookingDTO);
        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
    }

    @PostMapping(value = "/validation",consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Integer> userValidation(@RequestBody BookingDTO bookingDTO){
        int numberOfBookings = bookingService.userValidation(bookingDTO);
        return new ResponseEntity<Integer>(numberOfBookings, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Integer> deleteBooking(@RequestBody BookingDTO bookingDTO){
        int result = bookingService.deleteBookingByStartDateAndFinishDate(bookingDTO);
        return new ResponseEntity<Integer>(result,HttpStatus.OK);
    }
}
