package pl.kaczmarek.task.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;



@Entity
@Getter
@Setter
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "numer_of_users")
    private Integer numberOfUsers;

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.numberOfUsers = 0;
    }


}
