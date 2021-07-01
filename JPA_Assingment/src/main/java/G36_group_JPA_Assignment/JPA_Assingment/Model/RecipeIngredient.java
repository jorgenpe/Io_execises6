package G36_group_JPA_Assignment.JPA_Assingment.Model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "recipeIngredientId")
@Entity
public class RecipeIngredient {

    @Id
    @GeneratedValue(generator =  "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")


    private String recipeIngredientId;
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )

    //@JoinColumn(name = "recipe_ingredient_recipe",table = "Ingredient")
    private Ingredient ingredient;
    private double amount;
    private Measurement measurement;
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    private Recipe recipe;
}
