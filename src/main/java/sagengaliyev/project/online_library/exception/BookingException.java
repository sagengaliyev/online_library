package sagengaliyev.project.online_library.exception;

import sagengaliyev.project.online_library.model.Book;

public class BookingException extends Throwable{
    public BookingException() {
        super("Book with this is ID bookId is already busy!");
    }

    public BookingException(String msg){
        super(msg);
    }
}
