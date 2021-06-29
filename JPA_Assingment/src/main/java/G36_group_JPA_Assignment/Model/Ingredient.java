package G36_group_JPA_Assignment.Model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "ingredientId")
@Entity

public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int ingredientId;
    private String ingredientName;
}
