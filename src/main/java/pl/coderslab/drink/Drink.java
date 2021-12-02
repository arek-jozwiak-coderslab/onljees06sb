package pl.coderslab.drink;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int volume;

    @ManyToOne
    private User user;
}
