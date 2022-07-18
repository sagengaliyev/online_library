package sagengaliyev.project.online_library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import sagengaliyev.project.online_library.model.Book;
import sagengaliyev.project.online_library.model.User;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
public class BookingDTO {

    private long userId;
    private long bookId;
    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate deliveryDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate finishDate;

    public BookingDTO(long userId, long bookId, LocalDate startDate, LocalDate deliveryDate, LocalDate finishDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.startDate = startDate;
        this.deliveryDate = deliveryDate;
        this.finishDate=finishDate;
    }

    public BookingDTO(long userId, long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public BookingDTO() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public LocalDate getStartDate() {
        return startDate;
    }


    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }
}
