package sagengaliyev.project.online_library.dto;

import lombok.Data;

@Data
public class BooksDTO {
    private long id;
    private String name;
    private String author;
    private String  description;
    private String maintext;
}
