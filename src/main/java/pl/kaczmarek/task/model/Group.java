package pl.kaczmarek.task.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Getter
@Setter
@Data
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Size(min = 1,max = 10,message = "Nazwa grupy musi zawierać od 1 do 10 znaków")
    @Column(name = "name")
    private String name;

    @Column(name = "numer_of_users")
    private Integer numberOfUsers;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
        this.numberOfUsers = 0;
    }
}