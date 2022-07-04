package sagengaliyev.project.online_library.model;

import javax.persistence.*;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import sagengaliyev.project.online_library.model.User;

import java.time.LocalDate;

@Entity
@Data
@RequiredArgsConstructor
public class Booking {

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
