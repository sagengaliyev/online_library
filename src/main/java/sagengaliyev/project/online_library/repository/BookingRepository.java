package sagengaliyev.project.online_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sagengaliyev.project.online_library.model.Book;
import sagengaliyev.project.online_library.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
