package sagengaliyev.project.online_library.repository;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import sagengaliyev.project.online_library.model.Booking;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

//    @Query("SELECT * FROM booking")
//    String getBookingById(booking_id);

    @Query(value = "SELECT b FROM Booking b  where b.user.id = :userId and b.book.id =:bookId and b.finishDate = null")
    Booking searchBookingByBook(@Param("userId") long userId, @Param("bookId") long bookId );

    @Query(value="select b from Booking b where b.user.id = :userId and b.book.id =:bookId and b.deliveryDate = b.finishDate")
    Booking verifyUser(@Param("userId") long userId, @Param("bookId") long bookId);

    @Query(value = "select b from Booking b where b.user.id = :userId")
    List<Booking> getBookingByUserId(@Param("userId") long userId);

    @Query(value = "select count(b.id) from Booking b where b.user.id = :userId and b.finishDate > b.deliveryDate")
    int userValidation(@Param("userId") long userId);

    @Modifying
    @Transactional
    @Query(value = "delete from Booking b where b.startDate between :startDate and :finishDate")
    Integer deleteBookingByStartDateAndFinishDate(@Param("startDate") LocalDate startDate, @Param("finishDate")  LocalDate finishDate);
}
