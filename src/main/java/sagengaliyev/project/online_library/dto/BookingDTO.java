package sagengaliyev.project.online_library.dto;

import lombok.Data;
import sagengaliyev.project.online_library.model.Book;
import sagengaliyev.project.online_library.model.User;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
public class BookingDTO {
    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

    @Id
    long id;

    @Column(name="start_date")
    LocalDate startDate;

    @Column(name="delivery_date")
    LocalDate deliveryDate;
}
