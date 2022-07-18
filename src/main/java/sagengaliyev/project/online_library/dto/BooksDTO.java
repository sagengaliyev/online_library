package sagengaliyev.project.online_library.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class BooksDTO {
    @Id
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="author")
    private String author;
    @Column(name="description")
    private String  description;
    @Column(name="maintext")
    private String maintext;
}
